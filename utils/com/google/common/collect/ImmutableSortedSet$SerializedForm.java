package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

class ImmutableSortedSet$SerializedForm<E>
  implements Serializable
{
  private static final long serialVersionUID;
  final Comparator<? super E> comparator;
  final Object[] elements;

  public ImmutableSortedSet$SerializedForm(Comparator<? super E> paramComparator, Object[] paramArrayOfObject)
  {
    this.comparator = paramComparator;
    this.elements = paramArrayOfObject;
  }

  Object readResolve()
  {
    return new ImmutableSortedSet.Builder(this.comparator).c((Object[])this.elements).c();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedSet.SerializedForm
 * JD-Core Version:    0.6.2
 */