package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

class AbstractMultimap$WrappedSet extends AbstractMultimap<K, V>.WrappedCollection
  implements Set<V>
{
  AbstractMultimap$WrappedSet(K paramK, Set<V> paramSet)
  {
    super(paramK, paramSet, localCollection, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.WrappedSet
 * JD-Core Version:    0.6.2
 */