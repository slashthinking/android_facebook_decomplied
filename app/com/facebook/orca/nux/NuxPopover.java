package com.facebook.orca.nux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import com.facebook.widget.CustomViewGroup;

public abstract class NuxPopover extends CustomViewGroup
{
  boolean a;
  boolean b;
  final int c = 250;

  public NuxPopover(Context paramContext)
  {
    super(paramContext);
    c();
  }

  public NuxPopover(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }

  public NuxPopover(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }

  private void b()
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(250L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    startAnimation(localAlphaAnimation);
  }

  private void j()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(250L);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setAnimationListener(new NuxPopover.1(this));
    startAnimation(localAlphaAnimation);
  }

  protected abstract void a();

  protected void c()
  {
    this.a = false;
    setVisibility(8);
    setClickable(true);
  }

  protected void d()
  {
    if (this.b);
    while (true)
    {
      return;
      a();
      this.b = true;
    }
  }

  protected boolean e()
  {
    return this.b;
  }

  void f()
  {
    d();
    if (!this.a)
    {
      clearAnimation();
      this.a = true;
      setVisibility(0);
    }
  }

  void g()
  {
    if (this.a)
    {
      clearAnimation();
      this.a = false;
      setVisibility(8);
    }
  }

  void h()
  {
    d();
    if (!this.a)
    {
      this.a = true;
      b();
    }
  }

  void i()
  {
    if (this.a)
    {
      this.a = false;
      j();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.NuxPopover
 * JD-Core Version:    0.6.0
 */