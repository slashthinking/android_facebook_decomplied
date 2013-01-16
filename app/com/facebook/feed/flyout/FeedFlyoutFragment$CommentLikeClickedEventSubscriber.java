package com.facebook.feed.flyout;

import com.facebook.feed.util.event.FlyoutEvents.CommentLikeClickedEvent;
import com.facebook.feed.util.event.FlyoutEvents.CommentLikeClickedEventSubscriber;

class FeedFlyoutFragment$CommentLikeClickedEventSubscriber extends FlyoutEvents.CommentLikeClickedEventSubscriber
{
  private FeedFlyoutFragment$CommentLikeClickedEventSubscriber(FeedFlyoutFragment paramFeedFlyoutFragment)
  {
  }

  public void a(FlyoutEvents.CommentLikeClickedEvent paramCommentLikeClickedEvent)
  {
    FeedFlyoutFragment.a(this.a, paramCommentLikeClickedEvent.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.CommentLikeClickedEventSubscriber
 * JD-Core Version:    0.6.0
 */