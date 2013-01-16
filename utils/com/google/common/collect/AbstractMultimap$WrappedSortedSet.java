package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

class AbstractMultimap$WrappedSortedSet extends AbstractMultimap<K, V>.WrappedCollection
  implements SortedSet<V>
{
  AbstractMultimap$WrappedSortedSet(K paramK, SortedSet<V> paramSortedSet, AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    super(paramK, paramSortedSet, paramAbstractMultimap, localWrappedCollection);
  }

  public Comparator<? super V> comparator()
  {
    return g().comparator();
  }

  public V first()
  {
    a();
    return g().first();
  }

  SortedSet<V> g()
  {
    return (SortedSet)e();
  }

  public SortedSet<V> headSet(V paramV)
  {
    a();
    AbstractMultimap localAbstractMultimap = this.a;
    Object localObject = c();
    SortedSet localSortedSet = g().headSet(paramV);
    if (f() == null);
    while (true)
    {
      return new WrappedSortedSet(localAbstractMultimap, localObject, localSortedSet, this);
      this = f();
    }
  }

  public V last()
  {
    a();
    return g().last();
  }

  public SortedSet<V> subSet(V paramV1, V paramV2)
  {
    a();
    AbstractMultimap localAbstractMultimap = this.a;
    Object localObject = c();
    SortedSet localSortedSet = g().subSet(paramV1, paramV2);
    if (f() == null);
    while (true)
    {
      return new WrappedSortedSet(localAbstractMultimap, localObject, localSortedSet, this);
      this = f();
    }
  }

  public SortedSet<V> tailSet(V paramV)
  {
    a();
    AbstractMultimap localAbstractMultimap = this.a;
    Object localObject = c();
    SortedSet localSortedSet = g().tailSet(paramV);
    if (f() == null);
    while (true)
    {
      return new WrappedSortedSet(localAbstractMultimap, localObject, localSortedSet, this);
      this = f();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.WrappedSortedSet
 * JD-Core Version:    0.6.2
 */