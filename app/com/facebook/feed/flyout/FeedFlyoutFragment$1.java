package com.facebook.feed.flyout;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.common.util.TriState;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FlyoutEvents.CommentLikeActionResultEvent;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

class FeedFlyoutFragment$1
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FeedFlyoutFragment.c(this.e).b(this.b);
    FeedFlyoutFragment.d(this.e).a(new FlyoutEvents.CommentLikeActionResultEvent(this.a, TriState.YES));
  }

  public void a(Throwable paramThrowable)
  {
    FeedFlyoutFragment.b(this.e).a(FeedFlyoutFragment.a(this.e).a("feed_flyout_comment_like_failed", this.a.S().legacyApiPostId, String.valueOf(this.a.S().doesViewerLike)));
    FeedFlyoutFragment.c(this.e).b(this.b);
    FeedFlyoutFragment.a(this.e, "FeedFlyoutTogglecommentLikeFailed", paramThrowable);
    FeedFlyoutFragment.d(this.e).a(new FlyoutEvents.CommentLikeActionResultEvent(this.c, TriState.NO));
    FeedFlyoutFragment.a(this.e, this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.1
 * JD-Core Version:    0.6.0
 */