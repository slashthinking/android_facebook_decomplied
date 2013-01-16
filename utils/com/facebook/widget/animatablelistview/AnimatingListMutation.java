package com.facebook.widget.animatablelistview;

import com.nineoldandroids.animation.Animator;

public class AnimatingListMutation<T>
{
  private final AnimatingListMutation.MutationType a;
  private final T b;
  private final int c;
  private final Animator d;
  private final boolean e;

  AnimatingListMutation(T paramT, AnimatingListMutation.MutationType paramMutationType)
  {
    this.b = paramT;
    this.a = paramMutationType;
    this.c = -1;
    this.d = null;
    this.e = false;
  }

  AnimatingListMutation(T paramT, AnimatingListMutation.MutationType paramMutationType, int paramInt)
  {
    this.b = paramT;
    this.a = paramMutationType;
    this.c = paramInt;
    this.d = null;
    this.e = false;
  }

  AnimatingListMutation(T paramT, AnimatingListMutation.MutationType paramMutationType, boolean paramBoolean)
  {
    this.b = paramT;
    this.a = paramMutationType;
    this.c = -1;
    this.d = null;
    this.e = paramBoolean;
  }

  public AnimatingListMutation.MutationType a()
  {
    return this.a;
  }

  public T b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public Animator d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimatingListMutation
 * JD-Core Version:    0.6.2
 */