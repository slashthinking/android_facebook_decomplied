package com.nineoldandroids.animation;

import java.util.ArrayList;

class AnimatorSet$Node
  implements Cloneable
{
  public Animator a;
  public ArrayList<AnimatorSet.Dependency> b = null;
  public ArrayList<AnimatorSet.Dependency> c = null;
  public ArrayList<Node> d = null;
  public ArrayList<Node> e = null;
  public boolean f = false;

  public AnimatorSet$Node(Animator paramAnimator)
  {
    this.a = paramAnimator;
  }

  public Node a()
  {
    try
    {
      Node localNode = (Node)super.clone();
      localNode.a = this.a.j();
      return localNode;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    throw new AssertionError();
  }

  public void a(AnimatorSet.Dependency paramDependency)
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      this.d = new ArrayList();
    }
    this.b.add(paramDependency);
    if (!this.d.contains(paramDependency.a))
      this.d.add(paramDependency.a);
    Node localNode = paramDependency.a;
    if (localNode.e == null)
      localNode.e = new ArrayList();
    localNode.e.add(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.Node
 * JD-Core Version:    0.6.2
 */