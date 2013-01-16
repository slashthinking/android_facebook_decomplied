package com.facebook.orca.cache;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessageBuilder;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;

public class SendMessageManager
{
  private static final Class<?> a = SendMessageManager.class;
  private final OrcaActivityBroadcaster b;
  private final Provider<OrcaServiceOperation> c;
  private final OrcaNotificationManager d;
  private final AndroidThreadUtil e;
  private final ThreadsCache f;
  private final AnalyticsLogger g;
  private final Clock h;
  private final Clock i;
  private final LinkedHashMultimap<String, Message> j;
  private final LinkedHashMultimap<String, Message> k;
  private final LinkedHashSet<String> l;
  private final Map<String, Long> m;
  private final Map<String, ServiceException> n;
  private final Set<String> o;
  private boolean p;

  public SendMessageManager(OrcaActivityBroadcaster paramOrcaActivityBroadcaster, Provider<OrcaServiceOperation> paramProvider, OrcaNotificationManager paramOrcaNotificationManager, AndroidThreadUtil paramAndroidThreadUtil, ThreadsCache paramThreadsCache, AnalyticsLogger paramAnalyticsLogger, Clock paramClock1, Clock paramClock2)
  {
    this.b = paramOrcaActivityBroadcaster;
    this.c = paramProvider;
    this.d = paramOrcaNotificationManager;
    this.e = paramAndroidThreadUtil;
    this.f = paramThreadsCache;
    this.g = paramAnalyticsLogger;
    this.h = paramClock1;
    this.i = paramClock2;
    this.j = LinkedHashMultimap.m();
    this.k = LinkedHashMultimap.m();
    this.l = Sets.b();
    this.m = new MapMaker().a(300L, TimeUnit.SECONDS).n();
    this.n = new MapMaker().a(600L, TimeUnit.SECONDS).n();
    this.o = Sets.a();
  }

  private Message a(Message paramMessage, boolean paramBoolean)
  {
    this.o.remove(paramMessage.t());
    this.e.a();
    String str = paramMessage.b();
    b(paramMessage);
    if (!paramBoolean)
      this.j.a(str).add(paramMessage);
    OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.c.b();
    localOrcaServiceOperation.a(new SendMessageManager.1(this, paramMessage, paramBoolean));
    localOrcaServiceOperation.b(true);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("outgoingMessage", paramMessage);
    localOrcaServiceOperation.a("queue_message", localBundle);
    this.m.put(paramMessage.t(), Long.valueOf(this.i.a()));
    this.b.b(str);
    return paramMessage;
  }

  private void a()
  {
    this.e.a();
    if (this.p);
    while (true)
    {
      return;
      String str = b();
      if (str == null)
        continue;
      OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.c.b();
      localOrcaServiceOperation.a(new SendMessageManager.2(this, str));
      localOrcaServiceOperation.b(true);
      Bundle localBundle = new Bundle();
      localBundle.putString("threadId", str);
      localOrcaServiceOperation.a("send", localBundle);
      this.p = true;
    }
  }

  private void a(ServiceException paramServiceException, Message paramMessage)
  {
    this.e.a();
    String str = paramMessage.b();
    this.j.c(str, paramMessage);
    this.b.b(str);
  }

  private void a(OperationResult paramOperationResult)
  {
    this.e.a();
    this.p = false;
    Bundle localBundle = paramOperationResult.g();
    if ((localBundle != null) && (localBundle.getBoolean("hasMoreQueuedMessages")))
      this.l.add(localBundle.getString("threadId"));
    a();
  }

  private void a(OperationResult paramOperationResult, Message paramMessage, boolean paramBoolean)
  {
    this.e.a();
    String str = paramMessage.b();
    if ((this.j.c(str, paramMessage)) || (paramBoolean))
    {
      this.l.add(paramMessage.b());
      this.k.a(str, paramMessage);
    }
    a();
    this.b.b(str);
  }

  private String b()
  {
    this.e.a();
    boolean bool1 = this.l.isEmpty();
    String str = null;
    if (bool1);
    while (true)
    {
      return str;
      Iterator localIterator = this.l.iterator();
      boolean bool2 = localIterator.hasNext();
      str = null;
      if (!bool2)
        continue;
      str = (String)localIterator.next();
      localIterator.remove();
    }
  }

  private void b(Message paramMessage)
  {
    Iterator localIterator = this.k.a(paramMessage.b()).iterator();
    while (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      if ((!localMessage.u()) || (!paramMessage.u()) || (!Objects.equal(localMessage.t(), paramMessage.t())))
        continue;
      BLog.a(a, "Clearing out equivalent sent message %s", new Object[] { paramMessage });
      localIterator.remove();
    }
  }

  private void b(Message paramMessage, String paramString1, String paramString2)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("send_message").f(paramMessage.a()).d(paramString1).b("thread", paramMessage.b()).b("trigger", paramString2);
    this.g.a(localHoneyClientEvent);
  }

  private void d(String paramString)
  {
    if (!this.k.d(paramString));
    while (true)
    {
      return;
      Iterator localIterator = this.k.a(paramString).iterator();
      long l1 = this.i.a();
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        Long localLong = (Long)this.m.get(localMessage.t());
        if ((localLong != null) && (l1 - localLong.longValue() <= 30000L))
          continue;
        BLog.a(a, "Clearing out expired recently sent message %s", new Object[] { localMessage });
        localIterator.remove();
      }
    }
  }

  public Message a(Message paramMessage)
  {
    long l1 = this.h.a();
    return a(new MessageBuilder().a(paramMessage).a(900).a(l1).b(l1).v(), true);
  }

  public Message a(Message paramMessage, String paramString1, String paramString2)
  {
    b(paramMessage, paramString1, paramString2);
    return a(paramMessage, false);
  }

  public List<Message> a(String paramString)
  {
    this.e.a();
    d(paramString);
    return Lists.a(Lists.a(Iterables.a(this.k.a(paramString), this.j.a(paramString))));
  }

  void a(String paramString, ServiceException paramServiceException)
  {
    this.e.a();
    this.p = false;
    this.n.put(paramString, paramServiceException);
    a();
    Bundle localBundle = paramServiceException.b().g();
    Parcelable localParcelable;
    if (localBundle != null)
    {
      localParcelable = localBundle.getParcelable("result");
      if (!(localParcelable instanceof Message));
    }
    for (Message localMessage = (Message)localParcelable; ; localMessage = null)
    {
      if ((localMessage == null) || (localMessage.t() == null))
        this.d.a(paramString);
      while (true)
      {
        return;
        String str = localMessage.t();
        if (!this.o.add(str))
          continue;
        this.e.a(new SendMessageManager.3(this, str, paramString), 10000L);
      }
    }
  }

  public void a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.k.a(paramString1).iterator();
    while (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      if ((!localMessage.u()) || (StringUtil.a(paramString2)) || (!Objects.equal(localMessage.t(), paramString2)))
        continue;
      BLog.a(a, "Clearing out sent message with offlineThreadId %s", new Object[] { paramString2 });
      localIterator.remove();
    }
  }

  public ServiceException b(String paramString)
  {
    return (ServiceException)this.n.get(paramString);
  }

  protected void c(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("spurious_send_failure");
    localHoneyClientEvent.b("thread_id", paramString);
    this.g.a(localHoneyClientEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.SendMessageManager
 * JD-Core Version:    0.6.0
 */