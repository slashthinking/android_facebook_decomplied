package com.facebook.orca.threadlist;

import android.os.Bundle;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMoreThreadsResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListParamsBuilder;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class ThreadListLoader
{
  public static ThreadListLoader.Result a;
  private static final Class<?> b = ThreadListLoader.class;
  private String c;
  private final DataCache d;
  private final OrcaServiceOperationFactory e;
  private final Clock f;
  private FolderName g;
  private ThreadListLoader.Callback h;
  private DataFreshnessParam i;
  private ListenableFuture<OperationResult> j;
  private ListenableFuture<OperationResult> k;
  private ThreadListLoader.Params l;
  private ThreadListLoader.Result m;

  static
  {
    a = new ThreadListLoader.Result(ThreadsCollection.a(), 0L, 0L, DataFreshnessResult.NO_DATA);
  }

  public ThreadListLoader(DataCache paramDataCache, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, Clock paramClock)
  {
    this.d = paramDataCache;
    this.e = paramOrcaServiceOperationFactory;
    this.f = paramClock;
  }

  private static ThreadListLoader.Params a(ThreadListLoader.Params paramParams1, ThreadListLoader.Params paramParams2)
  {
    if ((paramParams1.a) || (paramParams2.a));
    for (boolean bool1 = true; ; bool1 = false)
    {
      boolean bool2;
      if (!paramParams1.b)
      {
        boolean bool3 = paramParams2.b;
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      if ((paramParams1.a != bool1) || (paramParams1.b != bool2))
        paramParams1 = new ThreadListLoader.Params(bool1, bool2);
      return paramParams1;
    }
  }

  private void a(ServiceException paramServiceException)
  {
    BLog.b(b, "onFetchThreadsError");
    ThreadListLoader.Error localError = new ThreadListLoader.Error(paramServiceException, this.l.b);
    this.h.a(ThreadListLoader.LoadType.THREAD_LIST, localError);
  }

  private void a(DataFreshnessParam paramDataFreshnessParam)
  {
    if (this.j != null);
    while (true)
    {
      return;
      BLog.b(b, "Starting thread list fetch (%s)", new Object[] { paramDataFreshnessParam });
      this.i = paramDataFreshnessParam;
      FetchThreadListParams localFetchThreadListParams = FetchThreadListParams.newBuilder().a(paramDataFreshnessParam).a(this.g).a(true).f();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadListParams", localFetchThreadListParams);
      if (this.c != null)
        localBundle.putString("override_auth_token", this.c);
      this.j = this.e.a("fetch_thread_list", localBundle).d();
      this.h.a(ThreadListLoader.LoadType.THREAD_LIST);
      Futures.a(this.j, new ThreadListLoader.1(this));
    }
  }

  private void a(OperationResult paramOperationResult)
  {
    BLog.b(b, "onFetchThreadsSucceeded");
    FetchThreadListResult localFetchThreadListResult1 = (FetchThreadListResult)paramOperationResult.h();
    ThreadsCollection localThreadsCollection = localFetchThreadListResult1.b();
    long l1 = localFetchThreadListResult1.h().d();
    long l2 = localFetchThreadListResult1.f();
    long l3 = this.f.a();
    this.m = new ThreadListLoader.Result(localThreadsCollection, l2, l1, localFetchThreadListResult1.e());
    if (this.g == FolderName.e)
    {
      FetchThreadListResult localFetchThreadListResult2 = (FetchThreadListResult)localFetchThreadListResult1.m().get(FolderName.b);
      if ((localFetchThreadListResult2 != null) && (localFetchThreadListResult2.n() != null))
      {
        ThreadListLoader.Error localError = new ThreadListLoader.Error(localFetchThreadListResult2.n(), this.l.b);
        this.h.b(ThreadListLoader.LoadType.THREAD_LIST, localError);
      }
    }
    DataFreshnessResult localDataFreshnessResult = localFetchThreadListResult1.e();
    if ((localFetchThreadListResult1.l()) && (this.i == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA))
    {
      BLog.b(b, "Subfolder failure. Won't reattempt server fetch. Finished loading");
      this.h.a(ThreadListLoader.LoadType.THREAD_LIST, this.m);
      this.h.b(ThreadListLoader.LoadType.THREAD_LIST);
    }
    while (true)
    {
      return;
      if ((this.l.a) && (this.i != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) && (localDataFreshnessResult != DataFreshnessResult.FROM_SERVER))
      {
        BLog.b(b, "Starting load because need to hit server");
        this.h.a(ThreadListLoader.LoadType.THREAD_LIST, this.m);
        a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        continue;
      }
      if (localDataFreshnessResult == DataFreshnessResult.FROM_CACHE_STALE)
      {
        BLog.b(b, "Starting load because data from cache was stale");
        this.h.a(ThreadListLoader.LoadType.THREAD_LIST, this.m);
        a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        continue;
      }
      if (l3 - this.m.b >= 1800000L)
      {
        BLog.b(b, "Starting load because haven't checked the server recently");
        this.h.a(ThreadListLoader.LoadType.THREAD_LIST, this.m);
        a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        continue;
      }
      BLog.b(b, "Finished loading");
      this.h.a(ThreadListLoader.LoadType.THREAD_LIST, this.m);
      this.h.b(ThreadListLoader.LoadType.THREAD_LIST);
    }
  }

  private void b(ServiceException paramServiceException)
  {
    this.h.a(ThreadListLoader.LoadType.MORE_THREADS, new ThreadListLoader.Error(paramServiceException, true));
  }

  private void b(OperationResult paramOperationResult)
  {
    if (this.m == null);
    while (true)
    {
      return;
      FetchMoreThreadsResult localFetchMoreThreadsResult = (FetchMoreThreadsResult)paramOperationResult.h();
      this.m = new ThreadListLoader.Result(ThreadsCollection.a(this.m.a, localFetchMoreThreadsResult.b()), this.m.b, this.m.c, localFetchMoreThreadsResult.e());
      this.h.a(ThreadListLoader.LoadType.MORE_THREADS, this.m);
      this.h.b(ThreadListLoader.LoadType.MORE_THREADS);
    }
  }

  private void f()
  {
    this.l = null;
    this.m = null;
    if (this.j != null)
    {
      this.j.cancel(false);
      this.j = null;
    }
    if (this.k != null)
    {
      this.k.cancel(false);
      this.k = null;
    }
  }

  public void a()
  {
    f();
  }

  public void a(ThreadListLoader.Callback paramCallback)
  {
    this.h = paramCallback;
  }

  public void a(ThreadListLoader.Params paramParams)
  {
    BLog.b(b, "startLoad called with %s", new Object[] { paramParams });
    BLog.c(b, "startLoad");
    boolean bool = this.d.a(this.g);
    int n = 0;
    if (bool)
    {
      BLog.b(b, "Have cached data");
      this.m = new ThreadListLoader.Result(this.d.b(this.g), this.d.e(this.g), this.d.f(this.g).d(), DataFreshnessResult.FROM_CACHE_STALE);
      this.h.a(ThreadListLoader.LoadType.THREAD_LIST, this.m);
      n = 1;
    }
    if (this.j == null)
    {
      this.l = paramParams;
      if (n == 0)
        break label244;
      if (!this.l.a)
        break label187;
      BLog.b(b, "Starting load because need to hit server");
      a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
    }
    while (true)
    {
      return;
      BLog.b(b, "Load already in progress");
      this.l = a(this.l, paramParams);
      continue;
      label187: if (this.d.c(this.g))
      {
        BLog.b(b, "Starting load because data cache said to request new update");
        a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
        continue;
      }
      BLog.b(b, "Finished loading");
      this.h.b(ThreadListLoader.LoadType.THREAD_LIST);
      continue;
      label244: BLog.b(b, "No cached data. Starting load");
      a(DataFreshnessParam.STALE_DATA_OKAY);
    }
  }

  public void a(FolderName paramFolderName)
  {
    Preconditions.checkNotNull(paramFolderName);
    if (paramFolderName != this.g)
    {
      this.g = paramFolderName;
      f();
    }
  }

  public void a(String paramString)
  {
    if (!Objects.equal(this.c, paramString))
    {
      this.c = paramString;
      f();
    }
  }

  public boolean b()
  {
    if (this.j != null);
    for (int n = 1; ; n = 0)
      return n;
  }

  public boolean c()
  {
    if ((this.l.a) || (this.d.d(this.g)));
    for (int n = 1; ; n = 0)
      return n;
  }

  public boolean d()
  {
    return this.l.b;
  }

  public void e()
  {
    if (this.j != null);
    while (true)
    {
      return;
      if ((this.k == null) && (this.m != null) && (!this.m.a.d()))
      {
        ThreadsCollection localThreadsCollection = this.m.a;
        long l1 = localThreadsCollection.a(-1 + localThreadsCollection.e()).k();
        FetchMoreThreadsParams localFetchMoreThreadsParams = new FetchMoreThreadsParams(this.g, l1, 10);
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("fetchMoreThreadsParams", localFetchMoreThreadsParams);
        if (this.c != null)
          localBundle.putString("override_auth_token", this.c);
        this.k = this.e.a("fetch_more_threads", localBundle).d();
        this.h.a(ThreadListLoader.LoadType.MORE_THREADS);
        Futures.a(this.k, new ThreadListLoader.2(this));
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListLoader
 * JD-Core Version:    0.6.0
 */