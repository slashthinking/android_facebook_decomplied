package com.google.common.collect;

import java.io.Serializable;

class ImmutableSortedMap$EntrySetSerializedForm<K, V>
  implements Serializable
{
  private static final long serialVersionUID;
  final ImmutableSortedMap<K, V> map;

  ImmutableSortedMap$EntrySetSerializedForm(ImmutableSortedMap<K, V> paramImmutableSortedMap)
  {
    this.map = paramImmutableSortedMap;
  }

  Object readResolve()
  {
    return this.map.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.EntrySetSerializedForm
 * JD-Core Version:    0.6.2
 */