package com.google.common.collect;

import com.google.common.base.Objects;

public abstract class GenericMapMaker<K0, V0>
{
  MapMaker.RemovalListener<K0, V0> a;

  <K extends K0, V extends V0> MapMaker.RemovalListener<K, V> a()
  {
    return (MapMaker.RemovalListener)Objects.firstNonNull(this.a, GenericMapMaker.NullListener.INSTANCE);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.GenericMapMaker
 * JD-Core Version:    0.6.2
 */