package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

class MapMaker$NullConcurrentMap<K, V> extends AbstractMap<K, V>
  implements Serializable, ConcurrentMap<K, V>
{
  private static final long serialVersionUID;
  private final MapMaker.RemovalCause removalCause;
  private final MapMaker.RemovalListener<K, V> removalListener;

  MapMaker$NullConcurrentMap(MapMaker paramMapMaker)
  {
    this.removalListener = paramMapMaker.a();
    this.removalCause = paramMapMaker.j;
  }

  void a(K paramK, V paramV)
  {
    MapMaker.RemovalNotification localRemovalNotification = new MapMaker.RemovalNotification(paramK, paramV, this.removalCause);
    this.removalListener.onRemoval(localRemovalNotification);
  }

  public boolean containsKey(Object paramObject)
  {
    return false;
  }

  public boolean containsValue(Object paramObject)
  {
    return false;
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    return Collections.emptySet();
  }

  public V get(Object paramObject)
  {
    return null;
  }

  public V put(K paramK, V paramV)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    a(paramK, paramV);
    return null;
  }

  public V putIfAbsent(K paramK, V paramV)
  {
    return put(paramK, paramV);
  }

  public V remove(Object paramObject)
  {
    return null;
  }

  public boolean remove(Object paramObject1, Object paramObject2)
  {
    return false;
  }

  public V replace(K paramK, V paramV)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    return null;
  }

  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV2);
    return false;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.MapMaker.NullConcurrentMap
 * JD-Core Version:    0.6.2
 */