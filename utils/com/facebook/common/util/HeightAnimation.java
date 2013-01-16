package com.facebook.common.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class HeightAnimation extends Animation
{
  private int a;
  private View b;
  private int c;

  public HeightAnimation(View paramView, int paramInt)
  {
    this.b = paramView;
    this.a = paramInt;
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = (int)(this.c + paramFloat * (this.a - this.c));
    this.b.getLayoutParams().height = i;
    this.b.requestLayout();
  }

  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = paramInt2;
  }

  public boolean willChangeBounds()
  {
    return true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.HeightAnimation
 * JD-Core Version:    0.6.2
 */