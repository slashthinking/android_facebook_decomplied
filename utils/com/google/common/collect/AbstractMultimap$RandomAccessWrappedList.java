package com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

class AbstractMultimap$RandomAccessWrappedList extends AbstractMultimap.WrappedList
  implements RandomAccess
{
  AbstractMultimap$RandomAccessWrappedList(K paramK, List<V> paramList, AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    super(paramK, paramList, paramAbstractMultimap, localWrappedCollection);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.RandomAccessWrappedList
 * JD-Core Version:    0.6.2
 */