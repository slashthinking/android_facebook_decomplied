package com.facebook.feed.server;

import android.os.Bundle;
import com.facebook.composer.server.ComposerPublishServiceHandler;
import com.facebook.feed.cache.StoryUpdate;
import com.facebook.feed.protocol.AddCommentMethod;
import com.facebook.feed.protocol.AddCommentParams;
import com.facebook.feed.protocol.ApiMethodNotFoundException;
import com.facebook.feed.protocol.DeleteCommentMethod;
import com.facebook.feed.protocol.DeleteCommentParams;
import com.facebook.feed.protocol.FetchCommentsMethod;
import com.facebook.feed.protocol.FetchFeedbackMethod;
import com.facebook.feed.protocol.FetchFeedbackParams;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.protocol.FetchFriendListFeedMethod;
import com.facebook.feed.protocol.FetchFriendListFeedParams;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.feed.protocol.FetchLikersMethod;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.protocol.FetchPlatformStoryMethod;
import com.facebook.feed.protocol.FetchSingleMediaMethod;
import com.facebook.feed.protocol.FetchSingleMediaParams;
import com.facebook.feed.protocol.FetchSingleMediaResult;
import com.facebook.feed.protocol.FetchSingleStoryParams;
import com.facebook.feed.protocol.FetchSingleStoryResult;
import com.facebook.feed.protocol.PrefetchNewsFeedMethod;
import com.facebook.feed.protocol.ToggleLikeMethod;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.protocol.coupons.ClaimCouponMethod;
import com.facebook.feed.protocol.coupons.ClaimCouponParams;
import com.facebook.feed.util.FeedUtils;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class NewsFeedServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final FetchNewsFeedMethod b;
  private final PrefetchNewsFeedMethod c;
  private final FetchFriendListFeedMethod d;
  private final AddCommentMethod e;
  private final DeleteCommentMethod f;
  private final ToggleLikeMethod g;
  private final FetchPlatformStoryMethod h;
  private final FetchGraphQLStoryMethod i;
  private final FetchCommentsMethod j;
  private final FetchLikersMethod k;
  private final FetchFeedbackMethod l;
  private final ComposerPublishServiceHandler m;
  private final ClaimCouponMethod n;
  private final FetchSingleMediaMethod o;

  public NewsFeedServiceHandler(Provider<SingleMethodRunner> paramProvider, ComposerPublishServiceHandler paramComposerPublishServiceHandler, FetchNewsFeedMethod paramFetchNewsFeedMethod, PrefetchNewsFeedMethod paramPrefetchNewsFeedMethod, FetchFriendListFeedMethod paramFetchFriendListFeedMethod, AddCommentMethod paramAddCommentMethod, DeleteCommentMethod paramDeleteCommentMethod, ToggleLikeMethod paramToggleLikeMethod, FetchPlatformStoryMethod paramFetchPlatformStoryMethod, FetchGraphQLStoryMethod paramFetchGraphQLStoryMethod, FetchCommentsMethod paramFetchCommentsMethod, FetchLikersMethod paramFetchLikersMethod, FetchFeedbackMethod paramFetchFeedbackMethod, ClaimCouponMethod paramClaimCouponMethod, FetchSingleMediaMethod paramFetchSingleMediaMethod)
  {
    this.b = paramFetchNewsFeedMethod;
    this.c = paramPrefetchNewsFeedMethod;
    this.d = paramFetchFriendListFeedMethod;
    this.a = paramProvider;
    this.e = paramAddCommentMethod;
    this.f = paramDeleteCommentMethod;
    this.g = paramToggleLikeMethod;
    this.h = paramFetchPlatformStoryMethod;
    this.i = paramFetchGraphQLStoryMethod;
    this.j = paramFetchCommentsMethod;
    this.k = paramFetchLikersMethod;
    this.l = paramFetchFeedbackMethod;
    this.m = paramComposerPublishServiceHandler;
    this.n = paramClaimCouponMethod;
    this.o = paramFetchSingleMediaMethod;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    return OperationResult.b();
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    return OperationResult.b();
  }

  private OperationResult d(OperationParams paramOperationParams)
  {
    FetchNodeListParams localFetchNodeListParams = (FetchNodeListParams)paramOperationParams.b().getParcelable("fetchCommentsParams");
    return OperationResult.a((FetchFeedbackResult)((SingleMethodRunner)this.a.b()).a(this.j, localFetchNodeListParams));
  }

  private OperationResult e(OperationParams paramOperationParams)
  {
    FetchSingleStoryParams localFetchSingleStoryParams = (FetchSingleStoryParams)paramOperationParams.b().getParcelable("fetchPlatformStoryParams");
    return OperationResult.a((FetchSingleStoryResult)((SingleMethodRunner)this.a.b()).a(this.h, localFetchSingleStoryParams));
  }

  private OperationResult f(OperationParams paramOperationParams)
  {
    FetchSingleStoryParams localFetchSingleStoryParams = (FetchSingleStoryParams)paramOperationParams.b().getParcelable("fetchGrapgQLStoryParams");
    return OperationResult.a((FetchSingleStoryResult)((SingleMethodRunner)this.a.b()).a(this.i, localFetchSingleStoryParams));
  }

  private OperationResult g(OperationParams paramOperationParams)
  {
    ToggleLikeParams localToggleLikeParams = (ToggleLikeParams)paramOperationParams.b().getParcelable("toggleLikeParams");
    return OperationResult.a(Boolean.toString(((Boolean)((SingleMethodRunner)this.a.b()).a(this.g, localToggleLikeParams)).booleanValue()));
  }

  private OperationResult h(OperationParams paramOperationParams)
  {
    DeleteCommentParams localDeleteCommentParams = (DeleteCommentParams)paramOperationParams.b().getParcelable("deleteCommentParams");
    ((SingleMethodRunner)this.a.b()).a(this.f, localDeleteCommentParams);
    return OperationResult.b();
  }

  private OperationResult i(OperationParams paramOperationParams)
  {
    AddCommentParams localAddCommentParams = (AddCommentParams)paramOperationParams.b().getParcelable("addCommentParams");
    return OperationResult.a((String)((SingleMethodRunner)this.a.b()).a(this.e, localAddCommentParams));
  }

  private OperationResult j(OperationParams paramOperationParams)
  {
    FetchNewsFeedParams localFetchNewsFeedParams = (FetchNewsFeedParams)paramOperationParams.b().getParcelable("fetchNewsFeedParams");
    return OperationResult.a((FetchNewsFeedResult)((SingleMethodRunner)this.a.b()).a(this.b, localFetchNewsFeedParams));
  }

  private OperationResult k(OperationParams paramOperationParams)
  {
    FetchNewsFeedParams localFetchNewsFeedParams = (FetchNewsFeedParams)paramOperationParams.b().getParcelable("fetchNewsFeedParams");
    return OperationResult.a((FetchNewsFeedResult)((SingleMethodRunner)this.a.b()).a(this.c, localFetchNewsFeedParams));
  }

  private OperationResult l(OperationParams paramOperationParams)
  {
    FetchFriendListFeedParams localFetchFriendListFeedParams = (FetchFriendListFeedParams)paramOperationParams.b().getParcelable("fetchFriendListFeedParams");
    return OperationResult.a((FetchNewsFeedResult)((SingleMethodRunner)this.a.b()).a(this.d, localFetchFriendListFeedParams));
  }

  private OperationResult m(OperationParams paramOperationParams)
  {
    FetchNodeListParams localFetchNodeListParams = (FetchNodeListParams)paramOperationParams.b().getParcelable("fetchLikersFeedParams");
    return OperationResult.a((FetchFeedbackResult)((SingleMethodRunner)this.a.b()).a(this.k, localFetchNodeListParams));
  }

  private OperationResult n(OperationParams paramOperationParams)
  {
    FetchFeedbackParams localFetchFeedbackParams = (FetchFeedbackParams)paramOperationParams.b().getParcelable("fetchFeedbackParams");
    return OperationResult.a((FetchFeedbackResult)((SingleMethodRunner)this.a.b()).a(this.l, localFetchFeedbackParams));
  }

  private OperationResult o(OperationParams paramOperationParams)
  {
    ClaimCouponParams localClaimCouponParams = (ClaimCouponParams)paramOperationParams.b().getParcelable("claimCouponParams");
    return OperationResult.a(Boolean.toString(((Boolean)((SingleMethodRunner)this.a.b()).a(this.n, localClaimCouponParams)).booleanValue()));
  }

  private OperationResult p(OperationParams paramOperationParams)
  {
    FetchSingleMediaParams localFetchSingleMediaParams = (FetchSingleMediaParams)paramOperationParams.b().getParcelable("fetchMediaParams");
    return OperationResult.a((FetchSingleMediaResult)((SingleMethodRunner)this.a.b()).a(this.o, localFetchSingleMediaParams));
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult;
    if (FeedUtils.a(str))
      localOperationResult = j(paramOperationParams);
    while (true)
    {
      return localOperationResult;
      if ("prefetch_news_feed".equals(str))
      {
        localOperationResult = k(paramOperationParams);
        continue;
      }
      if (FeedUtils.b(str))
      {
        localOperationResult = l(paramOperationParams);
        continue;
      }
      if ("add_comment".equals(str))
      {
        localOperationResult = i(paramOperationParams);
        continue;
      }
      if ("delete_comment".equals(str))
      {
        localOperationResult = h(paramOperationParams);
        continue;
      }
      if ("toggle_like".equals(str))
      {
        localOperationResult = g(paramOperationParams);
        continue;
      }
      if ("toggle_page_like".equals(str))
      {
        localOperationResult = g(paramOperationParams);
        continue;
      }
      if ("fetch_platform_story".equals(str))
      {
        localOperationResult = e(paramOperationParams);
        continue;
      }
      if ("fetch_graphql_story".equals(str))
      {
        localOperationResult = f(paramOperationParams);
        continue;
      }
      if ("fetch_comments".equals(str))
      {
        localOperationResult = d(paramOperationParams);
        continue;
      }
      if ("fetch_likers".equals(str))
      {
        localOperationResult = m(paramOperationParams);
        continue;
      }
      if ("publish_checkin".equals(str))
      {
        localOperationResult = this.m.c(paramOperationParams);
        continue;
      }
      if ("publish_post".equals(str))
      {
        localOperationResult = this.m.b(paramOperationParams);
        continue;
      }
      if ("publish_share".equals(str))
      {
        localOperationResult = this.m.a(paramOperationParams);
        continue;
      }
      if ("fetch_feedback".equals(str))
      {
        localOperationResult = n(paramOperationParams);
        continue;
      }
      if ("claim_coupon".equals(str))
      {
        localOperationResult = o(paramOperationParams);
        continue;
      }
      if ("fetch_news_feed_updates".equals(str))
      {
        localOperationResult = OperationResult.a(StoryUpdate.a);
        continue;
      }
      if ("clear_newsfeed_cache".equals(str))
      {
        localOperationResult = c(paramOperationParams);
        continue;
      }
      if ("fetch_media".equals(str))
      {
        localOperationResult = p(paramOperationParams);
        continue;
      }
      if (!"clear_cache_after_cursor".equals(str))
        break;
      localOperationResult = b(paramOperationParams);
    }
    throw new ApiMethodNotFoundException(str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.server.NewsFeedServiceHandler
 * JD-Core Version:    0.6.0
 */