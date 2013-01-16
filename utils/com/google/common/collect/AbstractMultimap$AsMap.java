package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMultimap$AsMap extends AbstractMap<K, Collection<V>>
{
  final transient Map<K, Collection<V>> a;
  transient Set<Map.Entry<K, Collection<V>>> b;

  AbstractMultimap$AsMap(Map<K, Collection<V>> paramMap)
  {
    Object localObject;
    this.a = localObject;
  }

  public Collection<V> a(Object paramObject)
  {
    Collection localCollection = (Collection)Maps.a(this.a, paramObject);
    if (localCollection == null);
    for (Object localObject = null; ; localObject = AbstractMultimap.a(this.c, paramObject, localCollection))
      return localObject;
  }

  public Collection<V> b(Object paramObject)
  {
    Collection localCollection1 = (Collection)this.a.remove(paramObject);
    if (localCollection1 == null);
    Collection localCollection2;
    for (Object localObject = null; ; localObject = localCollection2)
    {
      return localObject;
      localCollection2 = this.c.c();
      localCollection2.addAll(localCollection1);
      AbstractMultimap.b(this.c, localCollection1.size());
      localCollection1.clear();
    }
  }

  public void clear()
  {
    if (this.a == AbstractMultimap.a(this.c))
      this.c.f();
    while (true)
    {
      return;
      Iterators.f(new AbstractMultimap.AsMap.AsMapIterator(this));
    }
  }

  public boolean containsKey(Object paramObject)
  {
    return Maps.b(this.a, paramObject);
  }

  public Set<Map.Entry<K, Collection<V>>> entrySet()
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      localObject = new AbstractMultimap.AsMap.AsMapEntries(this);
      this.b = ((Set)localObject);
    }
    return localObject;
  }

  public boolean equals(Object paramObject)
  {
    if ((this == paramObject) || (this.a.equals(paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public Set<K> keySet()
  {
    return this.c.g();
  }

  public int size()
  {
    return this.a.size();
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.AsMap
 * JD-Core Version:    0.6.2
 */