package com.facebook.feed.data;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.model.DataLoaderConfig;
import com.facebook.feed.model.FetchRequestState;
import com.facebook.feed.model.FetchResultState;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.feed.util.composer.ComposerActivityReceiver;
import com.facebook.graphql.model.GraphQLError;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.data.MegaphoneStore.MegaphoneUpdateListener;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public abstract class AbstractDataLoader
{
  private ListenableFuture<OperationResult> A;
  private final Provider<String> B;
  private final Provider<Boolean> C;
  protected final FbFragmentActivity a;
  protected final PerformanceLogger b;
  protected final Handler c = new Handler();
  protected final OrcaServiceOperationFactory d;
  protected final OrcaNetworkManager e;
  protected final PendingStoryCache f;
  protected final AndroidThreadUtil g;
  protected DataLoaderConfig h;
  protected final MegaphoneStore i;
  protected final MegaphoneStore.MegaphoneUpdateListener j;
  protected final FbErrorReporter k;
  protected final NewsFeedServerSuppliedParameters l;
  protected final ExecutorService m;
  protected final Runnable n = new AbstractDataLoader.1(this);
  protected ComposerActivityReceiver o;
  protected FeedNetworkConnectivityReceiver p;
  protected FeedDataLoaderListener q = e();
  protected ListenableFuture<OperationResult> r;
  protected ListenableFuture<OperationResult> s;
  protected ListenableFuture<OperationResult> t;
  protected long u = 0L;
  protected boolean v = false;
  protected boolean w = false;
  protected String x = "";
  protected long y = 0L;
  protected long z = 0L;

  public AbstractDataLoader(FbFragmentActivity paramFbFragmentActivity, PerformanceLogger paramPerformanceLogger, MegaphoneStore paramMegaphoneStore, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, OrcaNetworkManager paramOrcaNetworkManager, PendingStoryCache paramPendingStoryCache, AndroidThreadUtil paramAndroidThreadUtil, Provider<String> paramProvider, FbErrorReporter paramFbErrorReporter, NewsFeedServerSuppliedParameters paramNewsFeedServerSuppliedParameters, Provider<Boolean> paramProvider1, ExecutorService paramExecutorService)
  {
    this.a = ((FbFragmentActivity)Preconditions.checkNotNull(paramFbFragmentActivity));
    this.b = ((PerformanceLogger)Preconditions.checkNotNull(paramPerformanceLogger));
    this.d = ((OrcaServiceOperationFactory)Preconditions.checkNotNull(paramOrcaServiceOperationFactory));
    this.e = ((OrcaNetworkManager)Preconditions.checkNotNull(paramOrcaNetworkManager));
    this.f = ((PendingStoryCache)Preconditions.checkNotNull(paramPendingStoryCache));
    this.g = ((AndroidThreadUtil)Preconditions.checkNotNull(paramAndroidThreadUtil));
    this.B = paramProvider;
    this.i = ((MegaphoneStore)Preconditions.checkNotNull(paramMegaphoneStore));
    this.j = j();
    this.k = ((FbErrorReporter)Preconditions.checkNotNull(paramFbErrorReporter));
    this.l = ((NewsFeedServerSuppliedParameters)Preconditions.checkNotNull(paramNewsFeedServerSuppliedParameters));
    this.C = ((Provider)Preconditions.checkNotNull(paramProvider1));
    this.m = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
  }

  private MegaphoneStore.MegaphoneUpdateListener j()
  {
    return new AbstractDataLoader.2(this);
  }

  private void k()
  {
    this.A = this.d.a("clear_newsfeed_cache", new Bundle()).e();
    this.g.a(this.A, new AbstractDataLoader.7(this));
  }

  public abstract FetchRequestState a(int paramInt, Bundle paramBundle);

  public void a()
  {
    long l1 = 0L;
    if (!this.v)
      this.l.i_();
    this.v = true;
    if (this.r != null);
    while (true)
    {
      return;
      if ((this.u != l1) && (System.currentTimeMillis() - this.u < f()))
        l1 = f() - (System.currentTimeMillis() - this.u);
      if (this.p != null)
        this.p.a();
      a(l1);
    }
  }

  protected void a(long paramLong)
  {
    if (this.r != null);
    while (true)
    {
      return;
      this.c.postDelayed(this.n, paramLong);
    }
  }

  public void a(Bundle paramBundle)
  {
    if ((this.t != null) || (this.h.a().g()));
    while (true)
    {
      return;
      long l1 = this.y;
      Bundle localBundle = new Bundle();
      localBundle.putLong("fetchNewsFeedUpdatesParamsKey", l1);
      this.t = this.d.a("fetch_news_feed_updates", localBundle).e();
      this.g.a(this.t, new AbstractDataLoader.3(this, paramBundle));
    }
  }

  protected void a(AbstractDataLoader.FetchFeedDirection paramFetchFeedDirection)
  {
    switch (AbstractDataLoader.9.a[paramFetchFeedDirection.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      this.s = null;
      continue;
      this.r = null;
    }
  }

  public void a(FeedDataLoaderListener paramFeedDataLoaderListener)
  {
    if (paramFeedDataLoaderListener != null);
    while (true)
    {
      this.q = paramFeedDataLoaderListener;
      return;
      paramFeedDataLoaderListener = e();
    }
  }

  public void a(DataLoaderConfig paramDataLoaderConfig)
  {
    this.h = ((DataLoaderConfig)Preconditions.checkNotNull(paramDataLoaderConfig));
    c();
  }

  protected void a(DataFreshnessResult paramDataFreshnessResult, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    this.c.removeCallbacks(this.n);
    a();
    this.q.a(paramBoolean, FetchResultState.SUCCESS, paramBundle, paramInt);
    if ((paramDataFreshnessResult == DataFreshnessResult.FROM_CACHE_STALE) || (paramDataFreshnessResult == DataFreshnessResult.FROM_CACHE_UP_TO_DATE))
      this.b.b("NNFCacheColdStart");
    while (true)
    {
      this.b.b("NNFColdStart");
      this.b.b("NNFWarmStart");
      return;
      this.b.c("NNFCacheColdStart");
    }
  }

  protected void a(Exception paramException, AbstractDataLoader.FetchFeedDirection paramFetchFeedDirection, Bundle paramBundle)
  {
    a(paramFetchFeedDirection);
    FetchResultState localFetchResultState;
    if ((paramException instanceof ServiceException))
      localFetchResultState = FetchResultState.SERVICE_EXCEPTION;
    while (true)
    {
      FeedDataLoaderListener localFeedDataLoaderListener = this.q;
      boolean bool;
      label33: GraphQLError localGraphQLError;
      if (paramFetchFeedDirection == AbstractDataLoader.FetchFeedDirection.BEFORE)
      {
        bool = true;
        localFeedDataLoaderListener.a(bool, (FetchResultState)Preconditions.checkNotNull(localFetchResultState), paramBundle, -1);
        this.c.removeCallbacks(this.n);
        if (localFetchResultState == FetchResultState.SERVICE_EXCEPTION)
        {
          Parcelable localParcelable = ((ServiceException)paramException).b().h();
          if (!(localParcelable instanceof GraphQLError))
            break label188;
          localGraphQLError = (GraphQLError)localParcelable;
          label98: if ((localGraphQLError == null) || (localGraphQLError.isTransient) || (localGraphQLError.requiresReauth))
            break label194;
          this.k.a("graph_ql_api_error", "GraphQLError: " + localGraphQLError.toString());
          this.u = System.currentTimeMillis();
          k();
        }
      }
      while (true)
      {
        return;
        if (!(paramException instanceof CancellationException))
          break label302;
        localFetchResultState = FetchResultState.CANCELLATION;
        break;
        bool = false;
        break label33;
        label188: localGraphQLError = null;
        break label98;
        label194: if (!this.e.b())
          continue;
        if (((Boolean)this.C.b()).booleanValue())
        {
          Bundle localBundle = ((ServiceException)paramException).b().j();
          if (localBundle != null)
          {
            String str1 = (String)localBundle.get("originalExceptionMessage");
            String str2 = (String)localBundle.get("originalExceptionStack");
            this.m.submit(new AbstractDataLoader.6(this, str1, str2, paramException));
          }
        }
        this.u = System.currentTimeMillis();
        a();
      }
      label302: localFetchResultState = null;
    }
  }

  public abstract boolean a(DataFreshnessParam paramDataFreshnessParam, int paramInt, Bundle paramBundle);

  public void b()
  {
    d();
    PagedFeedUnitCollection localPagedFeedUnitCollection = this.h.a();
    if (localPagedFeedUnitCollection != null)
      localPagedFeedUnitCollection.f();
    if (this.o != null)
      this.o.b();
    this.q = e();
    this.i.b("NEWSFEED", this.j);
  }

  protected void c()
  {
    PagedFeedUnitCollection localPagedFeedUnitCollection = this.h.a();
    this.o = new ComposerActivityReceiver(new AbstractDataLoader.4(this), localPagedFeedUnitCollection.b(), this.f, true, this.a);
    this.p = new AbstractDataLoader.5(this, this.a, localPagedFeedUnitCollection);
    this.i.a("NEWSFEED", this.j);
  }

  public void d()
  {
    this.v = false;
    this.c.removeCallbacks(this.n);
    if (this.r != null)
    {
      this.r.cancel(true);
      this.r = null;
    }
    if (this.s != null)
    {
      this.s.cancel(true);
      this.s = null;
    }
    if (this.t != null)
    {
      this.t.cancel(true);
      this.t = null;
    }
    if (this.A != null)
    {
      this.A.cancel(true);
      this.A = null;
    }
    if (this.p != null)
      this.p.b();
  }

  protected FeedDataLoaderListener e()
  {
    return new AbstractDataLoader.8(this);
  }

  public abstract long f();

  public abstract int g();

  public abstract int h();

  protected abstract String i();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AbstractDataLoader
 * JD-Core Version:    0.6.0
 */