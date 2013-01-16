package com.facebook.widget.flyout;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class FlyoutAnimation
{
  public static AnimatorSet a(FlyoutAnimationBuilder paramFlyoutAnimationBuilder)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    View localView = paramFlyoutAnimationBuilder.h();
    Animator[] arrayOfAnimator = new Animator[4];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = paramFlyoutAnimationBuilder.e();
    arrayOfFloat1[1] = paramFlyoutAnimationBuilder.e();
    arrayOfAnimator[0] = ObjectAnimator.a(localView, "pivotX", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = paramFlyoutAnimationBuilder.f();
    arrayOfFloat2[1] = paramFlyoutAnimationBuilder.f();
    arrayOfAnimator[1] = ObjectAnimator.a(localView, "pivotY", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = paramFlyoutAnimationBuilder.a();
    arrayOfFloat3[1] = paramFlyoutAnimationBuilder.b();
    arrayOfAnimator[2] = ObjectAnimator.a(localView, "scaleX", arrayOfFloat3);
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = paramFlyoutAnimationBuilder.c();
    arrayOfFloat4[1] = paramFlyoutAnimationBuilder.d();
    arrayOfAnimator[3] = ObjectAnimator.a(localView, "scaleY", arrayOfFloat4);
    localAnimatorSet.a(arrayOfAnimator);
    localAnimatorSet.a(new DecelerateInterpolator());
    localAnimatorSet.a(paramFlyoutAnimationBuilder.g());
    return localAnimatorSet;
  }

  public static AnimatorSet b(FlyoutAnimationBuilder paramFlyoutAnimationBuilder)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    View localView = paramFlyoutAnimationBuilder.h();
    Animator[] arrayOfAnimator = new Animator[4];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = paramFlyoutAnimationBuilder.e();
    arrayOfFloat1[1] = paramFlyoutAnimationBuilder.e();
    arrayOfAnimator[0] = ObjectAnimator.a(localView, "pivotX", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = paramFlyoutAnimationBuilder.f();
    arrayOfFloat2[1] = paramFlyoutAnimationBuilder.f();
    arrayOfAnimator[1] = ObjectAnimator.a(localView, "pivotY", arrayOfFloat2);
    float[] arrayOfFloat3 = new float[2];
    arrayOfFloat3[0] = paramFlyoutAnimationBuilder.a();
    arrayOfFloat3[1] = paramFlyoutAnimationBuilder.b();
    arrayOfAnimator[2] = ObjectAnimator.a(localView, "scaleX", arrayOfFloat3);
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat4[0] = paramFlyoutAnimationBuilder.c();
    arrayOfFloat4[1] = paramFlyoutAnimationBuilder.d();
    arrayOfAnimator[3] = ObjectAnimator.a(localView, "scaleY", arrayOfFloat4);
    localAnimatorSet.a(arrayOfAnimator);
    localAnimatorSet.a(new AccelerateInterpolator());
    localAnimatorSet.a(paramFlyoutAnimationBuilder.g());
    return localAnimatorSet;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.flyout.FlyoutAnimation
 * JD-Core Version:    0.6.2
 */