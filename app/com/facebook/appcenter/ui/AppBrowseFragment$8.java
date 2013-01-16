package com.facebook.appcenter.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

class AppBrowseFragment$8
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AppBrowseFragment.k(this.a).getLayoutParams());
    localLayoutParams.setMargins(0, 0, 0, 0);
    AppBrowseFragment.k(this.a).setLayoutParams(localLayoutParams);
    AppBrowseFragment.k(this.a).requestLayout();
    AppBrowseFragment.a(this.a, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseFragment.8
 * JD-Core Version:    0.6.0
 */