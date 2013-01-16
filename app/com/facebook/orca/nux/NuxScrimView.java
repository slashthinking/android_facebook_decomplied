package com.facebook.orca.nux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;

public class NuxScrimView extends NuxPopover
{
  private View d;
  private View e;

  public NuxScrimView(Context paramContext)
  {
    super(paramContext);
  }

  public NuxScrimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NuxScrimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.e != null)
      this.e.dispatchTouchEvent(paramMotionEvent);
    for (int i = 0; ; i = 1)
      return i;
  }

  protected void a()
  {
    setContentView(2130903384);
    this.d = getView(2131297377);
    this.d.setOnTouchListener(new NuxScrimView.1(this));
  }

  public void b()
  {
    if (this.e != null)
    {
      this.e = null;
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setInterpolator(new LinearInterpolator());
      this.d.startAnimation(localAlphaAnimation);
    }
  }

  public void setOnTitleBarButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.NuxScrimView
 * JD-Core Version:    0.6.0
 */