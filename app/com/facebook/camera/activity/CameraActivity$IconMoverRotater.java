package com.facebook.camera.activity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class CameraActivity$IconMoverRotater
  implements Animator.AnimatorListener
{
  private View b;
  private int c;
  private CameraActivity.Corner d;
  private boolean e;
  private boolean f;

  CameraActivity$IconMoverRotater(CameraActivity paramCameraActivity, View paramView, int paramInt, CameraActivity.Corner paramCorner, boolean paramBoolean)
  {
    this.b = paramView;
    this.c = paramInt;
    this.d = paramCorner;
    this.e = paramBoolean;
    this.f = false;
  }

  private void a()
  {
    if (!this.f)
    {
      this.b.setRotation(this.c);
      CameraActivity.a(this.a, this.b, this.d);
      if (this.e)
        this.b.setVisibility(4);
      this.f = true;
    }
  }

  public void onAnimationCancel(Animator paramAnimator)
  {
    this.f = true;
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
    a();
    this.b.setTag(null);
  }

  public void onAnimationRepeat(Animator paramAnimator)
  {
    a();
  }

  public void onAnimationStart(Animator paramAnimator)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraActivity.IconMoverRotater
 * JD-Core Version:    0.6.0
 */