package com.facebook.feed.background;

import android.os.Bundle;
import com.facebook.background.BackgroundResult;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.model.FeedType;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedParams.ViewMode;
import com.facebook.feed.protocol.FetchNewsFeedParamsBuilder;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.hardware.ScreenPowerState;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

class PrefetchNewsFeedBackgroundTask$PrefetchNewsFeedWorker
{
  private final Clock a;
  private final OrcaSharedPreferences b;
  private final NewsFeedServerSuppliedParameters c;
  private final OrcaServiceOperationFactory d;
  private final NewsFeedCache e;
  private final DeviceConditionHelper f;
  private final ScreenPowerState g;
  private final Provider<Boolean> h;
  private final Provider<String> i;
  private ListenableFuture<OperationResult> j;

  public PrefetchNewsFeedBackgroundTask$PrefetchNewsFeedWorker(Clock paramClock, OrcaSharedPreferences paramOrcaSharedPreferences, NewsFeedServerSuppliedParameters paramNewsFeedServerSuppliedParameters, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, NewsFeedCache paramNewsFeedCache, DeviceConditionHelper paramDeviceConditionHelper, ScreenPowerState paramScreenPowerState, Provider<Boolean> paramProvider, Provider<String> paramProvider1)
  {
    this.a = ((Clock)Preconditions.checkNotNull(paramClock));
    this.b = ((OrcaSharedPreferences)Preconditions.checkNotNull(paramOrcaSharedPreferences));
    this.c = ((NewsFeedServerSuppliedParameters)Preconditions.checkNotNull(paramNewsFeedServerSuppliedParameters));
    this.d = ((OrcaServiceOperationFactory)Preconditions.checkNotNull(paramOrcaServiceOperationFactory));
    this.e = ((NewsFeedCache)Preconditions.checkNotNull(paramNewsFeedCache));
    this.f = ((DeviceConditionHelper)Preconditions.checkNotNull(paramDeviceConditionHelper));
    this.g = ((ScreenPowerState)Preconditions.checkNotNull(paramScreenPowerState));
    this.h = ((Provider)Preconditions.checkNotNull(paramProvider));
    this.i = ((Provider)Preconditions.checkNotNull(paramProvider1));
  }

  private FeedType c()
  {
    if (this.b.a(FeedPrefKeys.D, FeedType.b.c).equals(FeedType.a.c));
    for (FeedType localFeedType = FeedType.a; ; localFeedType = FeedType.b)
      return localFeedType;
  }

  private String d()
  {
    FeedType localFeedType = c();
    FetchNewsFeedResult localFetchNewsFeedResult;
    if (this.e.a(localFeedType))
    {
      FetchNewsFeedParams localFetchNewsFeedParams = new FetchNewsFeedParamsBuilder().b(DataFreshnessParam.DO_NOT_CHECK_SERVER).b(1).f(localFeedType.c).c();
      localFetchNewsFeedResult = this.e.a(localFeedType, localFetchNewsFeedParams);
      if (localFetchNewsFeedResult == null);
    }
    for (String str = localFetchNewsFeedResult.b().startCursor; ; str = null)
      return str;
  }

  private FetchNewsFeedParams e()
  {
    return new FetchNewsFeedParamsBuilder().b(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).f(c().c).b(10).a(FetchNewsFeedParams.ViewMode.PREFETCH).d(d()).c();
  }

  private void f()
  {
    monitorenter;
    try
    {
      this.j = null;
      this.b.b().a(FeedPrefKeys.F, 1 + this.b.a(FeedPrefKeys.F, 0)).a();
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

  public boolean a()
  {
    monitorenter;
    while (true)
    {
      int m;
      try
      {
        boolean bool1 = this.b.a();
        k = 0;
        if (!bool1)
          continue;
        Object localObject2 = this.i.b();
        k = 0;
        if (localObject2 == null)
          return k;
        boolean bool2 = ((Boolean)this.h.b()).booleanValue();
        k = 0;
        if (!bool2)
          continue;
        ListenableFuture localListenableFuture = this.j;
        k = 0;
        if (localListenableFuture != null)
          continue;
        Long localLong = Long.valueOf(this.b.a(FeedPrefKeys.E, 0L));
        if (!this.g.a())
          continue;
        long l2 = this.c.c();
        boolean bool3 = this.a.a() < l2 + localLong.longValue();
        k = 0;
        if (bool3)
          continue;
        boolean bool4 = this.f.a(35);
        k = 0;
        if (!bool4)
          continue;
        boolean bool5 = this.f.a();
        k = 0;
        if (!bool5)
          continue;
        if (d() == null)
          continue;
        m = 1;
        break label215;
        long l1 = this.c.d();
        l2 = l1;
        continue;
        m = 0;
      }
      finally
      {
        monitorexit;
      }
      label215: int k = m;
    }
  }

  public ListenableFuture<BackgroundResult> b()
  {
    monitorenter;
    try
    {
      Object localObject2;
      if (this.j != null)
      {
        ListenableFuture localListenableFuture = Futures.a(new BackgroundResult(true));
        localObject2 = localListenableFuture;
      }
      while (true)
      {
        return localObject2;
        FetchNewsFeedParams localFetchNewsFeedParams = e();
        if (localFetchNewsFeedParams.c() == null)
        {
          localObject2 = Futures.a(new BackgroundResult(true));
          continue;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("fetchNewsFeedParams", localFetchNewsFeedParams);
        this.j = this.d.a("prefetch_news_feed", localBundle).d();
        localObject2 = new PrefetchNewsFeedBackgroundTask.PrefetchNewsFeedWorker.1(this, PrefetchNewsFeedBackgroundTask.a);
        Futures.a(this.j, (FutureCallback)localObject2);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.background.PrefetchNewsFeedBackgroundTask.PrefetchNewsFeedWorker
 * JD-Core Version:    0.6.0
 */