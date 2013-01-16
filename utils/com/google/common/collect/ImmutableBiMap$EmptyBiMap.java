package com.google.common.collect;

class ImmutableBiMap$EmptyBiMap extends ImmutableBiMap<Object, Object>
{
  boolean d()
  {
    return false;
  }

  ImmutableMap<Object, Object> f()
  {
    return ImmutableMap.j();
  }

  public ImmutableBiMap<Object, Object> g()
  {
    return this;
  }

  Object readResolve()
  {
    return ImmutableBiMap.i();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableBiMap.EmptyBiMap
 * JD-Core Version:    0.6.2
 */