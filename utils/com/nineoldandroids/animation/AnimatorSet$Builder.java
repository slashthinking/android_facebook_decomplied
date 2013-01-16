package com.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimatorSet$Builder
{
  private AnimatorSet.Node b;

  AnimatorSet$Builder(AnimatorSet paramAnimatorSet, Animator paramAnimator)
  {
    this.b = ((AnimatorSet.Node)AnimatorSet.b(paramAnimatorSet).get(paramAnimator));
    if (this.b == null)
    {
      this.b = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.b(paramAnimatorSet).put(paramAnimator, this.b);
      AnimatorSet.d(paramAnimatorSet).add(this.b);
    }
  }

  public Builder a(Animator paramAnimator)
  {
    AnimatorSet.Node localNode = (AnimatorSet.Node)AnimatorSet.b(this.a).get(paramAnimator);
    if (localNode == null)
    {
      localNode = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.b(this.a).put(paramAnimator, localNode);
      AnimatorSet.d(this.a).add(localNode);
    }
    localNode.a(new AnimatorSet.Dependency(this.b, 0));
    return this;
  }

  public Builder b(Animator paramAnimator)
  {
    AnimatorSet.Node localNode = (AnimatorSet.Node)AnimatorSet.b(this.a).get(paramAnimator);
    if (localNode == null)
    {
      localNode = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.b(this.a).put(paramAnimator, localNode);
      AnimatorSet.d(this.a).add(localNode);
    }
    localNode.a(new AnimatorSet.Dependency(this.b, 1));
    return this;
  }

  public Builder c(Animator paramAnimator)
  {
    AnimatorSet.Node localNode = (AnimatorSet.Node)AnimatorSet.b(this.a).get(paramAnimator);
    if (localNode == null)
    {
      localNode = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.b(this.a).put(paramAnimator, localNode);
      AnimatorSet.d(this.a).add(localNode);
    }
    AnimatorSet.Dependency localDependency = new AnimatorSet.Dependency(localNode, 1);
    this.b.a(localDependency);
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.Builder
 * JD-Core Version:    0.6.2
 */