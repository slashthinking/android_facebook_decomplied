package com.nineoldandroids.animation;

import java.util.ArrayList;

class AnimatorSet$1 extends AnimatorListenerAdapter
{
  boolean a = false;

  AnimatorSet$1(AnimatorSet paramAnimatorSet, ArrayList paramArrayList)
  {
  }

  public void a(Animator paramAnimator)
  {
    if (!this.a)
    {
      int i = this.b.size();
      for (int j = 0; j < i; j++)
      {
        AnimatorSet.Node localNode = (AnimatorSet.Node)this.b.get(j);
        localNode.a.c();
        AnimatorSet.a(this.c).add(localNode.a);
      }
    }
  }

  public void c(Animator paramAnimator)
  {
    this.a = true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.1
 * JD-Core Version:    0.6.2
 */