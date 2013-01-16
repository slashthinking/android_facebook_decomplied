package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V>
{
  final transient ImmutableMap<K, V> a;
  final transient ImmutableBiMap<V, K> b;

  RegularImmutableBiMap(ImmutableMap<K, V> paramImmutableMap)
  {
    this.a = paramImmutableMap;
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Iterator localIterator = paramImmutableMap.a().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBuilder.b(localEntry.getValue(), localEntry.getKey());
    }
    this.b = new RegularImmutableBiMap(localBuilder.b(), this);
  }

  RegularImmutableBiMap(ImmutableMap<K, V> paramImmutableMap, ImmutableBiMap<V, K> paramImmutableBiMap)
  {
    this.a = paramImmutableMap;
    this.b = paramImmutableBiMap;
  }

  boolean d()
  {
    if ((this.a.d()) || (this.b.f().d()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  ImmutableMap<K, V> f()
  {
    return this.a;
  }

  public ImmutableBiMap<V, K> g()
  {
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableBiMap
 * JD-Core Version:    0.6.2
 */