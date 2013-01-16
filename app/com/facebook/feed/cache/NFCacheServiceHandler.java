package com.facebook.feed.cache;

import android.os.Bundle;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.composer.optimistic.FeedCommentPreview;
import com.facebook.feed.db.DbFeedHomeStoriesHandler;
import com.facebook.feed.db.NewsFeedUserDataCleaner;
import com.facebook.feed.db.NewsFeedUserDataCleaner.StoreType;
import com.facebook.feed.model.FeedType;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.protocol.AddCommentParams;
import com.facebook.feed.protocol.ClearCacheAfterCursorParams;
import com.facebook.feed.protocol.FetchFeedbackParams;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.protocol.FetchFriendListFeedParams;
import com.facebook.feed.protocol.FetchFriendListFeedParamsBuilder;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedParamsBuilder;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.protocol.FetchSingleMediaParams;
import com.facebook.feed.protocol.FetchSingleMediaResult;
import com.facebook.feed.protocol.FetchSingleStoryParams;
import com.facebook.feed.protocol.FetchSingleStoryResult;
import com.facebook.feed.protocol.MarkImpressionsLoggedParams;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.util.FeedUtils;
import com.facebook.feed.util.FetchFeedbackType;
import com.facebook.feed.util.FetchNewsFeedType;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLMediaBuilder;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.google.common.base.Preconditions;
import java.util.List;

public class NFCacheServiceHandler
  implements OrcaServiceHandler.Filter
{
  private final OrcaSharedPreferences a;
  private final NewsFeedCache b;
  private final PendingStoryCache c;
  private final NewsFeedUserDataCleaner d;
  private final FbErrorReporter e;
  private final PerformanceLogger f;
  private final DbFeedHomeStoriesHandler g;
  private boolean h;

  public NFCacheServiceHandler(OrcaSharedPreferences paramOrcaSharedPreferences, NewsFeedCache paramNewsFeedCache, PendingStoryCache paramPendingStoryCache, NewsFeedUserDataCleaner paramNewsFeedUserDataCleaner, FbErrorReporter paramFbErrorReporter, PerformanceLogger paramPerformanceLogger, DbFeedHomeStoriesHandler paramDbFeedHomeStoriesHandler)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = paramNewsFeedCache;
    this.c = paramPendingStoryCache;
    this.d = paramNewsFeedUserDataCleaner;
    this.e = paramFbErrorReporter;
    this.f = paramPerformanceLogger;
    this.g = paramDbFeedHomeStoriesHandler;
    this.h = true;
  }

  private OperationResult a(OperationParams paramOperationParams)
  {
    long l = paramOperationParams.b().getLong("fetchNewsFeedUpdatesParamsKey");
    return OperationResult.a(this.b.a(l));
  }

  private OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchSingleMediaParams localFetchSingleMediaParams = (FetchSingleMediaParams)paramOperationParams.b().getParcelable("fetchMediaParams");
    Preconditions.checkNotNull(localFetchSingleMediaParams);
    String str = (String)Preconditions.checkNotNull(localFetchSingleMediaParams.a());
    OperationResult localOperationResult;
    if ((DataFreshnessParam)Preconditions.checkNotNull(localFetchSingleMediaParams.d()) != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
    {
      Feedback localFeedback = this.b.e(str);
      if (localFeedback != null)
      {
        GraphQLMediaBuilder localGraphQLMediaBuilder = new GraphQLMediaBuilder();
        localGraphQLMediaBuilder.a(localFeedback);
        localGraphQLMediaBuilder.a(str);
        localOperationResult = OperationResult.a(new FetchSingleMediaResult(localGraphQLMediaBuilder.j()));
      }
    }
    while (true)
    {
      return localOperationResult;
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      if (!localOperationResult.c())
        continue;
      FetchSingleMediaResult localFetchSingleMediaResult = (FetchSingleMediaResult)localOperationResult.h();
      if ((localFetchSingleMediaResult.a != null) && (localFetchSingleMediaResult.a.S() != null))
        this.b.a(localFetchSingleMediaResult.a.S(), str);
      localOperationResult = OperationResult.a(localFetchSingleMediaResult);
    }
  }

  private OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ClearCacheAfterCursorParams localClearCacheAfterCursorParams = (ClearCacheAfterCursorParams)paramOperationParams.b().getParcelable("clearCacheAfterCursorParamsKey");
    FeedType localFeedType = localClearCacheAfterCursorParams.a;
    NewsFeedType localNewsFeedType = NewsFeedType.getNewsFeedTypeByValue(localFeedType.c);
    String str = localClearCacheAfterCursorParams.b;
    List localList = this.b.a(localFeedType, str);
    this.g.a(localNewsFeedType, localList);
    return OperationResult.b();
  }

  private OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    this.d.a(NewsFeedUserDataCleaner.StoreType.Memory);
    return paramOrcaServiceHandler.a(paramOperationParams);
  }

  private OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult1 = paramOrcaServiceHandler.a(paramOperationParams);
    if (!localOperationResult1.c());
    for (OperationResult localOperationResult2 = localOperationResult1; ; localOperationResult2 = localOperationResult1)
    {
      return localOperationResult2;
      MarkImpressionsLoggedParams localMarkImpressionsLoggedParams = (MarkImpressionsLoggedParams)paramOperationParams.b().getParcelable("markImpressionLoggedParams");
      this.b.f(localMarkImpressionsLoggedParams.a);
    }
  }

  private OperationResult f(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult1 = paramOrcaServiceHandler.a(paramOperationParams);
    if (!localOperationResult1.c());
    for (OperationResult localOperationResult2 = localOperationResult1; ; localOperationResult2 = localOperationResult1)
    {
      return localOperationResult2;
      AddCommentParams localAddCommentParams = (AddCommentParams)paramOperationParams.b().getParcelable("addCommentParams");
      String str = localOperationResult1.f();
      FeedComment localFeedComment = FeedCommentPreview.a(localAddCommentParams.c.author, localAddCommentParams.c.body, str);
      this.b.a(localAddCommentParams.a, localFeedComment);
    }
  }

  private OperationResult g(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult1 = paramOrcaServiceHandler.a(paramOperationParams);
    OperationResult localOperationResult2;
    if (!localOperationResult1.c())
    {
      localOperationResult2 = localOperationResult1;
      return localOperationResult2;
    }
    ToggleLikeParams localToggleLikeParams = (ToggleLikeParams)paramOperationParams.b().getParcelable("toggleLikeParams");
    if (localToggleLikeParams.g == null)
      this.b.a(localToggleLikeParams.a, localToggleLikeParams.c, localToggleLikeParams.b);
    while (true)
    {
      localOperationResult2 = localOperationResult1;
      break;
      this.b.a(localToggleLikeParams.g, localToggleLikeParams.a, localToggleLikeParams.c, localToggleLikeParams.b);
    }
  }

  private OperationResult h(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult1 = paramOrcaServiceHandler.a(paramOperationParams);
    if (!localOperationResult1.c());
    for (OperationResult localOperationResult2 = localOperationResult1; ; localOperationResult2 = localOperationResult1)
    {
      return localOperationResult2;
      ToggleLikeParams localToggleLikeParams = (ToggleLikeParams)paramOperationParams.b().getParcelable("toggleLikeParams");
      this.b.a(localToggleLikeParams.f, localToggleLikeParams.b);
    }
  }

  private OperationResult i(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchSingleStoryParams localFetchSingleStoryParams = (FetchSingleStoryParams)paramOperationParams.b().getParcelable("fetchGrapgQLStoryParams");
    Preconditions.checkNotNull(localFetchSingleStoryParams.a);
    Object localObject;
    if (localFetchSingleStoryParams.b != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
    {
      FetchSingleStoryResult localFetchSingleStoryResult2 = this.b.a(localFetchSingleStoryParams.a);
      if (localFetchSingleStoryResult2 != null)
        localObject = OperationResult.a(localFetchSingleStoryResult2);
    }
    while (true)
    {
      return localObject;
      OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      if (!localOperationResult.c())
      {
        localObject = localOperationResult;
        continue;
      }
      FetchSingleStoryResult localFetchSingleStoryResult1 = (FetchSingleStoryResult)localOperationResult.h();
      this.b.a(localFetchSingleStoryResult1, null, FetchFeedbackType.getQueryType(localFetchSingleStoryParams));
      localObject = OperationResult.a(localFetchSingleStoryResult1);
    }
  }

  private OperationResult j(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchSingleStoryParams localFetchSingleStoryParams = (FetchSingleStoryParams)paramOperationParams.b().getParcelable("fetchPlatformStoryParams");
    Preconditions.checkNotNull(localFetchSingleStoryParams.a);
    Preconditions.checkNotNull(localFetchSingleStoryParams.b);
    Object localObject;
    if (localFetchSingleStoryParams.b != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
    {
      FetchSingleStoryResult localFetchSingleStoryResult2 = this.b.b(localFetchSingleStoryParams.a);
      if (localFetchSingleStoryResult2 != null)
        localObject = OperationResult.a(localFetchSingleStoryResult2);
    }
    while (true)
    {
      return localObject;
      OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      if (!localOperationResult.c())
      {
        localObject = localOperationResult;
        continue;
      }
      FetchSingleStoryResult localFetchSingleStoryResult1 = (FetchSingleStoryResult)localOperationResult.h();
      this.b.a(localFetchSingleStoryResult1, localFetchSingleStoryParams.a, FetchFeedbackType.getQueryType(localFetchSingleStoryParams));
      localObject = OperationResult.a(localFetchSingleStoryResult1);
    }
  }

  private OperationResult k(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchFeedbackParams localFetchFeedbackParams = (FetchFeedbackParams)paramOperationParams.b().getParcelable("fetchFeedbackParams");
    String str = localFetchFeedbackParams.a();
    DataFreshnessParam localDataFreshnessParam = localFetchFeedbackParams.d();
    Preconditions.checkNotNull(str);
    Preconditions.checkNotNull(localDataFreshnessParam);
    Object localObject;
    if (localDataFreshnessParam != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
    {
      FetchFeedbackResult localFetchFeedbackResult2 = this.b.d(str);
      if (localFetchFeedbackResult2 != null)
        localObject = OperationResult.a(localFetchFeedbackResult2);
    }
    while (true)
    {
      return localObject;
      OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
      if (!localOperationResult.c())
      {
        localObject = localOperationResult;
        continue;
      }
      FetchFeedbackResult localFetchFeedbackResult1 = (FetchFeedbackResult)localOperationResult.h();
      this.b.a(localFetchFeedbackResult1.a, FetchFeedbackType.getQueryType(localFetchFeedbackParams), null);
      localObject = OperationResult.a(localFetchFeedbackResult1);
    }
  }

  private OperationResult l(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Bundle localBundle = paramOperationParams.b();
    FetchNodeListParams localFetchNodeListParams1 = (FetchNodeListParams)localBundle.getParcelable("fetchCommentsParams");
    FetchNodeListParams localFetchNodeListParams3;
    String str1;
    if (localFetchNodeListParams1 == null)
    {
      localFetchNodeListParams3 = (FetchNodeListParams)localBundle.getParcelable("fetchLikersFeedParams");
      str1 = "fetchLikersFeedParams";
    }
    for (FetchNodeListParams localFetchNodeListParams2 = localFetchNodeListParams3; ; localFetchNodeListParams2 = localFetchNodeListParams1)
    {
      Preconditions.checkNotNull(localFetchNodeListParams2);
      String str2 = (String)Preconditions.checkNotNull(localFetchNodeListParams2.a());
      DataFreshnessParam localDataFreshnessParam = localFetchNodeListParams2.e();
      Preconditions.checkNotNull(localDataFreshnessParam);
      OperationResult localOperationResult;
      if (localDataFreshnessParam != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
      {
        FetchFeedbackResult localFetchFeedbackResult2 = this.b.a(str2, str1, localFetchNodeListParams2);
        if (localFetchFeedbackResult2 != null)
          localOperationResult = OperationResult.a(localFetchFeedbackResult2);
      }
      while (true)
      {
        return localOperationResult;
        localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
        if (!localOperationResult.c())
          continue;
        FetchFeedbackResult localFetchFeedbackResult1 = (FetchFeedbackResult)localOperationResult.h();
        this.b.a(localFetchFeedbackResult1.a, FetchFeedbackType.getQueryType(str1, localFetchNodeListParams2), localFetchNodeListParams2.c());
        localOperationResult = OperationResult.a(localFetchFeedbackResult1);
      }
      str1 = "fetchCommentsParams";
    }
  }

  private OperationResult m(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Bundle localBundle1 = paramOperationParams.b();
    String str3;
    FetchNewsFeedParams localFetchNewsFeedParams2;
    Object localObject1;
    if (FeedUtils.a(paramOperationParams.a()))
    {
      str3 = paramOperationParams.a();
      localFetchNewsFeedParams2 = (FetchNewsFeedParams)localBundle1.getParcelable("fetchNewsFeedParams");
      if (localFetchNewsFeedParams2 == null)
        localObject1 = OperationResult.a(ErrorCode.OTHER, "Invalid params " + localBundle1.keySet().toString());
    }
    while (true)
    {
      return localObject1;
      FeedType localFeedType = new FeedType(localFetchNewsFeedParams2.f());
      String str2 = "fetchNewsFeedParams";
      Object localObject2 = str3;
      Object localObject3 = localFetchNewsFeedParams2;
      label102: FetchNewsFeedType localFetchNewsFeedType = FetchNewsFeedType.getQueryType((FetchNewsFeedParams)localObject3);
      FetchNewsFeedResult localFetchNewsFeedResult1 = this.b.a(localFeedType, (FetchNewsFeedParams)localObject3);
      FeedHomeStories localFeedHomeStories = localFetchNewsFeedResult1.c;
      FbErrorReporter localFbErrorReporter;
      if (localFetchNewsFeedResult1.c.pageInfo == null)
      {
        localFbErrorReporter = this.e;
        if (localFetchNewsFeedResult1.c.feedUnitEdges != null)
          break label314;
      }
      label314: for (int i = 0; ; i = localFetchNewsFeedResult1.c.feedUnitEdges.size())
      {
        FeedUtils.a(localFbErrorReporter, "fetch_feed_memory_failure", (FetchNewsFeedParams)localObject3, i, false, false);
        if (((FetchNewsFeedParams)localObject3).e() != DataFreshnessParam.DO_NOT_CHECK_SERVER)
          break label332;
        localObject1 = OperationResult.a(localFetchNewsFeedResult1);
        break;
        if (FeedUtils.b(paramOperationParams.a()))
        {
          String str1 = paramOperationParams.a();
          FetchNewsFeedParams localFetchNewsFeedParams1 = (FetchNewsFeedParams)localBundle1.getParcelable("fetchFriendListFeedParams");
          if (localFetchNewsFeedParams1 == null)
          {
            localObject1 = OperationResult.a(ErrorCode.OTHER, "Invalid params " + localBundle1.keySet().toString());
            break;
          }
          localFeedType = new FeedType(((FetchFriendListFeedParams)localFetchNewsFeedParams1).a());
          str2 = "fetchFriendListFeedParams";
          localObject2 = str1;
          localObject3 = localFetchNewsFeedParams1;
          break label102;
        }
        localObject1 = OperationResult.a(ErrorCode.OTHER, "handleFetchFeed is called for invalid operation type!");
        break;
      }
      label332: if ((((FetchNewsFeedParams)localObject3).e() == DataFreshnessParam.STALE_DATA_OKAY) && (localFeedHomeStories.feedUnitEdges.size() > 0))
      {
        localObject1 = OperationResult.a(localFetchNewsFeedResult1);
        continue;
      }
      Object localObject4 = new FetchNewsFeedParamsBuilder().a((FetchNewsFeedParams)localObject3);
      if (FeedUtils.b((String)localObject2))
        localObject4 = new FetchFriendListFeedParamsBuilder().a((FetchFriendListFeedParams)localObject3);
      if (localFeedHomeStories.pageInfo.startCursor != null)
        switch (NFCacheServiceHandler.1.a[localFetchNewsFeedType.ordinal()])
        {
        case 1:
        default:
        case 2:
        case 3:
        case 4:
        }
      OperationResult localOperationResult;
      while (true)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putParcelable(str2, ((FetchNewsFeedParamsBuilder)localObject4).c());
        localOperationResult = paramOrcaServiceHandler.a(new OperationParams((String)localObject2, localBundle2));
        if (localOperationResult.c())
          break label564;
        localObject1 = localOperationResult;
        break;
        ((FetchNewsFeedParamsBuilder)localObject4).d(localFeedHomeStories.pageInfo.startCursor);
        continue;
        ((FetchNewsFeedParamsBuilder)localObject4).e(localFeedHomeStories.pageInfo.endCursor).b(((FetchNewsFeedParams)localObject3).b() - localFeedHomeStories.feedUnitEdges.size());
      }
      label564: FetchNewsFeedResult localFetchNewsFeedResult2 = (FetchNewsFeedResult)localOperationResult.h();
      this.b.a(localFeedType, localFetchNewsFeedResult2);
      if ((localFetchNewsFeedType == FetchNewsFeedType.LATEST_N_STORIES) || (localFetchNewsFeedType == FetchNewsFeedType.LATEST_N_STORIES_BEFORE_A_CURSOR))
        this.c.a();
      FetchNewsFeedResult localFetchNewsFeedResult3 = this.b.a(localFeedType, (FetchNewsFeedParams)localObject3);
      if (localFetchNewsFeedResult3.e() == DataFreshnessResult.NO_DATA)
      {
        if (localFetchNewsFeedResult1.e() != DataFreshnessResult.NO_DATA)
        {
          localObject1 = OperationResult.a(localFetchNewsFeedResult1);
          continue;
        }
        localObject1 = localOperationResult;
        continue;
      }
      localObject1 = OperationResult.a(new FetchNewsFeedResult((FetchNewsFeedParams)localObject3, localFetchNewsFeedResult3.c, localFetchNewsFeedResult2.e(), localFetchNewsFeedResult2.f()));
    }
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OperationResult localOperationResult;
    if (!this.a.a(FeedPrefKeys.c, true))
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    while (true)
    {
      return localOperationResult;
      String str = paramOperationParams.a();
      if ((FeedUtils.a(str)) || (FeedUtils.b(str)))
      {
        if (this.h)
          this.f.a("NNFCacheServiceHandlerInitialFetchFeedData");
        localOperationResult = m(paramOperationParams, paramOrcaServiceHandler);
        if (!this.h)
          continue;
        this.h = false;
        this.f.b("NNFCacheServiceHandlerInitialFetchFeedData");
        continue;
      }
      if ("fetch_platform_story".equals(str))
      {
        localOperationResult = j(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("fetch_graphql_story".equals(str))
      {
        localOperationResult = i(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("fetch_feedback".equals(str))
      {
        localOperationResult = k(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if (("fetch_comments".equals(str)) || ("fetch_likers".equals(str)))
      {
        localOperationResult = l(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("fetch_news_feed_updates".equals(str))
      {
        localOperationResult = a(paramOperationParams);
        continue;
      }
      if ("toggle_like".equals(str))
      {
        localOperationResult = g(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("toggle_page_like".equals(str))
      {
        localOperationResult = h(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("add_comment".equals(str))
      {
        localOperationResult = f(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("clear_newsfeed_cache".equals(str))
      {
        localOperationResult = d(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("mark_impression_logged".equals(str))
      {
        localOperationResult = e(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("fetch_media".equals(str))
      {
        localOperationResult = b(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      if ("clear_cache_after_cursor".equals(str))
      {
        localOperationResult = c(paramOperationParams, paramOrcaServiceHandler);
        continue;
      }
      localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.NFCacheServiceHandler
 * JD-Core Version:    0.6.0
 */