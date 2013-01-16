package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;

class EmptyImmutableSortedSet<E> extends ImmutableSortedSet<E>
{
  private static final Object[] b = new Object[0];

  EmptyImmutableSortedSet(Comparator<? super E> paramComparator)
  {
    super(paramComparator);
  }

  int a(Object paramObject)
  {
    return -1;
  }

  ImmutableSortedSet<E> a(E paramE, boolean paramBoolean)
  {
    return this;
  }

  ImmutableSortedSet<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return this;
  }

  ImmutableSortedSet<E> b(E paramE, boolean paramBoolean)
  {
    return this;
  }

  public UnmodifiableIterator<E> b()
  {
    return Iterators.a();
  }

  public boolean contains(Object paramObject)
  {
    return false;
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return paramCollection.isEmpty();
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Set));
    for (boolean bool = ((Set)paramObject).isEmpty(); ; bool = false)
      return bool;
  }

  public E first()
  {
    throw new NoSuchElementException();
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean isEmpty()
  {
    return true;
  }

  boolean l_()
  {
    return false;
  }

  public E last()
  {
    throw new NoSuchElementException();
  }

  public int size()
  {
    return 0;
  }

  public Object[] toArray()
  {
    return b;
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length > 0)
      paramArrayOfT[0] = null;
    return paramArrayOfT;
  }

  public String toString()
  {
    return "[]";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.EmptyImmutableSortedSet
 * JD-Core Version:    0.6.2
 */