package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;
import com.facebook.contacts.data.DbContactsProperties;
import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.database.DbProperties;
import com.facebook.orca.database.DbUsersPropertyUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.presence.PresenceManager.OnPresenceReceivedListener;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchLastActiveResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.LastActive;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserBuilder;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Provider;

public class DivebarLoader extends AsyncTaskLoader<DivebarLoader.Result>
{
  private final AndroidThreadUtil A;
  private DivebarLoader.LoaderParams B;
  private DivebarLoader.Result C;
  private boolean D = false;
  private Object E = new Object();
  private OrcaServiceOperationFactory.OrcaServiceOperation F;
  private ListenableFuture<OperationResult> G;
  private final DbUsersPropertyUtil f;
  private final DivebarCache g;
  private final FavoriteContactsCache h;
  private final Provider<FacebookUserIterator> i;
  private final PresenceManager j;
  private final SafeLocalBroadcastReceiver k;
  private final PresenceManager.OnPresenceReceivedListener l;
  private final Provider<Boolean> t;
  private final Provider<Boolean> u;
  private final Provider<Boolean> v;
  private final Provider<Boolean> w;
  private final Provider<User> x;
  private final DbContactsPropertyUtil y;
  private final OrcaServiceOperationFactory z;

  public DivebarLoader(Context paramContext, DbUsersPropertyUtil paramDbUsersPropertyUtil, DivebarCache paramDivebarCache, FavoriteContactsCache paramFavoriteContactsCache, Provider<FacebookUserIterator> paramProvider, PresenceManager paramPresenceManager, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2, Provider<Boolean> paramProvider3, Provider<User> paramProvider4, AndroidThreadUtil paramAndroidThreadUtil, DbContactsPropertyUtil paramDbContactsPropertyUtil, Provider<Boolean> paramProvider5)
  {
    super(paramContext);
    this.f = paramDbUsersPropertyUtil;
    this.A = paramAndroidThreadUtil;
    this.g = paramDivebarCache;
    this.h = paramFavoriteContactsCache;
    this.i = paramProvider;
    this.j = paramPresenceManager;
    this.t = paramProvider1;
    this.w = paramProvider3;
    this.u = paramProvider2;
    this.x = paramProvider4;
    this.v = paramProvider5;
    this.y = paramDbContactsPropertyUtil;
    this.z = paramOrcaServiceOperationFactory;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.ACTION_FRIEND_SYNC_PROGRESS");
    localIntentFilter.addAction("com.facebook.orca.FAVORITE_CONTACT_SYNC_PROGRESS");
    this.k = new DivebarLoader.1(this, paramContext, localIntentFilter);
    this.l = new DivebarLoader.2(this);
  }

  private boolean A()
  {
    boolean bool1 = this.B.a();
    int m = 0;
    if (bool1)
    {
      boolean bool2 = this.f.a(DbProperties.f, -1L) < 0L;
      m = 0;
      if (bool2)
        m = 1;
    }
    return m;
  }

  private boolean B()
  {
    int m = 1;
    BLog.b("orca:FriendListsLoader", "waitingForContactSynch");
    if (y())
      BLog.b("orca:FriendListsLoader", "Waiting for friends");
    while (true)
    {
      return m;
      if (z())
      {
        BLog.b("orca:FriendListsLoader", "Waiting for contacts");
        continue;
      }
      if (A())
      {
        BLog.b("orca:FriendListsLoader", "Waiting for favorites");
        continue;
      }
      m = 0;
    }
  }

  private void C()
  {
    BLog.b("orca:FriendListsLoader", "onPresenceReceived");
    u();
  }

  private ImmutableList<User> D()
  {
    Tracer localTracer1 = Tracer.a("getFavoriteFriends");
    ImmutableList.Builder localBuilder = ImmutableList.e();
    FacebookUserIterator localFacebookUserIterator = (FacebookUserIterator)this.i.b();
    localFacebookUserIterator.c();
    try
    {
      localTracer2 = Tracer.a("#fetch");
      while (true)
      {
        User localUser = localFacebookUserIterator.d();
        if (localUser == null)
          break;
        localBuilder.b(localUser);
      }
    }
    catch (IOException localIOException)
    {
      Tracer localTracer2;
      BLog.c("orca:FriendListsLoader", "Exception reading favorite users", localIOException);
      localFacebookUserIterator.e();
      while (true)
      {
        localTracer1.a();
        return localBuilder.b();
        localTracer2.a();
        localFacebookUserIterator.e();
      }
    }
    finally
    {
      localFacebookUserIterator.e();
    }
    throw localObject;
  }

  private ImmutableList<User> E()
  {
    Tracer localTracer1 = Tracer.a("getTopFriends");
    ImmutableList.Builder localBuilder = ImmutableList.e();
    FacebookUserIterator localFacebookUserIterator = (FacebookUserIterator)this.i.b();
    localFacebookUserIterator.a(DivebarLoader.LoaderParams.a(this.B));
    try
    {
      localTracer2 = Tracer.a("#fetch");
      while (true)
      {
        User localUser = localFacebookUserIterator.d();
        if (localUser == null)
          break;
        localBuilder.b(localUser);
      }
    }
    catch (IOException localIOException)
    {
      Tracer localTracer2;
      BLog.c("orca:FriendListsLoader", "Exception reading facebook users", localIOException);
      localFacebookUserIterator.e();
      while (true)
      {
        localTracer1.a();
        return localBuilder.b();
        localTracer2.a();
        localFacebookUserIterator.e();
      }
    }
    finally
    {
      localFacebookUserIterator.e();
    }
    throw localObject;
  }

  private ImmutableList<User> F()
  {
    Tracer localTracer = Tracer.a("getOnlineFriends");
    ImmutableList localImmutableList = a(this.j.c());
    localTracer.a();
    return localImmutableList;
  }

  private ImmutableList<User> G()
  {
    Tracer localTracer = Tracer.a("getMobileFriends");
    ImmutableList localImmutableList = a(this.j.d());
    localTracer.a();
    return localImmutableList;
  }

  private DivebarLoader.Result a(DivebarLoader.Result paramResult, FetchLastActiveResult paramFetchLastActiveResult)
  {
    int m = 1;
    DivebarLoader.Result localResult;
    if (paramResult == null)
    {
      localResult = null;
      return localResult;
    }
    HashMap localHashMap = Maps.a();
    Iterator localIterator = paramFetchLastActiveResult.a().iterator();
    while (localIterator.hasNext())
    {
      User localUser = (User)localIterator.next();
      localHashMap.put(localUser.c(), localUser.B());
    }
    ImmutableList localImmutableList1 = paramResult.a();
    ImmutableList localImmutableList2 = paramResult.b();
    ImmutableList localImmutableList3 = paramResult.e();
    ImmutableList localImmutableList4 = paramResult.d();
    ImmutableList localImmutableList5 = a(localImmutableList1, localHashMap);
    if (localImmutableList5 != localImmutableList1)
      this.h.a(localImmutableList5);
    for (int n = m; ; n = 0)
    {
      ImmutableList localImmutableList6 = a(localImmutableList2, localHashMap);
      if (localImmutableList6 != localImmutableList2)
      {
        this.g.a(localImmutableList6);
        n = m;
      }
      while (true)
      {
        ImmutableList localImmutableList7 = a(localImmutableList3, localHashMap);
        if (localImmutableList7 != localImmutableList3)
        {
          this.g.d(localImmutableList7);
          n = m;
        }
        ImmutableList localImmutableList8 = a(localImmutableList4, localHashMap);
        if (localImmutableList8 != localImmutableList4)
          this.g.c(localImmutableList8);
        while (true)
        {
          if (m != 0)
          {
            localResult = new DivebarLoader.Result(localImmutableList5, localImmutableList6, paramResult.c(), paramResult.d(), paramResult.e(), B());
            break;
          }
          localResult = null;
          break;
          m = n;
        }
        localImmutableList6 = localImmutableList2;
      }
      localImmutableList5 = localImmutableList1;
    }
  }

  private ImmutableList<User> a(ImmutableList<User> paramImmutableList1, ImmutableList<User> paramImmutableList2, ImmutableList<User> paramImmutableList3)
  {
    Tracer localTracer = Tracer.a("getOtherContacts");
    ImmutableList.Builder localBuilder1 = ImmutableList.e();
    FacebookUserIterator localFacebookUserIterator = (FacebookUserIterator)this.i.b();
    ImmutableList.Builder localBuilder2 = ImmutableList.e();
    if (paramImmutableList1 != null)
    {
      Iterator localIterator3 = paramImmutableList1.iterator();
      while (localIterator3.hasNext())
        localBuilder2.a(((User)localIterator3.next()).c());
    }
    if (paramImmutableList2 != null)
    {
      Iterator localIterator2 = paramImmutableList2.iterator();
      while (localIterator2.hasNext())
        localBuilder2.a(((User)localIterator2.next()).c());
    }
    if (paramImmutableList3 != null)
    {
      Iterator localIterator1 = paramImmutableList3.iterator();
      while (localIterator1.hasNext())
        localBuilder2.a(((User)localIterator1.next()).c());
    }
    localBuilder2.a(((User)this.x.b()).c());
    localFacebookUserIterator.a(localBuilder2.a());
    try
    {
      Tracer.a("#fetch");
      while (true)
      {
        User localUser = localFacebookUserIterator.d();
        if (localUser == null)
          break;
        localBuilder1.b(localUser);
      }
    }
    catch (IOException localIOException)
    {
      BLog.d("orca:FriendListsLoader", "Exception reading facebook users");
      localFacebookUserIterator.e();
      while (true)
      {
        localTracer.a();
        return localBuilder1.b();
        localFacebookUserIterator.e();
      }
    }
    finally
    {
      localFacebookUserIterator.e();
    }
    throw localObject;
  }

  private ImmutableList<User> a(ImmutableList<User> paramImmutableList, Map<UserKey, LastActive> paramMap)
  {
    if (paramImmutableList == null)
      paramImmutableList = null;
    while (true)
    {
      return paramImmutableList;
      if (paramMap.isEmpty())
        continue;
      ImmutableList.Builder localBuilder = ImmutableList.e();
      Iterator localIterator = paramImmutableList.iterator();
      int m = 0;
      if (localIterator.hasNext())
      {
        User localUser = (User)localIterator.next();
        LastActive localLastActive = (LastActive)paramMap.get(localUser.c());
        if (Objects.equal(localUser.B(), localLastActive))
          localBuilder.b(localUser);
        for (int n = m; ; n = 1)
        {
          m = n;
          break;
          UserBuilder localUserBuilder = new UserBuilder();
          localUserBuilder.a(localUser);
          localUserBuilder.a(localLastActive);
          localBuilder.b(localUserBuilder.w());
        }
      }
      if (m == 0)
        continue;
      paramImmutableList = localBuilder.b();
    }
  }

  private ImmutableList<User> a(Collection<UserKey> paramCollection)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    FacebookUserIterator localFacebookUserIterator = (FacebookUserIterator)this.i.b();
    localFacebookUserIterator.a(paramCollection);
    try
    {
      while (true)
      {
        User localUser = localFacebookUserIterator.d();
        if (localUser == null)
          break;
        localBuilder.b(localUser);
      }
    }
    catch (IOException localIOException)
    {
      BLog.c("orca:FriendListsLoader", "Exception reading facebook users", localIOException);
      while (true)
      {
        return localBuilder.b();
        localFacebookUserIterator.e();
      }
    }
    finally
    {
      localFacebookUserIterator.e();
    }
    throw localObject;
  }

  private void a(DivebarLoader.Result paramResult)
  {
    this.A.b(new DivebarLoader.4(this, paramResult));
  }

  private void a(OperationResult paramOperationResult)
  {
    FetchLastActiveResult localFetchLastActiveResult = (FetchLastActiveResult)paramOperationResult.h();
    BLog.b("orca:FriendListsLoader", "onFetchLastActiveSucceeded. freshness=" + localFetchLastActiveResult.e());
    synchronized (this.E)
    {
      try
      {
        while ((this.D) && (k()))
          this.E.wait(5000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new RuntimeException(localInterruptedException);
      }
    }
    DivebarLoader.Result localResult1;
    if ((!this.D) && (k()))
    {
      DivebarLoader.Result localResult3 = this.C;
      if ((localFetchLastActiveResult.a().size() > 0) && (localFetchLastActiveResult.e() != DataFreshnessResult.NO_DATA))
      {
        localResult1 = a(localResult3, localFetchLastActiveResult);
        if (localResult1 != null)
          this.C = localResult1;
      }
    }
    while (true)
    {
      if (k())
      {
        if (localResult1 == null)
          break label199;
        BLog.b("orca:FriendListsLoader", "onFetchLastActiveSucceeded. sending updated result to client. " + localResult1.toString());
        a(localResult1);
      }
      while (true)
      {
        monitorexit;
        return;
        label199: DivebarLoader.Result localResult2 = new DivebarLoader.Result(null, null, null, null, null, B());
        BLog.b("orca:FriendListsLoader", "onFetchLastActiveSucceeded. no changes detected. skipping update. " + localResult2.toString());
        a(localResult2);
      }
      localResult1 = null;
    }
  }

  private void x()
  {
    if ((this.F != null) && (this.F.c()));
    while (true)
    {
      return;
      this.F = this.z.a("sync_top_last_active", new Bundle());
      BLog.b("orca:FriendListsLoader", "start SYNC_TOP_LAST_ACTIVE");
      this.G = this.F.d();
      Futures.a(this.G, new DivebarLoader.3(this));
    }
  }

  private boolean y()
  {
    long l1 = this.f.a(DbProperties.d, -1L);
    long l2 = this.f.a(DbProperties.e, 0L);
    if ((l1 <= 0L) && (l2 == 0L));
    for (int m = 1; ; m = 0)
      return m;
  }

  private boolean z()
  {
    boolean bool = ((Boolean)this.v.b()).booleanValue();
    int m = 0;
    if (!bool)
      return m;
    if (this.y.a(DbContactsProperties.a, -1L) <= 0L);
    for (int n = 1; ; n = 0)
    {
      m = n;
      break;
    }
  }

  public void a(DivebarLoader.LoaderParams paramLoaderParams)
  {
    if (this.B == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.B = paramLoaderParams;
      return;
    }
  }

  // ERROR //
  public DivebarLoader.Result f()
  {
    // Byte code:
    //   0: ldc 133
    //   2: ldc_w 478
    //   5: invokestatic 141	com/facebook/orca/debug/BLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 60	com/facebook/orca/contacts/divebar/DivebarLoader:E	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 53	com/facebook/orca/contacts/divebar/DivebarLoader:D	Z
    //   20: aload_0
    //   21: invokespecial 293	com/facebook/orca/contacts/divebar/DivebarLoader:B	()Z
    //   24: istore 4
    //   26: aload_0
    //   27: getfield 114	com/facebook/orca/contacts/divebar/DivebarLoader:B	Lcom/facebook/orca/contacts/divebar/DivebarLoader$LoaderParams;
    //   30: invokevirtual 479	com/facebook/orca/contacts/divebar/DivebarLoader$LoaderParams:c	()Z
    //   33: ifeq +210 -> 243
    //   36: aload_0
    //   37: getfield 74	com/facebook/orca/contacts/divebar/DivebarLoader:t	Ljavax/inject/Provider;
    //   40: invokeinterface 178 1 0
    //   45: checkcast 455	java/lang/Boolean
    //   48: invokevirtual 458	java/lang/Boolean:booleanValue	()Z
    //   51: ifeq +192 -> 243
    //   54: iload 4
    //   56: ifne +187 -> 243
    //   59: aload_0
    //   60: invokespecial 481	com/facebook/orca/contacts/divebar/DivebarLoader:x	()V
    //   63: iconst_1
    //   64: istore 5
    //   66: ldc 133
    //   68: new 367	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 483
    //   78: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload 5
    //   83: invokevirtual 486	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   86: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 141	com/facebook/orca/debug/BLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_0
    //   93: invokevirtual 488	com/facebook/orca/contacts/divebar/DivebarLoader:v	()Lcom/facebook/orca/contacts/divebar/DivebarLoader$Result;
    //   96: astore 6
    //   98: ldc 133
    //   100: ldc_w 490
    //   103: invokestatic 141	com/facebook/orca/debug/BLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload 6
    //   108: invokevirtual 269	com/facebook/orca/contacts/divebar/DivebarLoader$Result:a	()Lcom/google/common/collect/ImmutableList;
    //   111: astore 7
    //   113: aload 6
    //   115: invokevirtual 270	com/facebook/orca/contacts/divebar/DivebarLoader$Result:b	()Lcom/google/common/collect/ImmutableList;
    //   118: astore 8
    //   120: aload 6
    //   122: invokevirtual 291	com/facebook/orca/contacts/divebar/DivebarLoader$Result:c	()Lcom/google/common/collect/ImmutableList;
    //   125: astore 9
    //   127: aload 6
    //   129: invokevirtual 274	com/facebook/orca/contacts/divebar/DivebarLoader$Result:d	()Lcom/google/common/collect/ImmutableList;
    //   132: astore 10
    //   134: aload 6
    //   136: invokevirtual 272	com/facebook/orca/contacts/divebar/DivebarLoader$Result:e	()Lcom/google/common/collect/ImmutableList;
    //   139: astore 11
    //   141: iload 4
    //   143: ifne +106 -> 249
    //   146: iconst_0
    //   147: istore 12
    //   149: iload 5
    //   151: ifeq +6 -> 157
    //   154: goto +95 -> 249
    //   157: aload_0
    //   158: new 268	com/facebook/orca/contacts/divebar/DivebarLoader$Result
    //   161: dup
    //   162: aload 7
    //   164: aload 8
    //   166: aload 9
    //   168: aload 10
    //   170: aload 11
    //   172: iload 12
    //   174: invokespecial 296	com/facebook/orca/contacts/divebar/DivebarLoader$Result:<init>	(Lcom/google/common/collect/ImmutableList;Lcom/google/common/collect/ImmutableList;Lcom/google/common/collect/ImmutableList;Lcom/google/common/collect/ImmutableList;Lcom/google/common/collect/ImmutableList;Z)V
    //   177: putfield 399	com/facebook/orca/contacts/divebar/DivebarLoader:C	Lcom/facebook/orca/contacts/divebar/DivebarLoader$Result;
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 53	com/facebook/orca/contacts/divebar/DivebarLoader:D	Z
    //   185: aload_0
    //   186: getfield 60	com/facebook/orca/contacts/divebar/DivebarLoader:E	Ljava/lang/Object;
    //   189: invokevirtual 493	java/lang/Object:notifyAll	()V
    //   192: aload_1
    //   193: monitorexit
    //   194: ldc 133
    //   196: new 367	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 495
    //   206: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: getfield 399	com/facebook/orca/contacts/divebar/DivebarLoader:C	Lcom/facebook/orca/contacts/divebar/DivebarLoader$Result;
    //   213: invokevirtual 414	com/facebook/orca/contacts/divebar/DivebarLoader$Result:toString	()Ljava/lang/String;
    //   216: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 141	com/facebook/orca/debug/BLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_0
    //   226: getfield 399	com/facebook/orca/contacts/divebar/DivebarLoader:C	Lcom/facebook/orca/contacts/divebar/DivebarLoader$Result;
    //   229: areturn
    //   230: astore_2
    //   231: aload_0
    //   232: iconst_0
    //   233: putfield 53	com/facebook/orca/contacts/divebar/DivebarLoader:D	Z
    //   236: aload_2
    //   237: athrow
    //   238: astore_3
    //   239: aload_1
    //   240: monitorexit
    //   241: aload_3
    //   242: athrow
    //   243: iconst_0
    //   244: istore 5
    //   246: goto -180 -> 66
    //   249: iconst_1
    //   250: istore 12
    //   252: goto -95 -> 157
    //
    // Exception table:
    //   from	to	target	type
    //   15	180	230	finally
    //   180	194	238	finally
    //   231	241	238	finally
  }

  protected void g()
  {
    super.g();
    Preconditions.checkNotNull(this.B);
    BLog.b("orca:FriendListsLoader", "onStartLoading");
    if (this.C != null)
    {
      BLog.b("orca:FriendListsLoader", "Using cached result");
      b(this.C);
    }
    if (this.C == null)
    {
      BLog.b("orca:FriendListsLoader", "Forcing a load");
      o();
    }
    this.k.a();
    if ((this.B.e()) || (this.B.d()))
    {
      BLog.b("orca:FriendListsLoader", "presenceManager.addPresenceReceivedListener");
      this.j.a(this.l);
    }
  }

  protected void h()
  {
    super.h();
    BLog.b("orca:FriendListsLoader", "onStopLoading");
    b();
    if (!k())
      synchronized (this.E)
      {
        this.D = false;
        this.E.notifyAll();
      }
  }

  protected void i()
  {
    BLog.b("orca:FriendListsLoader", "onReset");
    h();
    this.C = null;
    this.k.b();
    this.j.b(this.l);
  }

  DivebarLoader.Result v()
  {
    Tracer.b(3L);
    Tracer localTracer = Tracer.a("loadInBackground");
    ImmutableList localImmutableList1;
    if (this.B.a())
    {
      BLog.b("orca:FriendListsLoader", "checking favorite friends");
      localImmutableList1 = D();
      this.h.a(localImmutableList1);
    }
    while (true)
    {
      ImmutableList localImmutableList2;
      if (this.B.b())
      {
        BLog.b("orca:FriendListsLoader", "checking top friends");
        localImmutableList2 = E();
        this.g.a(localImmutableList2);
      }
      while (true)
      {
        ImmutableList localImmutableList3;
        if ((this.B.d()) && (((Boolean)this.u.b()).booleanValue()))
        {
          BLog.b("orca:FriendListsLoader", "checking online friends");
          localImmutableList3 = F();
          this.g.b(localImmutableList3);
        }
        while (true)
        {
          ImmutableList localImmutableList4;
          if ((this.B.e()) && (((Boolean)this.u.b()).booleanValue()))
          {
            BLog.b("orca:FriendListsLoader", "checking mobile friends");
            localImmutableList4 = G();
            this.g.d(localImmutableList4);
          }
          while (true)
          {
            boolean bool1 = this.B.f();
            ImmutableList localImmutableList5 = null;
            if (bool1)
            {
              boolean bool2 = ((Boolean)this.w.b()).booleanValue();
              localImmutableList5 = null;
              if (bool2)
              {
                BLog.b("orca:FriendListsLoader", "checking other contacts");
                localImmutableList5 = a(localImmutableList1, localImmutableList2, localImmutableList3);
                this.g.c(localImmutableList5);
              }
            }
            localTracer.a();
            Tracer.b("orca:FriendListsLoader");
            return new DivebarLoader.Result(localImmutableList1, localImmutableList2, localImmutableList3, localImmutableList5, localImmutableList4);
            localImmutableList4 = null;
          }
          localImmutableList3 = null;
        }
        localImmutableList2 = null;
      }
      localImmutableList1 = null;
    }
  }

  public void w()
  {
    BLog.b("orca:FriendListsLoader", "onFriendSyncProgress");
    u();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarLoader
 * JD-Core Version:    0.6.0
 */