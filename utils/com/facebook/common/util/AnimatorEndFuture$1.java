package com.facebook.common.util;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class AnimatorEndFuture$1 extends AnimatorListenerAdapter
{
  AnimatorEndFuture$1(AnimatorEndFuture paramAnimatorEndFuture)
  {
  }

  public void a(Animator paramAnimator)
  {
    paramAnimator.b(this);
    AnimatorEndFuture.a(this.a, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.AnimatorEndFuture.1
 * JD-Core Version:    0.6.2
 */