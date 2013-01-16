package com.facebook.feed.flyout;

import android.widget.ListView;
import com.facebook.feed.util.event.FlyoutEvents.SwitchViewEvent;
import com.facebook.feed.util.event.FlyoutEvents.SwitchViewEventSubscriber;

class FeedFlyoutFragment$SwitchViewEventSubscriber extends FlyoutEvents.SwitchViewEventSubscriber
{
  private FeedFlyoutFragment$SwitchViewEventSubscriber(FeedFlyoutFragment paramFeedFlyoutFragment)
  {
  }

  public void a(FlyoutEvents.SwitchViewEvent paramSwitchViewEvent)
  {
    if ((paramSwitchViewEvent == null) || (FeedFlyoutFragment.i(this.a) == null));
    while (true)
    {
      return;
      if ((FeedFlyoutFragment.y(this.a)) && (!(FeedFlyoutFragment.v(this.a).getAdapter() instanceof FeedFlyoutLikesAdapter)))
        FeedFlyoutFragment.v(this.a).setAdapter(FeedFlyoutFragment.B(this.a));
      FeedFlyoutFragment.x(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.SwitchViewEventSubscriber
 * JD-Core Version:    0.6.0
 */