package com.facebook.feed.db;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.cache.FeedStoryPartial;
import com.facebook.feed.cache.FeedStoryPartial.Builder;
import com.facebook.feed.cache.FeedUnitPartial;
import com.facebook.feed.cache.FeedUnitPartialCache;
import com.facebook.feed.cache.PagesYouMayLikeFeedUnitPartial;
import com.facebook.feed.cache.PagesYouMayLikeFeedUnitPartial.Builder;
import com.facebook.feed.cache.PrefetchedFeedCache;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.feed.protocol.MarkImpressionsLoggedParams;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.inject.Provider;

public class NFDbServiceHandler
  implements OrcaServiceHandler.Filter
{
  private final OrcaSharedPreferences a;
  private final NewsFeedServerSuppliedParameters b;
  private final DbFeedHomeStoriesHandler c;
  private final PrefetchedFeedCache d;
  private final FeedUnitPartialCache e;
  private final NewsFeedUserDataCleaner f;
  private final Provider<Boolean> g;
  private final NewsFeedAnalyticsEventBuilder h;
  private final AnalyticsLogger i;
  private final FbErrorReporter j;
  private final PerformanceLogger k;
  private final Clock l;
  private final FeedbackMutator m;
  private boolean n;

  public NFDbServiceHandler(OrcaSharedPreferences paramOrcaSharedPreferences, NewsFeedServerSuppliedParameters paramNewsFeedServerSuppliedParameters, DbFeedHomeStoriesHandler paramDbFeedHomeStoriesHandler, PrefetchedFeedCache paramPrefetchedFeedCache, FeedUnitPartialCache paramFeedUnitPartialCache, NewsFeedUserDataCleaner paramNewsFeedUserDataCleaner, Provider<Boolean> paramProvider, NewsFeedAnalyticsEventBuilder paramNewsFeedAnalyticsEventBuilder, AnalyticsLogger paramAnalyticsLogger, FbErrorReporter paramFbErrorReporter, PerformanceLogger paramPerformanceLogger, Clock paramClock, FeedbackMutator paramFeedbackMutator)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = paramNewsFeedServerSuppliedParameters;
    this.c = paramDbFeedHomeStoriesHandler;
    this.d = paramPrefetchedFeedCache;
    this.e = paramFeedUnitPartialCache;
    this.f = paramNewsFeedUserDataCleaner;
    this.g = paramProvider;
    this.h = paramNewsFeedAnalyticsEventBuilder;
    this.i = paramAnalyticsLogger;
    this.j = paramFbErrorReporter;
    this.k = paramPerformanceLogger;
    this.l = paramClock;
    this.m = paramFeedbackMutator;
    this.n = true;
  }

  private void a(FetchNewsFeedResult paramFetchNewsFeedResult)
  {
    long l1 = this.a.a(FeedPrefKeys.G, 0L);
    if (l1 == 0L)
      this.a.b().a(FeedPrefKeys.F, 0).a(FeedPrefKeys.G, this.l.a()).a();
    long l2;
    do
    {
      return;
      l2 = this.l.a() - l1;
    }
    while (l2 < 1.25D * this.b.b());
    int i1 = (int)(l2 / 1000L);
    int i2 = this.a.a(FeedPrefKeys.F, 0);
    int i4;
    int i3;
    if ((paramFetchNewsFeedResult != null) && (!FetchNewsFeedResult.a.equals(paramFetchNewsFeedResult)))
    {
      i4 = (int)((this.l.a() - paramFetchNewsFeedResult.f()) / 1000L);
      i3 = paramFetchNewsFeedResult.a().size();
    }
    while (true)
    {
      this.a.b().a(FeedPrefKeys.F, 0).a(FeedPrefKeys.G, this.l.a()).a();
      HoneyClientEvent localHoneyClientEvent = this.h.a(i1, i2, i4, i3);
      this.i.a(localHoneyClientEvent);
      break;
      i3 = 0;
      i4 = 0;
    }
  }

  private OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    this.f.a(NewsFeedUserDataCleaner.StoreType.Disk);
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  private OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    if (localOperationResult.c())
    {
      ToggleLikeParams localToggleLikeParams = (ToggleLikeParams)paramOperationParams.b().getParcelable("toggleLikeParams");
      Feedback localFeedback = localToggleLikeParams.e;
      if ((localFeedback != null) && (localToggleLikeParams.c != null))
        this.e.a(this.m.a(localFeedback, localToggleLikeParams.c));
    }
    return localOperationResult;
  }

  private OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    MarkImpressionsLoggedParams localMarkImpressionsLoggedParams = (MarkImpressionsLoggedParams)paramOperationParams.b().getParcelable("markImpressionLoggedParams");
    String str1 = (String)Preconditions.checkNotNull(localMarkImpressionsLoggedParams.a);
    String str2 = localMarkImpressionsLoggedParams.b.c();
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (Objects.equal(str2, FeedStoryPartial.a))
      localObject = new FeedStoryPartial.Builder().a(str1).a(l1).a(true).a();
    while (true)
    {
      this.e.a((FeedUnitPartial)localObject);
      return OperationResult.b();
      boolean bool = Objects.equal(str2, PagesYouMayLikeFeedUnitPartial.a);
      localObject = null;
      if (!bool)
        continue;
      localObject = new PagesYouMayLikeFeedUnitPartial.Builder().a(str1).a(l1).a(true).a();
    }
  }

  private OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    if (localOperationResult.c())
    {
      FetchFeedbackResult localFetchFeedbackResult = (FetchFeedbackResult)localOperationResult.h();
      this.e.a(localFetchFeedbackResult.a);
    }
    return localOperationResult;
  }

  private OperationResult f(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchNewsFeedParams localFetchNewsFeedParams = (FetchNewsFeedParams)paramOperationParams.b().getParcelable("fetchNewsFeedParams");
    Tracer localTracer = Tracer.a("NFDbServiceHandler.handleFetchNewsFeed");
    while (true)
    {
      OperationResult localOperationResult1;
      OperationResult localOperationResult3;
      try
      {
        if ((localFetchNewsFeedParams.c() != null) || (DataFreshnessParam.STALE_DATA_OKAY != localFetchNewsFeedParams.e()))
          continue;
        boolean bool1 = true;
        localOperationResult1 = null;
        if (!bool1)
          continue;
        FetchNewsFeedResult localFetchNewsFeedResult4 = this.c.a(localFetchNewsFeedParams);
        DataFreshnessResult localDataFreshnessResult1 = DataFreshnessResult.NO_DATA;
        DataFreshnessResult localDataFreshnessResult2 = localFetchNewsFeedResult4.e();
        localOperationResult1 = null;
        if (localDataFreshnessResult1 == localDataFreshnessResult2)
          continue;
        localOperationResult1 = OperationResult.a(new FetchNewsFeedResult(localFetchNewsFeedResult4.b, this.e.a(localFetchNewsFeedResult4.c), localFetchNewsFeedResult4.e(), localFetchNewsFeedResult4.f()));
        if ((localFetchNewsFeedParams.c() == null) || (localFetchNewsFeedParams.d() != null) || (!((Boolean)this.g.b()).booleanValue()))
          continue;
        boolean bool2 = true;
        if ((localOperationResult1 != null) || (!bool2))
          continue;
        FetchNewsFeedResult localFetchNewsFeedResult3 = this.d.a(localFetchNewsFeedParams);
        if (localFetchNewsFeedResult3 == FetchNewsFeedResult.a)
          continue;
        localOperationResult1 = OperationResult.a(localFetchNewsFeedResult3);
        this.c.b(localFetchNewsFeedResult3);
        this.d.a(localFetchNewsFeedParams.f());
        this.a.b().a(FeedPrefKeys.H, true).a();
        a(localFetchNewsFeedResult3);
        if (localOperationResult1 != null)
          continue;
        localOperationResult3 = paramOrcaServiceHandler.a(paramOperationParams);
        if (localOperationResult3.c())
        {
          FetchNewsFeedResult localFetchNewsFeedResult2 = (FetchNewsFeedResult)localOperationResult3.h();
          if (localFetchNewsFeedResult2.c.feedUnitEdges.size() == 0)
            continue;
          this.c.a(localFetchNewsFeedResult2);
          localOperationResult2 = localOperationResult3;
          return localOperationResult2;
          bool1 = false;
          continue;
          bool2 = false;
          continue;
          FetchNewsFeedResult localFetchNewsFeedResult1 = (FetchNewsFeedResult)localOperationResult1.h();
          if (localFetchNewsFeedResult1.c.pageInfo != null)
            break label421;
          FbErrorReporter localFbErrorReporter = this.j;
          if (localFetchNewsFeedResult1.c.feedUnitEdges != null)
            continue;
          int i2 = 0;
          FeedUtils.a(localFbErrorReporter, "fetch_feed_db_failure", localFetchNewsFeedParams, i2, bool1, bool2);
          break label421;
          int i1 = localFetchNewsFeedResult1.c.feedUnitEdges.size();
          i2 = i1;
          continue;
        }
      }
      finally
      {
        localTracer.a();
      }
      OperationResult localOperationResult2 = localOperationResult3;
      continue;
      label421: localOperationResult2 = localOperationResult1;
    }
  }

  private OperationResult g(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    FetchNewsFeedResult localFetchNewsFeedResult;
    if (localOperationResult.c())
    {
      localFetchNewsFeedResult = (FetchNewsFeedResult)localOperationResult.h();
      FetchNewsFeedParams localFetchNewsFeedParams = (FetchNewsFeedParams)paramOperationParams.b().getParcelable("fetchNewsFeedParams");
      if (localFetchNewsFeedResult.a().size() != 0)
        break label66;
      this.d.a(localFetchNewsFeedParams.f());
    }
    while (true)
    {
      return localOperationResult;
      label66: this.d.a(localFetchNewsFeedResult);
    }
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult;
    if (!this.a.a(FeedPrefKeys.d, true))
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    while (true)
    {
      return localOperationResult;
      String str = paramOperationParams.a();
      if (FeedUtils.a(str))
      {
        if (this.n)
          this.k.a("NNFDbServiceHandlerInitialFetchFeedData");
        localOperationResult = f(paramOperationParams, paramOrcaServiceHandler);
        if (!this.n)
          continue;
        this.n = false;
        this.k.b("NNFDbServiceHandlerInitialFetchFeedData");
        continue;
      }
      if (str.equals("prefetch_news_feed"))
      {
        localOperationResult = g(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ((str.equals("fetch_likers")) || (str.equals("fetch_comments")) || (str.equals("fetch_feedback")))
      {
        localOperationResult = e(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("toggle_like".equals(str))
      {
        localOperationResult = c(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("clear_newsfeed_cache".equals(str))
      {
        localOperationResult = b(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("mark_impression_logged".equals(str))
      {
        localOperationResult = d(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NFDbServiceHandler
 * JD-Core Version:    0.6.0
 */