package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V>
  implements ConcurrentMap<K, V>
{
  protected abstract ConcurrentMap<K, V> a();

  public V putIfAbsent(K paramK, V paramV)
  {
    return a().putIfAbsent(paramK, paramV);
  }

  public boolean remove(Object paramObject1, Object paramObject2)
  {
    return a().remove(paramObject1, paramObject2);
  }

  public V replace(K paramK, V paramV)
  {
    return a().replace(paramK, paramV);
  }

  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    return a().replace(paramK, paramV1, paramV2);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ForwardingConcurrentMap
 * JD-Core Version:    0.6.2
 */