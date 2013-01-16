package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator
  implements Cloneable
{
  ArrayList<Animator.AnimatorListener> a = null;

  public abstract void a(Interpolator paramInterpolator);

  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.a == null)
      this.a = new ArrayList();
    this.a.add(paramAnimatorListener);
  }

  public void a(Object paramObject)
  {
  }

  public void b(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.a == null);
    while (true)
    {
      return;
      this.a.remove(paramAnimatorListener);
      if (this.a.size() == 0)
        this.a = null;
    }
  }

  public abstract Animator c(long paramLong);

  public void c()
  {
  }

  public void d()
  {
  }

  public void e()
  {
  }

  public abstract boolean f();

  public boolean g()
  {
    return f();
  }

  public Animator j()
  {
    Animator localAnimator;
    try
    {
      localAnimator = (Animator)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        localAnimator.a = new ArrayList();
        int i = localArrayList.size();
        for (int j = 0; j < i; j++)
          localAnimator.a.add(localArrayList.get(j));
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
    return localAnimator;
  }

  public ArrayList<Animator.AnimatorListener> k()
  {
    return this.a;
  }

  public void l()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.Animator
 * JD-Core Version:    0.6.2
 */