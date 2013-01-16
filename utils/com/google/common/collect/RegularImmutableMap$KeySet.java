package com.google.common.collect;

import java.util.Map.Entry;

class RegularImmutableMap$KeySet<K, V> extends ImmutableSet.TransformedImmutableSet<Map.Entry<K, V>, K>
{
  final RegularImmutableMap<K, V> map;

  RegularImmutableMap$KeySet(RegularImmutableMap<K, V> paramRegularImmutableMap)
  {
    super(RegularImmutableMap.a(paramRegularImmutableMap), RegularImmutableMap.b(paramRegularImmutableMap));
    this.map = paramRegularImmutableMap;
  }

  K a(Map.Entry<K, V> paramEntry)
  {
    return paramEntry.getKey();
  }

  public boolean contains(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }

  boolean l_()
  {
    return true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMap.KeySet
 * JD-Core Version:    0.6.2
 */