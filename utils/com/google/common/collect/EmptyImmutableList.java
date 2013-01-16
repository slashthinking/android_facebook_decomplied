package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;

final class EmptyImmutableList extends ImmutableList<Object>
{
  static final EmptyImmutableList a = new EmptyImmutableList();
  static final UnmodifiableListIterator<Object> b = new EmptyImmutableList.1();
  private static final Object[] d = new Object[0];
  private static final long serialVersionUID;

  public ImmutableList<Object> a(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, 0);
    return this;
  }

  public UnmodifiableListIterator<Object> a(int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, 0);
    return b;
  }

  public UnmodifiableIterator<Object> b()
  {
    return Iterators.a();
  }

  public UnmodifiableListIterator<Object> c()
  {
    return b;
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
    if ((paramObject instanceof List));
    for (boolean bool = ((List)paramObject).isEmpty(); ; bool = false)
      return bool;
  }

  public Object get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, 0);
    throw new AssertionError("unreachable");
  }

  public int hashCode()
  {
    return 1;
  }

  public int indexOf(Object paramObject)
  {
    return -1;
  }

  public boolean isEmpty()
  {
    return true;
  }

  boolean l_()
  {
    return false;
  }

  public int lastIndexOf(Object paramObject)
  {
    return -1;
  }

  Object readResolve()
  {
    return a;
  }

  public int size()
  {
    return 0;
  }

  public Object[] toArray()
  {
    return d;
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
 * Qualified Name:     com.google.common.collect.EmptyImmutableList
 * JD-Core Version:    0.6.2
 */