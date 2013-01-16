package com.facebook.katana.ui;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class AbstractPopupViewDelegate$5 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    this.b.c();
  }

  public void b(Animator paramAnimator)
  {
    AbstractPopupViewDelegate.b(this.b, 0);
    this.b.a.bringToFront();
    AbstractPopupViewDelegate.c(this.b, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.AbstractPopupViewDelegate.5
 * JD-Core Version:    0.6.0
 */