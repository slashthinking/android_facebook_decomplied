package com.facebook.camera.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CameraActivity$IconMover
  implements Animation.AnimationListener
{
  private View b;
  private CameraActivity.Corner c;
  private Boolean d;

  CameraActivity$IconMover(CameraActivity paramCameraActivity, View paramView, CameraActivity.Corner paramCorner, boolean paramBoolean)
  {
    this.b = paramView;
    this.c = paramCorner;
    this.d = Boolean.valueOf(paramBoolean);
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    CameraActivity.a(this.a, this.b, this.c);
    View localView = this.b;
    if (this.d.booleanValue());
    for (int i = 0; ; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraActivity.IconMover
 * JD-Core Version:    0.6.0
 */