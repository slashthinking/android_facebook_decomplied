package com.facebook.nearby.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SplitHideableListView$4
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (SplitHideableListView.c(this.a) != null)
      SplitHideableListView.c(this.a).a();
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.setEnabled(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.ui.SplitHideableListView.4
 * JD-Core Version:    0.6.0
 */