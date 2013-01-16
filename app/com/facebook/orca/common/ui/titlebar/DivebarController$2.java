package com.facebook.orca.common.ui.titlebar;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.orca.ui.touch.SwipableLinearLayout;

class DivebarController$2
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    DivebarController.a(this.c, null);
    DivebarController.a(this.c, this.a);
    if (DivebarController.a(this.c) != null)
      DivebarController.a(this.c).post(new DivebarController.2.1(this));
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.DivebarController.2
 * JD-Core Version:    0.6.0
 */