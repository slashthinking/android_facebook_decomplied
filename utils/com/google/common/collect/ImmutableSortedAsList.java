package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;

final class ImmutableSortedAsList<E> extends ImmutableList<E>
  implements SortedIterable<E>
{
  private final transient ImmutableSortedSet<E> a;
  private final transient ImmutableList<E> b;

  ImmutableSortedAsList(ImmutableSortedSet<E> paramImmutableSortedSet, ImmutableList<E> paramImmutableList)
  {
    this.a = paramImmutableSortedSet;
    this.b = paramImmutableList;
  }

  public ImmutableList<E> a(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    if (paramInt1 == paramInt2);
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = new RegularImmutableSortedSet(this.b.a(paramInt1, paramInt2), this.a.comparator()).h())
      return localImmutableList;
  }

  public UnmodifiableListIterator<E> a(int paramInt)
  {
    return this.b.a(paramInt);
  }

  public UnmodifiableIterator<E> b()
  {
    return this.b.b();
  }

  public UnmodifiableListIterator<E> c()
  {
    return this.b.c();
  }

  public Comparator<? super E> comparator()
  {
    return this.a.comparator();
  }

  public boolean contains(Object paramObject)
  {
    if (this.a.a(paramObject) >= 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean equals(Object paramObject)
  {
    return this.b.equals(paramObject);
  }

  public E get(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  public int indexOf(Object paramObject)
  {
    return this.a.a(paramObject);
  }

  boolean l_()
  {
    return this.b.l_();
  }

  public int lastIndexOf(Object paramObject)
  {
    return this.a.a(paramObject);
  }

  public int size()
  {
    return this.b.size();
  }

  Object writeReplace()
  {
    return new ImmutableAsList.SerializedForm(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedAsList
 * JD-Core Version:    0.6.2
 */