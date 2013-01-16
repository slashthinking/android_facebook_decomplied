package com.facebook.camera.device;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;

public class FocusIndicatorView extends View
  implements FocusIndicator
{
  Context a;

  public FocusIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }

  private void a(View paramView, int paramInt)
  {
    paramView.startAnimation(AnimationUtils.loadAnimation(this.a, paramInt));
  }

  private void setDrawable(int paramInt)
  {
    setBackgroundDrawable(getResources().getDrawable(paramInt));
  }

  public void a()
  {
    setDrawable(2130837654);
    setVisibility(0);
  }

  public void b()
  {
    a(this, 2130968578);
    setVisibility(4);
  }

  public void c()
  {
    setVisibility(4);
  }

  public void d()
  {
    setBackgroundDrawable(null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.FocusIndicatorView
 * JD-Core Version:    0.6.0
 */