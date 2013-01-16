package com.facebook.feed.flyout;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.feed.util.event.FlyoutEvents.LikeClickedEvent;
import com.facebook.feed.util.event.FlyoutEvents.LikeClickedEventSubscriber;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.base.Objects;
import com.google.common.util.concurrent.ListenableFuture;

class FeedFlyoutFragment$LikeClickedEventSubscriber extends FlyoutEvents.LikeClickedEventSubscriber
{
  private FeedFlyoutFragment$LikeClickedEventSubscriber(FeedFlyoutFragment paramFeedFlyoutFragment)
  {
  }

  public void a(FlyoutEvents.LikeClickedEvent paramLikeClickedEvent)
  {
    if ((paramLikeClickedEvent == null) || (paramLikeClickedEvent.a == null) || (FeedFlyoutFragment.i(this.a) == null) || (!Objects.equal(FeedFlyoutFragment.i(this.a).legacyApiPostId, paramLikeClickedEvent.a.legacyApiPostId)));
    while (true)
    {
      return;
      Feedback localFeedback = FeedFlyoutFragment.i(this.a);
      FeedFlyoutFragment.a(this.a, paramLikeClickedEvent.a);
      ListenableFuture localListenableFuture = FeedFlyoutFragment.a(this.a, FeedFlyoutFragment.f(this.a).d, FeedFlyoutFragment.i(this.a), FeedFlyoutFragment.i(this.a).doesViewerLike, null);
      FeedFlyoutFragment.b(this.a).a(FeedFlyoutFragment.a(this.a).a("feed_flyout_story_like", FeedFlyoutFragment.i(this.a).legacyApiPostId, String.valueOf(FeedFlyoutFragment.i(this.a).doesViewerLike)));
      FeedFlyoutFragment.c(this.a).a(localListenableFuture);
      FeedFlyoutFragment.LikeClickedEventSubscriber.1 local1 = new FeedFlyoutFragment.LikeClickedEventSubscriber.1(this, localListenableFuture, localFeedback);
      FeedFlyoutFragment.D(this.a).a(localListenableFuture, local1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.LikeClickedEventSubscriber
 * JD-Core Version:    0.6.0
 */