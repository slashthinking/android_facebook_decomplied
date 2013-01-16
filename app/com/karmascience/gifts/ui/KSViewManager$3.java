package com.karmascience.gifts.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.views.ViewController;

class KSViewManager$3
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
    this.b.a(true);
    this.b.j();
    KSViewManager.a(this.e).a(new KSViewManager.3.1(this));
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.ui.KSViewManager.3
 * JD-Core Version:    0.6.0
 */