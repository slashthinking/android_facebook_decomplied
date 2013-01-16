package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMultimap$SortedKeySet extends AbstractMultimap<K, V>.KeySet
  implements SortedSet<K>
{
  AbstractMultimap$SortedKeySet(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap, localMap);
  }

  SortedMap<K, Collection<V>> b()
  {
    return (SortedMap)this.a;
  }

  public Comparator<? super K> comparator()
  {
    return b().comparator();
  }

  public K first()
  {
    return b().firstKey();
  }

  public SortedSet<K> headSet(K paramK)
  {
    return new SortedKeySet(this.c, b().headMap(paramK));
  }

  public K last()
  {
    return b().lastKey();
  }

  public SortedSet<K> subSet(K paramK1, K paramK2)
  {
    return new SortedKeySet(this.c, b().subMap(paramK1, paramK2));
  }

  public SortedSet<K> tailSet(K paramK)
  {
    return new SortedKeySet(this.c, b().tailMap(paramK));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.SortedKeySet
 * JD-Core Version:    0.6.2
 */