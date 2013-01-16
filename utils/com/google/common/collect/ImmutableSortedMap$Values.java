package com.google.common.collect;

class ImmutableSortedMap$Values<V> extends ImmutableCollection<V>
{
  private final ImmutableSortedMap<?, V> map;

  ImmutableSortedMap$Values(ImmutableSortedMap<?, V> paramImmutableSortedMap)
  {
    this.map = paramImmutableSortedMap;
  }

  public UnmodifiableIterator<V> b()
  {
    return this.map.g();
  }

  public boolean contains(Object paramObject)
  {
    return this.map.containsValue(paramObject);
  }

  boolean l_()
  {
    return true;
  }

  public int size()
  {
    return this.map.size();
  }

  Object writeReplace()
  {
    return new ImmutableSortedMap.ValuesSerializedForm(this.map);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.Values
 * JD-Core Version:    0.6.2
 */