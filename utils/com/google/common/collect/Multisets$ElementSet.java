package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

abstract class Multisets$ElementSet<E> extends AbstractSet<E>
{
  abstract Multiset<E> a();

  public void clear()
  {
    a().clear();
  }

  public boolean contains(Object paramObject)
  {
    return a().contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return a().containsAll(paramCollection);
  }

  public boolean isEmpty()
  {
    return a().isEmpty();
  }

  public Iterator<E> iterator()
  {
    return Iterators.a(a().a().iterator(), new Multisets.ElementSet.1(this));
  }

  public boolean remove(Object paramObject)
  {
    int i = a().a(paramObject);
    if (i > 0)
      a().b(paramObject, i);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int size()
  {
    return a().a().size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multisets.ElementSet
 * JD-Core Version:    0.6.2
 */