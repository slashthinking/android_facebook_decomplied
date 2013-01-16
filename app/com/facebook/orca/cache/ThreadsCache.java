package com.facebook.orca.cache;

import android.location.Location;
import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.compose.MessageDraft;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagesCollectionMerger;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadSummaryBuilder;
import com.facebook.orca.threads.ThreadSummaryStitching;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreadsCache
{
  private static final Class<?> a = ThreadsCache.class;
  private static final WtfToken b = new WtfToken();
  private final MeUserAuthDataStore c;
  private final MessagesCollectionMerger d;
  private final ThreadSummaryStitching e;
  private final Map<FolderName, FolderCacheData> f;
  private final Map<String, ThreadSummary> g;
  private final Map<String, MessagesCollection> h;
  private final Map<String, ThreadLocalState> i;
  private final Map<UserKey, User> j = Maps.c();

  public ThreadsCache(MeUserAuthDataStore paramMeUserAuthDataStore, MessagesCollectionMerger paramMessagesCollectionMerger, ThreadSummaryStitching paramThreadSummaryStitching)
  {
    this.c = paramMeUserAuthDataStore;
    this.d = paramMessagesCollectionMerger;
    this.e = paramThreadSummaryStitching;
    this.f = Maps.a();
    this.g = Maps.a();
    this.h = Maps.a();
    this.i = Maps.a();
  }

  private MessagesCollection a(Message paramMessage, MessagesCollection paramMessagesCollection1, MessagesCollection paramMessagesCollection2)
  {
    if (paramMessagesCollection1 == null)
      paramMessagesCollection1 = MessagesCollection.a(paramMessage);
    return this.d.a(paramMessagesCollection1, paramMessagesCollection2);
  }

  private MessagesCollection a(MessagesCollection paramMessagesCollection, Set<String> paramSet)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramMessagesCollection.b().iterator();
    while (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      if (paramSet.contains(localMessage.a()))
        continue;
      localBuilder.b(localMessage);
    }
    return new MessagesCollection(paramMessagesCollection.a(), localBuilder.b(), paramMessagesCollection.d());
  }

  private String a(User paramUser)
  {
    Name localName = paramUser.d();
    String str;
    if (localName.a())
      str = localName.getFirstName();
    while (true)
    {
      return str;
      if (localName.c())
      {
        str = localName.d();
        continue;
      }
      if (localName.e())
      {
        str = localName.getDisplayName();
        continue;
      }
      if (paramUser.k())
      {
        str = paramUser.l();
        continue;
      }
      str = null;
    }
  }

  private void a(Message paramMessage, MessagesCollection paramMessagesCollection1, MessagesCollection paramMessagesCollection2, MessagesCollection paramMessagesCollection3)
  {
    if (!BLog.b(2));
    while (true)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Merged messages:\n");
      localStringBuilder.append("  New Message:\n");
      a(localStringBuilder, MessagesCollection.a(paramMessage), 1);
      localStringBuilder.append("  Recent Messages:\n");
      a(localStringBuilder, paramMessagesCollection1, 5);
      localStringBuilder.append("  Loaded Messages:\n");
      a(localStringBuilder, paramMessagesCollection2, 5);
      localStringBuilder.append("  Result:\n");
      a(localStringBuilder, paramMessagesCollection3, 8);
      localStringBuilder.append("\n");
      BLog.a(a, localStringBuilder.toString());
    }
  }

  private void a(StringBuilder paramStringBuilder, MessagesCollection paramMessagesCollection, int paramInt)
  {
    if ((paramMessagesCollection == null) || (paramMessagesCollection.e()))
      paramStringBuilder.append("    none\n");
    while (true)
    {
      return;
      for (int k = 0; (k < paramInt) && (k < paramMessagesCollection.f()); k++)
      {
        Message localMessage = paramMessagesCollection.a(k);
        paramStringBuilder.append("   ").append(localMessage).append("\n");
      }
    }
  }

  private void a(Map<String, ?> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str == null) || (!MessagingIdUtil.g(str)))
        continue;
      localIterator.remove();
    }
  }

  private boolean a(ThreadSummary paramThreadSummary, Message paramMessage)
  {
    int k = 1;
    if ((paramMessage == null) && (paramThreadSummary == null));
    while (true)
    {
      return k;
      if ((paramThreadSummary == null) || (paramMessage == null))
      {
        k = 0;
        continue;
      }
      if ((paramThreadSummary.d() == -1L) || (paramThreadSummary.d() == paramMessage.p()))
        continue;
      k = 0;
    }
  }

  private void b(Message paramMessage, MessagesCollection paramMessagesCollection)
  {
    if (paramMessage == null);
    String str;
    ThreadLocalState localThreadLocalState;
    ThreadSummary localThreadSummary1;
    while (true)
    {
      return;
      str = paramMessage.b();
      localThreadLocalState = i(str);
      localThreadSummary1 = (ThreadSummary)this.g.get(str);
      if (localThreadSummary1 != null)
        break;
      e();
      localThreadLocalState.b();
    }
    MessagesCollection localMessagesCollection1 = (MessagesCollection)this.h.get(str);
    if (localMessagesCollection1 == null)
    {
      localMessagesCollection1 = new MessagesCollection(str, ImmutableList.d(), false);
      e();
      localThreadLocalState.b();
    }
    while (true)
    {
      if ((paramMessagesCollection == null) || (!this.d.c(paramMessagesCollection, localMessagesCollection1)))
      {
        e();
        localThreadLocalState.b();
      }
      MessagesCollection localMessagesCollection2 = a(paramMessage, paramMessagesCollection, localMessagesCollection1);
      a(paramMessage, paramMessagesCollection, localMessagesCollection1, localMessagesCollection2);
      ThreadSummary localThreadSummary2 = this.e.a(localThreadSummary1, paramMessage);
      b(localThreadSummary2);
      this.g.put(str, localThreadSummary2);
      this.h.put(str, localMessagesCollection2);
      d(localThreadSummary2);
      break;
      if (!paramMessage.v())
        continue;
      e();
      localThreadLocalState.b();
    }
  }

  private void b(ThreadSummary paramThreadSummary)
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        FolderCacheData localFolderCacheData = (FolderCacheData)localIterator.next();
        if (!localFolderCacheData.b(paramThreadSummary.a()))
          continue;
        localFolderCacheData.a(paramThreadSummary);
      }
    }
    finally
    {
      monitorexit;
    }
  }

  private void b(ThreadSummary paramThreadSummary, long paramLong)
  {
    monitorenter;
    try
    {
      c(paramThreadSummary);
      ThreadLocalState localThreadLocalState = i(paramThreadSummary.a());
      localThreadLocalState.c(paramLong);
      localThreadLocalState.c();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void c(MessagesCollection paramMessagesCollection)
  {
    if (!BLog.b(2));
    while (true)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  Messages:\n");
      a(localStringBuilder, paramMessagesCollection, 8);
      localStringBuilder.append("\n");
      BLog.a(a, localStringBuilder.toString());
    }
  }

  private void c(ThreadSummary paramThreadSummary)
  {
    monitorenter;
    try
    {
      this.g.put(paramThreadSummary.a(), paramThreadSummary);
      d(paramThreadSummary);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void d(ThreadSummary paramThreadSummary)
  {
    ThreadLocalState localThreadLocalState = i(paramThreadSummary.a());
    if (paramThreadSummary.t())
      localThreadLocalState.a(paramThreadSummary.b() - 1L);
    while (true)
    {
      return;
      localThreadLocalState.a(paramThreadSummary.b());
    }
  }

  private void e()
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.f.values().iterator();
      if (localIterator.hasNext())
        ((FolderCacheData)localIterator.next()).c(false);
    }
    finally
    {
      monitorexit;
    }
  }

  private FolderCacheData f(FolderName paramFolderName)
  {
    monitorenter;
    try
    {
      FolderCacheData localFolderCacheData = (FolderCacheData)this.f.get(paramFolderName);
      if (localFolderCacheData == null)
      {
        localFolderCacheData = new FolderCacheData(paramFolderName);
        this.f.put(paramFolderName, localFolderCacheData);
      }
      monitorexit;
      return localFolderCacheData;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private ThreadLocalState i(String paramString)
  {
    if (paramString == null)
      BLog.a(b, a, "ensuring null threadId ThreadLocalState");
    ThreadLocalState localThreadLocalState = (ThreadLocalState)this.i.get(paramString);
    if (localThreadLocalState == null)
    {
      localThreadLocalState = new ThreadLocalState(paramString);
      this.i.put(paramString, localThreadLocalState);
    }
    return localThreadLocalState;
  }

  ThreadSummary a(UserKey paramUserKey)
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext())
      {
        localThreadSummary = (ThreadSummary)localIterator.next();
        if (!localThreadSummary.g())
          continue;
        boolean bool = Objects.equal(localThreadSummary.h(), paramUserKey);
        if (bool)
          return localThreadSummary;
      }
      ThreadSummary localThreadSummary = null;
    }
    finally
    {
      monitorexit;
    }
  }

  ThreadSummary a(String paramString)
  {
    monitorenter;
    try
    {
      ThreadSummary localThreadSummary = (ThreadSummary)this.g.get(paramString);
      monitorexit;
      return localThreadSummary;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  String a(ParticipantInfo paramParticipantInfo)
  {
    String str;
    if (paramParticipantInfo.e() != null)
    {
      User localUser = (User)this.j.get(paramParticipantInfo.e());
      if (localUser != null)
        str = localUser.d().f();
    }
    while (true)
    {
      if (str == null)
        str = paramParticipantInfo.a();
      return str;
      str = paramParticipantInfo.d();
      continue;
      str = paramParticipantInfo.d();
    }
  }

  List<ThreadSummary> a()
  {
    monitorenter;
    try
    {
      ImmutableList localImmutableList = ImmutableList.a(this.g.values());
      monitorexit;
      return localImmutableList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(FolderName paramFolderName, FolderCounts paramFolderCounts)
  {
    f(paramFolderName).a(paramFolderCounts);
  }

  void a(FolderName paramFolderName, ThreadsCollection paramThreadsCollection, long paramLong)
  {
    monitorenter;
    FolderCacheData localFolderCacheData;
    try
    {
      localFolderCacheData = f(paramFolderName);
      Iterator localIterator = paramThreadsCollection.b().iterator();
      while (localIterator.hasNext())
      {
        ThreadSummary localThreadSummary = (ThreadSummary)localIterator.next();
        localFolderCacheData.a(localThreadSummary);
        b(localThreadSummary, paramLong);
      }
    }
    finally
    {
      monitorexit;
    }
    localFolderCacheData.a(paramThreadsCollection.c());
    monitorexit;
  }

  void a(FolderName paramFolderName, ThreadsCollection paramThreadsCollection, long paramLong, boolean paramBoolean)
  {
    monitorenter;
    FolderCacheData localFolderCacheData;
    try
    {
      localFolderCacheData = f(paramFolderName);
      localFolderCacheData.g();
      Iterator localIterator1 = paramThreadsCollection.b().iterator();
      while (localIterator1.hasNext())
      {
        ThreadSummary localThreadSummary = (ThreadSummary)localIterator1.next();
        localFolderCacheData.a(localThreadSummary);
        b(localThreadSummary, paramLong);
      }
    }
    finally
    {
      monitorexit;
    }
    localFolderCacheData.b(true);
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      localFolderCacheData.c(bool);
      localFolderCacheData.a(paramLong);
      Iterator localIterator2 = paramThreadsCollection.b().iterator();
      while (localIterator2.hasNext())
        d((ThreadSummary)localIterator2.next());
      Iterator localIterator3 = this.i.values().iterator();
      while (localIterator3.hasNext())
        ((ThreadLocalState)localIterator3.next()).c();
      localFolderCacheData.a(paramThreadsCollection.c());
      monitorexit;
      return;
    }
  }

  public void a(Message paramMessage, MessagesCollection paramMessagesCollection)
  {
    monitorenter;
    try
    {
      b(paramMessage, paramMessagesCollection);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(MessagesCollection paramMessagesCollection)
  {
    monitorenter;
    try
    {
      String str = paramMessagesCollection.a();
      this.h.put(str, paramMessagesCollection);
      ThreadSummary localThreadSummary = (ThreadSummary)this.g.get(str);
      if (localThreadSummary == null)
        e();
      while (true)
      {
        c(paramMessagesCollection);
        return;
        if (a(localThreadSummary, paramMessagesCollection.c()))
          continue;
        e();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(ThreadSummary paramThreadSummary)
  {
    monitorenter;
    try
    {
      b(paramThreadSummary);
      c(paramThreadSummary);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(ThreadSummary paramThreadSummary, long paramLong)
  {
    monitorenter;
    try
    {
      b(paramThreadSummary);
      b(paramThreadSummary, paramLong);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(ThreadSummary paramThreadSummary, MessageDraft paramMessageDraft)
  {
    monitorenter;
    try
    {
      a(new ThreadSummaryBuilder().a(paramThreadSummary).a(paramMessageDraft).y());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(String paramString, long paramLong)
  {
    monitorenter;
    try
    {
      i(paramString).b(paramLong);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(String paramString, Location paramLocation, long paramLong)
  {
    monitorenter;
    try
    {
      i(paramString).a(paramLocation, paramLong);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(String paramString, Set<String> paramSet)
  {
    monitorenter;
    try
    {
      MessagesCollection localMessagesCollection = (MessagesCollection)this.h.get(paramString);
      if (localMessagesCollection == null);
      while (true)
      {
        return;
        this.h.put(paramString, a(localMessagesCollection, paramSet));
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(Collection<User> paramCollection)
  {
    UserKey localUserKey = this.c.g().c();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      User localUser = (User)localIterator.next();
      if ((localUserKey != null) && (Objects.equal(localUser.c(), localUserKey)))
        this.c.b(localUser);
      this.j.put(localUser.c(), localUser);
    }
  }

  boolean a(FolderName paramFolderName)
  {
    return f(paramFolderName).c();
  }

  boolean a(String paramString, int paramInt)
  {
    monitorenter;
    try
    {
      boolean bool = d(paramString);
      int k = 0;
      if (!bool);
      MessagesCollection localMessagesCollection;
      while (true)
      {
        return k;
        localMessagesCollection = (MessagesCollection)this.h.get(paramString);
        if (!localMessagesCollection.d())
          break;
        k = 1;
      }
      int m = localMessagesCollection.f();
      if (paramInt <= m);
      for (int n = 1; ; n = 0)
      {
        k = n;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  MessagesCollection b(String paramString)
  {
    monitorenter;
    try
    {
      MessagesCollection localMessagesCollection = (MessagesCollection)this.h.get(paramString);
      monitorexit;
      return localMessagesCollection;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  User b(UserKey paramUserKey)
  {
    if (paramUserKey == null);
    for (User localUser = null; ; localUser = (User)this.j.get(paramUserKey))
      return localUser;
  }

  String b(ParticipantInfo paramParticipantInfo)
  {
    User localUser;
    if (paramParticipantInfo.e() != null)
    {
      localUser = (User)this.j.get(paramParticipantInfo.e());
      if (localUser == null);
    }
    for (String str = a(localUser); ; str = null)
    {
      if (StringUtil.a(str))
        str = paramParticipantInfo.d();
      return str;
    }
  }

  public void b()
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
        ((FolderCacheData)localIterator.next()).h();
    }
    finally
    {
      monitorexit;
    }
    this.f.clear();
    this.g.clear();
    this.h.clear();
    this.i.clear();
    this.j.clear();
    monitorexit;
  }

  void b(MessagesCollection paramMessagesCollection)
  {
    monitorenter;
    try
    {
      String str = paramMessagesCollection.a();
      if (this.g.containsKey(str))
        b(paramMessagesCollection.a(0), paramMessagesCollection);
      while (true)
      {
        return;
        a(paramMessagesCollection);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  boolean b(FolderName paramFolderName)
  {
    return f(paramFolderName).d();
  }

  ThreadsCollection c(FolderName paramFolderName)
  {
    monitorenter;
    try
    {
      FolderCacheData localFolderCacheData = f(paramFolderName);
      ThreadsCollection localThreadsCollection = new ThreadsCollection(ImmutableList.a(localFolderCacheData.a().a()), localFolderCacheData.b());
      monitorexit;
      return localThreadsCollection;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void c()
  {
    monitorenter;
    try
    {
      FolderCacheData localFolderCacheData1 = (FolderCacheData)this.f.remove(FolderName.d);
      if (localFolderCacheData1 != null)
        localFolderCacheData1.h();
      FolderCacheData localFolderCacheData2 = (FolderCacheData)this.f.remove(FolderName.e);
      if (localFolderCacheData2 != null)
        localFolderCacheData2.h();
      a(this.g);
      a(this.h);
      a(this.i);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void c(String paramString)
  {
    monitorenter;
    try
    {
      this.g.remove(paramString);
      this.h.remove(paramString);
      Iterator localIterator = this.f.values().iterator();
      if (localIterator.hasNext())
        ((FolderCacheData)localIterator.next()).a(paramString);
    }
    finally
    {
      monitorexit;
    }
  }

  FolderCounts d(FolderName paramFolderName)
  {
    return f(paramFolderName).f();
  }

  Collection<User> d()
  {
    return Collections.unmodifiableCollection(this.j.values());
  }

  boolean d(String paramString)
  {
    monitorenter;
    try
    {
      ThreadLocalState localThreadLocalState = (ThreadLocalState)this.i.get(paramString);
      int k;
      if (localThreadLocalState != null)
      {
        boolean bool2 = localThreadLocalState.a();
        if (bool2)
          k = 0;
      }
      while (true)
      {
        return k;
        MessagesCollection localMessagesCollection = (MessagesCollection)this.h.get(paramString);
        ThreadSummary localThreadSummary = (ThreadSummary)this.g.get(paramString);
        if (localMessagesCollection == null)
        {
          k = 0;
          continue;
        }
        if (localThreadSummary != null)
        {
          boolean bool1 = a(localThreadSummary, localMessagesCollection.c());
          if (bool1);
        }
        else
        {
          k = 0;
          continue;
        }
        k = 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  long e(FolderName paramFolderName)
  {
    return f(paramFolderName).e();
  }

  long e(String paramString)
  {
    monitorenter;
    try
    {
      long l = i(paramString).g();
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  long f(String paramString)
  {
    monitorenter;
    try
    {
      long l = i(paramString).f();
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  long g(String paramString)
  {
    monitorenter;
    try
    {
      long l = i(paramString).e();
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  long h(String paramString)
  {
    monitorenter;
    try
    {
      long l = i(paramString).d();
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.ThreadsCache
 * JD-Core Version:    0.6.0
 */