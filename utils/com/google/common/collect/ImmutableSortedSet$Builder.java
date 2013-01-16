package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public final class ImmutableSortedSet$Builder<E> extends ImmutableSet.Builder<E>
{
  private final Comparator<? super E> b;

  public ImmutableSortedSet$Builder(Comparator<? super E> paramComparator)
  {
    this.b = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }

  public Builder<E> c(Iterable<? extends E> paramIterable)
  {
    super.b(paramIterable);
    return this;
  }

  public Builder<E> c(E paramE)
  {
    super.b(paramE);
    return this;
  }

  public Builder<E> c(Iterator<? extends E> paramIterator)
  {
    super.b(paramIterator);
    return this;
  }

  public Builder<E> c(E[] paramArrayOfE)
  {
    super.b(paramArrayOfE);
    return this;
  }

  public ImmutableSortedSet<E> c()
  {
    return ImmutableSortedSet.a(this.b, this.a.iterator());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedSet.Builder
 * JD-Core Version:    0.6.2
 */