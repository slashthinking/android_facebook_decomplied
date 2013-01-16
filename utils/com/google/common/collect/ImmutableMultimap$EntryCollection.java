package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMultimap$EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>>
{
  private static final long serialVersionUID;
  final ImmutableMultimap<K, V> multimap;

  ImmutableMultimap$EntryCollection(ImmutableMultimap<K, V> paramImmutableMultimap)
  {
    this.multimap = paramImmutableMultimap;
  }

  public UnmodifiableIterator<Map.Entry<K, V>> b()
  {
    return new ImmutableMultimap.EntryCollection.1(this, this.multimap.b.a().b());
  }

  public boolean contains(Object paramObject)
  {
    Map.Entry localEntry;
    if ((paramObject instanceof Map.Entry))
      localEntry = (Map.Entry)paramObject;
    for (boolean bool = this.multimap.b(localEntry.getKey(), localEntry.getValue()); ; bool = false)
      return bool;
  }

  boolean l_()
  {
    return this.multimap.k();
  }

  public int size()
  {
    return this.multimap.d();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultimap.EntryCollection
 * JD-Core Version:    0.6.2
 */