package com.facebook.feed.ui;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;

class NewsFeedFragment$3 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    NewsFeedFragment.a(this.e).b(this.a);
    if (this.b == null);
    for (FeedStory localFeedStory = this.c; ; localFeedStory = this.b)
    {
      this.e.ad.a(localFeedStory);
      this.e.d.notifyDataSetChanged();
      if (localFeedStory.S() != null)
        NewsFeedFragment.b(this.e).a(new UfiEvents.LikeUpdatedUIEvent(localFeedStory.S().legacyApiPostId, localFeedStory.D()));
      this.e.i.a(this.e.h.a("newsfeed_story_like_fail", this.d.legacyApiPostId, String.valueOf(this.d.doesViewerLike)));
      return;
    }
  }

  public void a(OperationResult paramOperationResult)
  {
    NewsFeedFragment.a(this.e).b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.3
 * JD-Core Version:    0.6.0
 */