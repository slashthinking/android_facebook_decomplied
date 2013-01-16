package com.facebook.feed.flyout;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FlyoutEvents.LikeActionResultEvent;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

class FeedFlyoutFragment$LikeClickedEventSubscriber$1
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FeedFlyoutFragment.c(this.c.a).b(this.a);
    FeedFlyoutFragment.d(this.c.a).a(new FlyoutEvents.LikeActionResultEvent(FeedFlyoutFragment.i(this.c.a), true));
  }

  public void a(Throwable paramThrowable)
  {
    FeedFlyoutFragment.b(this.c.a).a(FeedFlyoutFragment.a(this.c.a).a("feed_flyout_story_like_failed", FeedFlyoutFragment.i(this.c.a).legacyApiPostId, String.valueOf(FeedFlyoutFragment.i(this.c.a).doesViewerLike)));
    FeedFlyoutFragment.c(this.c.a).b(this.a);
    FeedFlyoutFragment.a(this.c.a, "FeedFlyoutLikeClickedFailed", paramThrowable);
    FeedFlyoutFragment.a(this.c.a, this.b);
    FeedFlyoutFragment.d(this.c.a).a(new FlyoutEvents.LikeActionResultEvent(FeedFlyoutFragment.i(this.c.a), false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.LikeClickedEventSubscriber.1
 * JD-Core Version:    0.6.0
 */