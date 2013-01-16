package com.facebook.feed.flyout;

import com.facebook.feed.util.event.FlyoutEvents.FetchPreviousCommentsResultEvent;
import com.facebook.feed.util.event.FlyoutEvents.FetchPreviousCommentsResultSubscriber;

class FeedFlyoutCommentsAdapter$FetchPreviousCommentsResultSubscriber extends FlyoutEvents.FetchPreviousCommentsResultSubscriber
{
  private FeedFlyoutCommentsAdapter$FetchPreviousCommentsResultSubscriber(FeedFlyoutCommentsAdapter paramFeedFlyoutCommentsAdapter)
  {
  }

  public void a(FlyoutEvents.FetchPreviousCommentsResultEvent paramFetchPreviousCommentsResultEvent)
  {
    FeedFlyoutCommentsAdapter.c(this.a).b();
    FeedFlyoutCommentsAdapter.a(this.a, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutCommentsAdapter.FetchPreviousCommentsResultSubscriber
 * JD-Core Version:    0.6.0
 */