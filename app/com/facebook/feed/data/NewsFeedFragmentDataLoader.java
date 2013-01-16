package com.facebook.feed.data;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.analytics.performance.PerformanceLogger.MarkerConfig;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.model.DataLoaderConfig;
import com.facebook.feed.model.FetchRequestState;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.feed.util.FeedEdgeComparator;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.FindFriendsFeedUnit;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public class NewsFeedFragmentDataLoader extends AbstractDataLoader
{
  private static final String A = NewsFeedFragmentDataLoader.class.getSimpleName();
  private final Provider<Boolean> B;
  private boolean C = false;
  private String D = "";
  private boolean E = true;
  private boolean F = true;
  private boolean G = false;

  public NewsFeedFragmentDataLoader(FbFragmentActivity paramFbFragmentActivity, PerformanceLogger paramPerformanceLogger, MegaphoneStore paramMegaphoneStore, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, OrcaNetworkManager paramOrcaNetworkManager, AndroidThreadUtil paramAndroidThreadUtil, PendingStoryCache paramPendingStoryCache, Provider<String> paramProvider, FbErrorReporter paramFbErrorReporter, NewsFeedServerSuppliedParameters paramNewsFeedServerSuppliedParameters, Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2, ExecutorService paramExecutorService)
  {
    super(paramFbFragmentActivity, paramPerformanceLogger, paramMegaphoneStore, paramOrcaServiceOperationFactory, paramOrcaNetworkManager, paramPendingStoryCache, paramAndroidThreadUtil, paramProvider, paramFbErrorReporter, paramNewsFeedServerSuppliedParameters, paramProvider2, paramExecutorService);
    this.B = ((Provider)Preconditions.checkNotNull(paramProvider1));
  }

  private ListenableFuture<OperationResult> a(Parcelable paramParcelable, AbstractDataLoader.FetchFeedDirection paramFetchFeedDirection)
  {
    Bundle localBundle = new Bundle();
    String str = this.h.a(paramFetchFeedDirection);
    localBundle.putParcelable(this.h.c(), paramParcelable);
    return this.d.a(str, localBundle).e();
  }

  private List<FeedUnitEdge> a(List<FeedUnitEdge> paramList)
  {
    if ((!paramList.isEmpty()) || (!this.h.a().g()));
    while (true)
    {
      return paramList;
      this.G = true;
      paramList = ImmutableList.a(new FeedUnitEdge(new FindFriendsFeedUnit(), "dedup_key: findfriends_feed_unit", FeedEdgeComparator.b));
    }
  }

  private void a(int paramInt)
  {
    if ((paramInt > 0) && (this.G))
    {
      this.G = false;
      this.h.a().f();
    }
  }

  private void a(FetchNewsFeedResult paramFetchNewsFeedResult, Bundle paramBundle, AbstractDataLoader.FetchFeedDirection paramFetchFeedDirection)
  {
    boolean bool1 = true;
    a(paramFetchFeedDirection);
    if (!this.v)
      return;
    FeedHomeStories localFeedHomeStories = paramFetchNewsFeedResult.c;
    List localList1 = localFeedHomeStories.feedUnitEdges;
    DataFreshnessResult localDataFreshnessResult = paramFetchNewsFeedResult.e();
    int i = this.h.a().a(localList1);
    boolean bool2;
    label60: List localList2;
    if (paramFetchFeedDirection == AbstractDataLoader.FetchFeedDirection.BEFORE)
    {
      bool2 = bool1;
      a(i);
      if (!bool2)
        break label184;
      localList2 = a(localList1);
      if (localList1 == localList2)
        break label233;
      i++;
    }
    while (true)
    {
      if (localDataFreshnessResult == DataFreshnessResult.FROM_SERVER)
      {
        label97: this.h.a().a(localList2, localFeedHomeStories.pageInfo, bool1);
        if ((localDataFreshnessResult == DataFreshnessResult.FROM_CACHE_UP_TO_DATE) || (localDataFreshnessResult == DataFreshnessResult.FROM_SERVER))
        {
          this.u = paramFetchNewsFeedResult.f();
          this.y = this.u;
        }
      }
      while (true)
      {
        a(paramFetchNewsFeedResult.e());
        a(paramFetchNewsFeedResult.e(), bool2, paramBundle, i);
        break;
        bool2 = false;
        break label60;
        bool1 = false;
        break label97;
        label184: this.h.a().b(localList1, localFeedHomeStories.pageInfo);
        if (localFeedHomeStories.pageInfo.hasNextPage)
          continue;
        this.D = localFeedHomeStories.pageInfo.endCursor;
        this.C = bool1;
      }
      label233: localList2 = localList1;
    }
  }

  private void a(DataFreshnessResult paramDataFreshnessResult)
  {
    if (this.E)
    {
      this.E = false;
      long l = SystemClock.b().a();
      this.b.b("NNFFragmentDataLoaderInitialRequest", null, l);
      this.b.b("NewsFeedFragmentCreateToFetchNewsFeedSuccess", null, l);
      this.b.a(new PerformanceLogger.MarkerConfig("FetchSuccessToFirstRender").a(l));
    }
    if ((this.F) && ((paramDataFreshnessResult == DataFreshnessResult.FROM_CACHE_UP_TO_DATE) || (paramDataFreshnessResult == DataFreshnessResult.FROM_SERVER)))
    {
      this.F = false;
      if (!((Boolean)this.B.b()).booleanValue())
        break label124;
      this.b.b("NNFPrefetchStart");
      this.b.c("NNFFreshContentStart");
    }
    while (true)
    {
      return;
      label124: this.b.b("NNFFreshContentStart");
      this.b.c("NNFPrefetchStart");
    }
  }

  public FetchRequestState a(int paramInt, Bundle paramBundle)
  {
    FetchRequestState localFetchRequestState;
    if (this.s != null)
      localFetchRequestState = FetchRequestState.ALREADY_SCHEDULED;
    while (true)
    {
      return localFetchRequestState;
      String str = this.h.a().d();
      if ((this.C) && ((str == null) || (Objects.equal(this.D, str))))
      {
        localFetchRequestState = FetchRequestState.END_OF_FEED;
        continue;
      }
      this.C = false;
      this.D = "";
      this.s = a(this.h.a(AbstractDataLoader.FetchFeedDirection.AFTER, paramInt, null), AbstractDataLoader.FetchFeedDirection.AFTER);
      this.g.a(this.s, new NewsFeedFragmentDataLoader.2(this, paramBundle));
      localFetchRequestState = FetchRequestState.SUCCESS;
    }
  }

  public boolean a(DataFreshnessParam paramDataFreshnessParam, int paramInt, Bundle paramBundle)
  {
    if (this.E)
      this.b.a("NNFFragmentDataLoaderInitialRequest");
    if (this.r != null);
    for (int i = 0; ; i = 1)
    {
      return i;
      this.r = a(this.h.a(AbstractDataLoader.FetchFeedDirection.BEFORE, paramInt, paramDataFreshnessParam), AbstractDataLoader.FetchFeedDirection.BEFORE);
      this.g.a(this.r, new NewsFeedFragmentDataLoader.1(this, paramBundle));
      this.q.a();
    }
  }

  public long f()
  {
    return this.l.b();
  }

  public int g()
  {
    return 10;
  }

  public int h()
  {
    return 10;
  }

  protected String i()
  {
    return A;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.NewsFeedFragmentDataLoader
 * JD-Core Version:    0.6.0
 */