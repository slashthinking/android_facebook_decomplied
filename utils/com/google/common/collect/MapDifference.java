package com.google.common.collect;

import java.util.Map;

public abstract interface MapDifference<K, V>
{
  public abstract Map<K, V> a();

  public abstract Map<K, V> b();

  public abstract Map<K, V> c();

  public abstract Map<K, MapDifference.ValueDifference<V>> d();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.MapDifference
 * JD-Core Version:    0.6.2
 */