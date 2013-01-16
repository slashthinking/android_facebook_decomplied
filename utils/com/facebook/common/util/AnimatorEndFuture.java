package com.facebook.common.util;

import com.google.common.util.concurrent.AbstractFuture;
import com.nineoldandroids.animation.Animator;

public class AnimatorEndFuture extends AbstractFuture<Void>
{
  public AnimatorEndFuture(Animator paramAnimator)
  {
    paramAnimator.a(new AnimatorEndFuture.1(this));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.AnimatorEndFuture
 * JD-Core Version:    0.6.2
 */