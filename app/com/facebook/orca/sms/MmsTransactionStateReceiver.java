package com.facebook.orca.sms;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android_src.provider.Telephony.Mms.Inbox;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.cache.ReadThreadManager;
import com.facebook.orca.common.OrcaWakeLockManager.WakeLock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.push.PushHandler;
import com.facebook.orca.push.PushSource;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.ParticipantInfo;
import java.util.Iterator;
import java.util.Set;

public class MmsTransactionStateReceiver extends IntentService
{
  private static final Class<?> a = MmsTransactionStateReceiver.class;
  private MmsTransactionStateReceiverWakeLockHolder b;
  private MmsContentResolverHandler c;
  private Set<PushHandler> d;
  private MmsSmsLogger e;
  private ReadThreadManager f;

  public MmsTransactionStateReceiver()
  {
    super("MmsTransactionStateReceiver");
  }

  private void a(long paramLong)
  {
    Message localMessage1 = this.c.a(paramLong);
    this.e.a(localMessage1.b(), paramLong, true);
    if (localMessage1 != null)
    {
      this.f.a(localMessage1.b(), localMessage1.p() - 1L);
      String str = localMessage1.f().d() + ": " + localMessage1.h();
      Message localMessage2 = new MessageBuilder().a(localMessage1).d(localMessage1.c()).v();
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
        ((PushHandler)localIterator.next()).a(str, localMessage1.b(), localMessage2, PushSource.MMS);
    }
    BLog.e(a, "Could not find specified Mms Message with the id: " + paramLong);
  }

  static void a(Context paramContext, Intent paramIntent)
  {
    ((MmsTransactionStateReceiverWakeLockHolder)FbInjector.a(paramContext).a(MmsTransactionStateReceiverWakeLockHolder.class)).a.a();
    paramIntent.setClassName(paramContext, MmsTransactionStateReceiver.class.getName());
    paramContext.startService(paramIntent);
  }

  private boolean a(Uri paramUri1, Uri paramUri2)
  {
    return paramUri1.toString().startsWith(paramUri2.toString());
  }

  private void b(long paramLong)
  {
    Message localMessage = this.c.a(paramLong);
    this.e.a(localMessage.b(), paramLong, false);
  }

  private void b(Context paramContext, Intent paramIntent)
  {
    BLog.b(a, "Received onMessage");
    Uri localUri = (Uri)paramIntent.getParcelableExtra("uri");
    long l = Long.parseLong(localUri.getLastPathSegment());
    int i = paramIntent.getIntExtra("state", 0);
    if (localUri != null)
    {
      if (i != 1)
        break label64;
      if (a(localUri, Telephony.Mms.Inbox.a))
        a(l);
    }
    while (true)
    {
      return;
      label64: if ((i == 2) && (a(localUri, Telephony.Mms.Inbox.a)))
      {
        b(l);
        continue;
      }
    }
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.b = ((MmsTransactionStateReceiverWakeLockHolder)localFbInjector.a(MmsTransactionStateReceiverWakeLockHolder.class));
    this.c = ((MmsContentResolverHandler)localFbInjector.a(MmsContentResolverHandler.class));
    this.d = localFbInjector.c(PushHandler.class);
    this.e = ((MmsSmsLogger)localFbInjector.a(MmsSmsLogger.class));
    this.f = ((ReadThreadManager)localFbInjector.a(ReadThreadManager.class));
  }

  public final void onHandleIntent(Intent paramIntent)
  {
    try
    {
      b(this, paramIntent);
      return;
    }
    finally
    {
      this.b.a.b();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsTransactionStateReceiver
 * JD-Core Version:    0.6.0
 */