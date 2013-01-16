package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMultimap$SortedAsMap extends AbstractMultimap<K, V>.AsMap
  implements SortedMap<K, Collection<V>>
{
  SortedSet<K> d;

  AbstractMultimap$SortedAsMap(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap, localMap);
  }

  SortedMap<K, Collection<V>> a()
  {
    return (SortedMap)this.a;
  }

  public SortedSet<K> b()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      localObject = new AbstractMultimap.SortedKeySet(this.e, a());
      this.d = ((SortedSet)localObject);
    }
    return localObject;
  }

  public Comparator<? super K> comparator()
  {
    return a().comparator();
  }

  public K firstKey()
  {
    return a().firstKey();
  }

  public SortedMap<K, Collection<V>> headMap(K paramK)
  {
    return new SortedAsMap(this.e, a().headMap(paramK));
  }

  public K lastKey()
  {
    return a().lastKey();
  }

  public SortedMap<K, Collection<V>> subMap(K paramK1, K paramK2)
  {
    return new SortedAsMap(this.e, a().subMap(paramK1, paramK2));
  }

  public SortedMap<K, Collection<V>> tailMap(K paramK)
  {
    return new SortedAsMap(this.e, a().tailMap(paramK));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.SortedAsMap
 * JD-Core Version:    0.6.2
 */