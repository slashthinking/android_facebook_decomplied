package com.google.common.collect;

class RegularImmutableMap$Values<V> extends ImmutableCollection<V>
{
  final RegularImmutableMap<?, V> map;

  RegularImmutableMap$Values(RegularImmutableMap<?, V> paramRegularImmutableMap)
  {
    this.map = paramRegularImmutableMap;
  }

  public UnmodifiableIterator<V> b()
  {
    return new RegularImmutableMap.Values.1(this, RegularImmutableMap.a(this.map).length);
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
    return RegularImmutableMap.a(this.map).length;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMap.Values
 * JD-Core Version:    0.6.2
 */