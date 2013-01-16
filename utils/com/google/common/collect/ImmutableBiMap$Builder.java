package com.google.common.collect;

import java.util.Map;

public final class ImmutableBiMap$Builder<K, V> extends ImmutableMap.Builder<K, V>
{
  public Builder<K, V> a(K paramK, V paramV)
  {
    super.b(paramK, paramV);
    return this;
  }

  public Builder<K, V> a(Map<? extends K, ? extends V> paramMap)
  {
    super.b(paramMap);
    return this;
  }

  public ImmutableBiMap<K, V> a()
  {
    ImmutableMap localImmutableMap = super.b();
    if (localImmutableMap.isEmpty());
    for (Object localObject = ImmutableBiMap.e(); ; localObject = new RegularImmutableBiMap(localImmutableMap))
      return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableBiMap.Builder
 * JD-Core Version:    0.6.2
 */