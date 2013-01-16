package com.facebook.widget.animatablelistview;

import com.google.common.collect.ImmutableList;

public class AnimatingListTransaction<T>
{
  private final ImmutableList<AnimatingListMutation<T>> a;
  private final ImmutableList<T> b;
  private final ImmutableList<T> c;

  AnimatingListTransaction(ImmutableList<AnimatingListMutation<T>> paramImmutableList, ImmutableList<T> paramImmutableList1, ImmutableList<T> paramImmutableList2)
  {
    this.a = paramImmutableList;
    this.b = paramImmutableList1;
    this.c = paramImmutableList2;
  }

  public ImmutableList<AnimatingListMutation<T>> a()
  {
    return this.a;
  }

  public ImmutableList<T> b()
  {
    return this.b;
  }

  public ImmutableList<T> c()
  {
    return this.c;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimatingListTransaction
 * JD-Core Version:    0.6.2
 */