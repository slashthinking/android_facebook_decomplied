package com.facebook.feed.flyout;

import android.widget.ImageButton;
import com.facebook.feed.util.event.FlyoutEvents.SetUpHeaderViewEventSubscriber;
import com.facebook.feed.util.event.FlyoutEvents.SetupHeaderViewEvent;
import com.facebook.graphql.model.Feedback;

class FeedFlyoutHeaderView$SetUpHeaderViewEventSubscriber extends FlyoutEvents.SetUpHeaderViewEventSubscriber
{
  private FeedFlyoutHeaderView$SetUpHeaderViewEventSubscriber(FeedFlyoutHeaderView paramFeedFlyoutHeaderView)
  {
  }

  public void a(FlyoutEvents.SetupHeaderViewEvent paramSetupHeaderViewEvent)
  {
    if ((paramSetupHeaderViewEvent == null) || (paramSetupHeaderViewEvent.a == null));
    while (true)
    {
      return;
      FeedFlyoutHeaderView.a(this.a, paramSetupHeaderViewEvent.a);
      FeedFlyoutHeaderView.f(this.a).setEnabled(FeedFlyoutHeaderView.b(this.a).canViewerLike);
      FeedFlyoutHeaderView.a(this.a, FeedFlyoutHeaderView.b(this.a).doesViewerLike);
      FeedFlyoutHeaderView.d(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutHeaderView.SetUpHeaderViewEventSubscriber
 * JD-Core Version:    0.6.0
 */