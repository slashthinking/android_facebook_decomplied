package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ReverseOrdering<T> extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID;
  final Ordering<? super T> forwardOrder;

  ReverseOrdering(Ordering<? super T> paramOrdering)
  {
    this.forwardOrder = ((Ordering)Preconditions.checkNotNull(paramOrdering));
  }

  public <S extends T> Ordering<S> a()
  {
    return this.forwardOrder;
  }

  public int compare(T paramT1, T paramT2)
  {
    return this.forwardOrder.compare(paramT2, paramT1);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject instanceof ReverseOrdering))
      {
        ReverseOrdering localReverseOrdering = (ReverseOrdering)paramObject;
        bool = this.forwardOrder.equals(localReverseOrdering.forwardOrder);
      }
      else
      {
        bool = false;
      }
    }
  }

  public int hashCode()
  {
    return -this.forwardOrder.hashCode();
  }

  public String toString()
  {
    return this.forwardOrder + ".reverse()";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ReverseOrdering
 * JD-Core Version:    0.6.2
 */