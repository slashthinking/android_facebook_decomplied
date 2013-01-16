package com.facebook.feed.flyout;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FeedFlyoutFragment$13
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!FeedFlyoutFragment.y(this.a))
    {
      FeedFlyoutFragment.z(this.a).bringToFront();
      FeedFlyoutFragment.z(this.a).setVisibility(0);
      FeedFlyoutFragment.A(this.a).setVisibility(8);
      FeedFlyoutFragment.A(this.a).clearAnimation();
    }
    while (true)
    {
      FeedFlyoutFragment.e(this.a, FeedFlyoutFragment.i(this.a));
      return;
      FeedFlyoutFragment.A(this.a).bringToFront();
      FeedFlyoutFragment.z(this.a).setVisibility(8);
      FeedFlyoutFragment.A(this.a).setVisibility(0);
      FeedFlyoutFragment.z(this.a).clearAnimation();
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.13
 * JD-Core Version:    0.6.0
 */