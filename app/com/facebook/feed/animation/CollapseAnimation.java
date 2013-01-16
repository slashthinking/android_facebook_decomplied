package com.facebook.feed.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class CollapseAnimation extends Animation
{
  private final View a;
  private final int b;

  public CollapseAnimation(View paramView, int paramInt)
  {
    this.a = paramView;
    this.b = paramInt;
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.a.getLayoutParams().height = (int)(this.b * (1.0F - paramFloat));
    this.a.requestLayout();
  }

  public boolean willChangeBounds()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.animation.CollapseAnimation
 * JD-Core Version:    0.6.0
 */