package com.facebook.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.orca.common.util.AndroidThreadUtil;

class ScreenSlider$9
  implements Animation.AnimationListener
{
  ScreenSlider$9(ScreenSlider paramScreenSlider, ScreenSlider.ScreenSliderState paramScreenSliderState, Runnable paramRunnable)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    ScreenSlider.a(this.c, null);
    this.c.a(this.a);
    ScreenSlider.j(this.c).d(this.b);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ScreenSlider.9
 * JD-Core Version:    0.6.2
 */