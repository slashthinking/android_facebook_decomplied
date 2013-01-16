package com.facebook.feed.module;

import com.facebook.composer.server.ComposerPublishServiceHandler;
import com.facebook.feed.protocol.AddCommentMethod;
import com.facebook.feed.protocol.DeleteCommentMethod;
import com.facebook.feed.protocol.FetchCommentsMethod;
import com.facebook.feed.protocol.FetchFeedbackMethod;
import com.facebook.feed.protocol.FetchFriendListFeedMethod;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.feed.protocol.FetchLikersMethod;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.feed.protocol.FetchPlatformStoryMethod;
import com.facebook.feed.protocol.FetchSingleMediaMethod;
import com.facebook.feed.protocol.PrefetchNewsFeedMethod;
import com.facebook.feed.protocol.ToggleLikeMethod;
import com.facebook.feed.protocol.coupons.ClaimCouponMethod;
import com.facebook.feed.server.NewsFeedServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class NewsFeedModule$NewsFeedServiceHandlerProvider extends AbstractProvider<NewsFeedServiceHandler>
{
  private NewsFeedModule$NewsFeedServiceHandlerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedServiceHandler a()
  {
    return new NewsFeedServiceHandler(a(SingleMethodRunner.class), (ComposerPublishServiceHandler)b(ComposerPublishServiceHandler.class), (FetchNewsFeedMethod)b(FetchNewsFeedMethod.class), (PrefetchNewsFeedMethod)b(PrefetchNewsFeedMethod.class), (FetchFriendListFeedMethod)b(FetchFriendListFeedMethod.class), (AddCommentMethod)b(AddCommentMethod.class), (DeleteCommentMethod)b(DeleteCommentMethod.class), (ToggleLikeMethod)b(ToggleLikeMethod.class), (FetchPlatformStoryMethod)b(FetchPlatformStoryMethod.class), (FetchGraphQLStoryMethod)b(FetchGraphQLStoryMethod.class), (FetchCommentsMethod)b(FetchCommentsMethod.class), (FetchLikersMethod)b(FetchLikersMethod.class), (FetchFeedbackMethod)b(FetchFeedbackMethod.class), (ClaimCouponMethod)b(ClaimCouponMethod.class), (FetchSingleMediaMethod)b(FetchSingleMediaMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */