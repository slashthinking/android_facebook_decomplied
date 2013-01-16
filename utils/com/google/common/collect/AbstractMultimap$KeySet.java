package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AbstractMultimap$KeySet extends Maps.KeySet<K, Collection<V>>
{
  final Map<K, Collection<V>> a;

  AbstractMultimap$KeySet(Map<K, Collection<V>> paramMap)
  {
    Object localObject;
    this.a = localObject;
  }

  Map<K, Collection<V>> a()
  {
    return this.a;
  }

  public void clear()
  {
    Iterators.f(iterator());
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.a.keySet().containsAll(paramCollection);
  }

  public boolean equals(Object paramObject)
  {
    if ((this == paramObject) || (this.a.keySet().equals(paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    return this.a.keySet().hashCode();
  }

  public Iterator<K> iterator()
  {
    return new AbstractMultimap.KeySet.1(this);
  }

  public boolean remove(Object paramObject)
  {
    Collection localCollection = (Collection)this.a.remove(paramObject);
    int j;
    if (localCollection != null)
    {
      j = localCollection.size();
      localCollection.clear();
      AbstractMultimap.b(this.b, j);
    }
    for (int i = j; ; i = 0)
    {
      if (i > 0);
      for (boolean bool = true; ; bool = false)
        return bool;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.KeySet
 * JD-Core Version:    0.6.2
 */