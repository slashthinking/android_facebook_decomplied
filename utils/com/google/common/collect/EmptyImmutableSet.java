package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

final class EmptyImmutableSet extends ImmutableSet<Object>
{
  static final EmptyImmutableSet a = new EmptyImmutableSet();
  private static final Object[] b = new Object[0];
  private static final long serialVersionUID;

  public UnmodifiableIterator<Object> b()
  {
    return Iterators.a();
  }

  boolean c()
  {
    return true;
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

  public final int hashCode()
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
 * Qualified Name:     com.google.common.collect.EmptyImmutableSet
 * JD-Core Version:    0.6.2
 */