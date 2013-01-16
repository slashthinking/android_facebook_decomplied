package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableSortedMap$2 extends TransformedImmutableList<Map.Entry<K, V>, K>
{
  ImmutableSortedMap$2(ImmutableSortedMap paramImmutableSortedMap, ImmutableList paramImmutableList)
  {
    super(paramImmutableList);
  }

  K a(Map.Entry<K, V> paramEntry)
  {
    return paramEntry.getKey();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.2
 * JD-Core Version:    0.6.2
 */