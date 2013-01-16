package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class ComparatorOrdering<T> extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID;
  final Comparator<T> comparator;

  ComparatorOrdering(Comparator<T> paramComparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }

  public <E extends T> List<E> a(Iterable<E> paramIterable)
  {
    ArrayList localArrayList = Lists.a(paramIterable);
    Collections.sort(localArrayList, this.comparator);
    return localArrayList;
  }

  public int compare(T paramT1, T paramT2)
  {
    return this.comparator.compare(paramT1, paramT2);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject instanceof ComparatorOrdering))
      {
        ComparatorOrdering localComparatorOrdering = (ComparatorOrdering)paramObject;
        bool = this.comparator.equals(localComparatorOrdering.comparator);
      }
      else
      {
        bool = false;
      }
    }
  }

  public int hashCode()
  {
    return this.comparator.hashCode();
  }

  public String toString()
  {
    return this.comparator.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ComparatorOrdering
 * JD-Core Version:    0.6.2
 */