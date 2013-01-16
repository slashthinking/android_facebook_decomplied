package com.facebook.feed.flyout;

import android.widget.ImageButton;
import com.facebook.feed.util.event.FlyoutEvents.LikeClickedEvent;
import com.facebook.feed.util.event.FlyoutEvents.LikeClickedEventSubscriber;
import com.facebook.graphql.model.Feedback;
import com.facebook.widget.ScaleUpDownAnimation;

class FeedFlyoutHeaderView$LikeClickedEventSubscriber extends FlyoutEvents.LikeClickedEventSubscriber
{
  private FeedFlyoutHeaderView$LikeClickedEventSubscriber(FeedFlyoutHeaderView paramFeedFlyoutHeaderView)
  {
  }

  public void a(FlyoutEvents.LikeClickedEvent paramLikeClickedEvent)
  {
    if ((paramLikeClickedEvent == null) || (paramLikeClickedEvent.a == null) || (FeedFlyoutHeaderView.b(this.a).d() == null) || (!FeedFlyoutHeaderView.b(this.a).d().equals(paramLikeClickedEvent.a.d())));
    while (true)
    {
      return;
      FeedFlyoutHeaderView.a(this.a, paramLikeClickedEvent.a);
      FeedFlyoutHeaderView.f(this.a).setClickable(false);
      FeedFlyoutHeaderView.a(this.a, FeedFlyoutHeaderView.b(this.a).doesViewerLike);
      if (FeedFlyoutHeaderView.b(this.a).doesViewerLike)
        ScaleUpDownAnimation.a(FeedFlyoutHeaderView.f(this.a), FeedFlyoutHeaderView.a(), FeedFlyoutHeaderView.b(), true);
      FeedFlyoutHeaderView.d(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutHeaderView.LikeClickedEventSubscriber
 * JD-Core Version:    0.6.0
 */