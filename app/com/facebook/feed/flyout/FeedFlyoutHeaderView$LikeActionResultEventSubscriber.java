package com.facebook.feed.flyout;

import android.widget.ImageButton;
import com.facebook.feed.util.event.FlyoutEvents.LikeActionResultEvent;
import com.facebook.feed.util.event.FlyoutEvents.LikeActionResultEventSubscriber;
import com.facebook.graphql.model.Feedback;

class FeedFlyoutHeaderView$LikeActionResultEventSubscriber extends FlyoutEvents.LikeActionResultEventSubscriber
{
  private FeedFlyoutHeaderView$LikeActionResultEventSubscriber(FeedFlyoutHeaderView paramFeedFlyoutHeaderView)
  {
  }

  public void a(FlyoutEvents.LikeActionResultEvent paramLikeActionResultEvent)
  {
    if ((paramLikeActionResultEvent == null) || (paramLikeActionResultEvent.a == null) || (FeedFlyoutHeaderView.b(this.a).d() == null) || (!FeedFlyoutHeaderView.b(this.a).d().equals(paramLikeActionResultEvent.a.d())));
    while (true)
    {
      return;
      FeedFlyoutHeaderView.f(this.a).setClickable(true);
      FeedFlyoutHeaderView.a(this.a, paramLikeActionResultEvent.a);
      FeedFlyoutHeaderView.a(this.a, FeedFlyoutHeaderView.b(this.a).doesViewerLike);
      FeedFlyoutHeaderView.d(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutHeaderView.LikeActionResultEventSubscriber
 * JD-Core Version:    0.6.0
 */