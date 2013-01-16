package com.google.common.collect;

import java.util.Comparator;
import java.util.Map.Entry;

final class ImmutableSortedMap$1
  implements Comparator<Map.Entry<K, V>>
{
  ImmutableSortedMap$1(Comparator paramComparator)
  {
  }

  public int a(Map.Entry<K, V> paramEntry1, Map.Entry<K, V> paramEntry2)
  {
    return this.a.compare(paramEntry1.getKey(), paramEntry2.getKey());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.1
 * JD-Core Version:    0.6.2
 */