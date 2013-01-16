package com.nineoldandroids.view;

import android.animation.Animator;

class ViewPropertyAnimatorICS$1
  implements android.animation.Animator.AnimatorListener
{
  ViewPropertyAnimatorICS$1(ViewPropertyAnimatorICS paramViewPropertyAnimatorICS, com.nineoldandroids.animation.Animator.AnimatorListener paramAnimatorListener)
  {
  }

  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c(null);
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a(null);
  }

  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.a.d(null);
  }

  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b(null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorICS.1
 * JD-Core Version:    0.6.2
 */