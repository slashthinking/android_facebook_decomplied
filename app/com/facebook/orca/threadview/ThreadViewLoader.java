package com.facebook.orca.threadview;

import android.os.Bundle;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.SendMessageManager;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchMoreMessagesParams;
import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagesCollectionMerger;
import com.facebook.orca.threads.MessagesUiReorderer;
import com.facebook.orca.threads.ThreadSummary;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class ThreadViewLoader
{
  public static ThreadViewLoader.Result a;
  private static final Class<?> b = ThreadViewLoader.class;
  private final DataCache c;
  private final OrcaServiceOperationFactory d;
  private final MessagesUiReorderer e;
  private final SendMessageManager f;
  private final PendingSendsDeduper g;
  private final MessagesCollectionMerger h;
  private final Clock i;
  private String j;
  private ThreadViewLoader.Callback k;
  private ListenableFuture<OperationResult> l;
  private ListenableFuture<OperationResult> m;
  private DataFreshnessParam n;
  private ThreadViewLoader.Params o;
  private ThreadViewLoader.Result p;
  private boolean q;
  private String r;

  static
  {
    a = new ThreadViewLoader.Result(null, null, null);
  }

  public ThreadViewLoader(DataCache paramDataCache, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, MessagesUiReorderer paramMessagesUiReorderer, SendMessageManager paramSendMessageManager, PendingSendsDeduper paramPendingSendsDeduper, MessagesCollectionMerger paramMessagesCollectionMerger, Clock paramClock)
  {
    this.c = paramDataCache;
    this.d = paramOrcaServiceOperationFactory;
    this.e = paramMessagesUiReorderer;
    this.f = paramSendMessageManager;
    this.g = paramPendingSendsDeduper;
    this.h = paramMessagesCollectionMerger;
    this.i = paramClock;
  }

  private static ThreadViewLoader.Params a(ThreadViewLoader.Params paramParams1, ThreadViewLoader.Params paramParams2)
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
        paramParams1 = new ThreadViewLoader.Params(bool1, bool2);
      return paramParams1;
    }
  }

  private ThreadViewLoader.Result a(ThreadSummary paramThreadSummary, MessagesCollection paramMessagesCollection)
  {
    MessagesCollection localMessagesCollection = this.e.a(paramMessagesCollection);
    return new ThreadViewLoader.Result(paramThreadSummary, localMessagesCollection, this.g.a(localMessagesCollection, this.f.a(this.j)));
  }

  private void a(ServiceException paramServiceException)
  {
    ThreadViewLoader.Error localError = new ThreadViewLoader.Error(paramServiceException, this.o.b);
    this.k.a(ThreadViewLoader.LoadType.THREAD_VIEW, localError);
  }

  private void a(DataFreshnessParam paramDataFreshnessParam)
  {
    if (this.l != null);
    while (true)
    {
      return;
      BLog.b(b, "Starting thread fetch (%s)", new Object[] { paramDataFreshnessParam });
      this.n = paramDataFreshnessParam;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadParams", new FetchThreadParamsBuilder().a(ThreadCriteria.a(this.j)).a(paramDataFreshnessParam).a(50).h());
      if (this.r != null)
        localBundle.putString("override_auth_token", this.r);
      this.l = this.d.a("fetch_thread", localBundle).d();
      this.k.a(ThreadViewLoader.LoadType.THREAD_VIEW);
      Futures.a(this.l, new ThreadViewLoader.1(this));
    }
  }

  private void a(OperationResult paramOperationResult)
  {
    FetchThreadResult localFetchThreadResult = (FetchThreadResult)paramOperationResult.h();
    this.p = a(localFetchThreadResult.a(), localFetchThreadResult.b());
    this.k.a(ThreadViewLoader.LoadType.THREAD_VIEW, this.p);
    DataFreshnessResult localDataFreshnessResult = localFetchThreadResult.e();
    if ((this.o.a) && (this.n != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) && (localDataFreshnessResult != DataFreshnessResult.FROM_SERVER) && (localDataFreshnessResult != DataFreshnessResult.FROM_CACHE_HAD_SERVER_ERROR))
    {
      BLog.b(b, "Starting load because need to hit server");
      a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
    }
    while (true)
    {
      return;
      if (localDataFreshnessResult == DataFreshnessResult.FROM_CACHE_STALE)
      {
        BLog.b(b, "Starting load because data from cache was stale");
        a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
        continue;
      }
      BLog.b(b, "Finished loading");
      this.k.b(ThreadViewLoader.LoadType.THREAD_VIEW);
    }
  }

  private void b()
  {
    this.o = null;
    this.p = null;
    if (this.l != null)
    {
      this.l.cancel(false);
      this.l = null;
    }
    if (this.m != null)
    {
      this.m.cancel(false);
      this.m = null;
    }
  }

  private void b(ServiceException paramServiceException)
  {
    this.k.a(ThreadViewLoader.LoadType.MORE_MESSAGES, new ThreadViewLoader.Error(paramServiceException, this.q));
    this.q = false;
  }

  private void b(OperationResult paramOperationResult)
  {
    if (this.p == null);
    while (true)
    {
      return;
      this.q = false;
      if ((this.p.a == null) || (this.p.b == null))
        continue;
      FetchMoreMessagesResult localFetchMoreMessagesResult = (FetchMoreMessagesResult)paramOperationResult.h();
      MessagesCollection localMessagesCollection = this.h.a(this.p.b, localFetchMoreMessagesResult.a());
      this.p = new ThreadViewLoader.Result(this.p.a, localMessagesCollection, this.p.c);
      this.k.a(ThreadViewLoader.LoadType.MORE_MESSAGES, this.p);
    }
  }

  public void a(ThreadViewLoader.Callback paramCallback)
  {
    this.k = paramCallback;
  }

  public void a(ThreadViewLoader.Params paramParams)
  {
    ThreadSummary localThreadSummary = this.c.b(this.j);
    MessagesCollection localMessagesCollection = this.c.c(this.j);
    int i1;
    if ((localThreadSummary != null) && (localMessagesCollection != null))
    {
      this.p = a(localThreadSummary, localMessagesCollection);
      this.k.a(ThreadViewLoader.LoadType.THREAD_VIEW, this.p);
      i1 = 1;
      if (this.l != null)
        break label124;
      this.o = paramParams;
      if (i1 == 0)
        break label207;
      if (!paramParams.a)
        break label148;
      BLog.b(b, "Starting load because need to hit server");
      a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
    }
    while (true)
    {
      return;
      i1 = 0;
      if (localThreadSummary == null)
        break;
      this.k.a(localThreadSummary);
      i1 = 0;
      break;
      label124: BLog.b(b, "Load already in progress");
      this.o = a(this.o, paramParams);
      continue;
      label148: if (this.c.a(ThreadCriteria.a(this.j)))
      {
        BLog.b(b, "Starting load because data cache said to request new update");
        a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
        continue;
      }
      BLog.b(b, "Finished loading");
      this.k.b(ThreadViewLoader.LoadType.THREAD_VIEW);
      continue;
      label207: BLog.b(b, "No cached data. Starting load");
      a(DataFreshnessParam.STALE_DATA_OKAY);
    }
  }

  public void a(String paramString)
  {
    if (paramString != this.j)
    {
      this.j = paramString;
      b();
    }
  }

  public void a(boolean paramBoolean)
  {
    if (this.l != null);
    while (true)
    {
      return;
      if ((this.m == null) && (this.p != null) && (this.p.a != null) && (this.p.b != null))
      {
        ImmutableList localImmutableList = this.p.b.b();
        if ((localImmutableList.size() == 0) || (this.p.b.d()))
          continue;
        long l1 = ((Message)localImmutableList.get(-1 + localImmutableList.size())).c();
        FetchMoreMessagesParams localFetchMoreMessagesParams = new FetchMoreMessagesParams(ThreadCriteria.a(this.j), 0L, l1, 50);
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("fetchMoreMessagesParams", localFetchMoreMessagesParams);
        if (this.r != null)
          localBundle.putString("override_auth_token", this.r);
        this.m = this.d.a("fetch_more_messages", localBundle).d();
        this.k.a(ThreadViewLoader.LoadType.MORE_MESSAGES);
        this.q = paramBoolean;
        Futures.a(this.m, new ThreadViewLoader.2(this));
        continue;
      }
    }
  }

  public boolean a()
  {
    if ((this.o.a) || (this.c.b(ThreadCriteria.a(this.j))));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void b(String paramString)
  {
    if (!Objects.equal(this.r, paramString))
    {
      this.r = paramString;
      b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewLoader
 * JD-Core Version:    0.6.0
 */