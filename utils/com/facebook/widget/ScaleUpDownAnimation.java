package com.facebook.widget;

import android.view.View;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.AnimatorSet.Builder;
import com.nineoldandroids.animation.ObjectAnimator;

public class ScaleUpDownAnimation
{
  public static void a(View paramView, float paramFloat, long paramLong, boolean paramBoolean)
  {
    a(paramView, paramFloat, paramLong, paramBoolean, null);
  }

  public static void a(View paramView, float paramFloat, long paramLong, boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.a(paramView, "scaleX", new float[] { paramFloat });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.a(paramView, "scaleY", new float[] { paramFloat });
    localObjectAnimator1.d(paramLong);
    localObjectAnimator2.d(paramLong);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.a(paramView, "scaleX", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.a(paramView, "scaleY", new float[] { 1.0F });
    localObjectAnimator3.d(paramLong);
    localObjectAnimator4.d(paramLong);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.a(localObjectAnimator1).a(localObjectAnimator2);
    localAnimatorSet.a(localObjectAnimator1).b(localObjectAnimator3);
    localAnimatorSet.a(localObjectAnimator3).a(localObjectAnimator4);
    if (paramAnimatorListener != null)
      localAnimatorSet.a(paramAnimatorListener);
    if (paramBoolean)
    {
      ObjectAnimator localObjectAnimator5 = BounceAnimationCreator.b(paramView);
      localAnimatorSet.a(localObjectAnimator3).b(localObjectAnimator5);
    }
    localAnimatorSet.c();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ScaleUpDownAnimation
 * JD-Core Version:    0.6.2
 */