package com.nineoldandroids.animation;

import java.util.ArrayList;

class AnimatorSet$DependencyListener
  implements Animator.AnimatorListener
{
  private AnimatorSet a;
  private AnimatorSet.Node b;
  private int c;

  public AnimatorSet$DependencyListener(AnimatorSet paramAnimatorSet, AnimatorSet.Node paramNode, int paramInt)
  {
    this.a = paramAnimatorSet;
    this.b = paramNode;
    this.c = paramInt;
  }

  private void e(Animator paramAnimator)
  {
    if (this.a.b)
      return;
    int i = this.b.c.size();
    int j = 0;
    label24: AnimatorSet.Dependency localDependency;
    if (j < i)
    {
      localDependency = (AnimatorSet.Dependency)this.b.c.get(j);
      if ((localDependency.b == this.c) && (localDependency.a.a == paramAnimator))
        paramAnimator.b(this);
    }
    while (true)
    {
      this.b.c.remove(localDependency);
      if (this.b.c.size() != 0)
        break;
      this.b.a.c();
      AnimatorSet.a(this.a).add(this.b.a);
      break;
      j++;
      break label24;
      localDependency = null;
    }
  }

  public void a(Animator paramAnimator)
  {
    if (this.c == 1)
      e(paramAnimator);
  }

  public void b(Animator paramAnimator)
  {
    if (this.c == 0)
      e(paramAnimator);
  }

  public void c(Animator paramAnimator)
  {
  }

  public void d(Animator paramAnimator)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.DependencyListener
 * JD-Core Version:    0.6.2
 */