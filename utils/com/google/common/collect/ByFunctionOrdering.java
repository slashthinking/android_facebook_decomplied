package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ByFunctionOrdering<F, T> extends Ordering<F>
  implements Serializable
{
  private static final long serialVersionUID;
  final Function<F, ? extends T> function;
  final Ordering<T> ordering;

  ByFunctionOrdering(Function<F, ? extends T> paramFunction, Ordering<T> paramOrdering)
  {
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    this.ordering = ((Ordering)Preconditions.checkNotNull(paramOrdering));
  }

  public int compare(F paramF1, F paramF2)
  {
    return this.ordering.compare(this.function.apply(paramF1), this.function.apply(paramF2));
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this);
    while (true)
    {
      return bool;
      if ((paramObject instanceof ByFunctionOrdering))
      {
        ByFunctionOrdering localByFunctionOrdering = (ByFunctionOrdering)paramObject;
        if ((!this.function.equals(localByFunctionOrdering.function)) || (!this.ordering.equals(localByFunctionOrdering.ordering)))
          bool = false;
      }
      else
      {
        bool = false;
      }
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.function;
    arrayOfObject[1] = this.ordering;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return this.ordering + ".onResultOf(" + this.function + ")";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ByFunctionOrdering
 * JD-Core Version:    0.6.2
 */