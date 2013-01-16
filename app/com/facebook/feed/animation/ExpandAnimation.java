package com.facebook.feed.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ExpandAnimation extends Animation
{
  private final View a;
  private final int b;

  public ExpandAnimation(View paramView, int paramInt)
  {
    this.a = paramView;
    this.b = paramInt;
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.a.getLayoutParams().height = (int)(paramFloat * this.b);
    this.a.requestLayout();
  }

  public boolean willChangeBounds()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.animation.ExpandAnimation
 * JD-Core Version:    0.6.0
 */