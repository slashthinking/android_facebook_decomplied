package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ForwardingMap<K, V> extends ForwardingObject
  implements Map<K, V>
{
  protected abstract Map<K, V> b();

  public void clear()
  {
    b().clear();
  }

  public boolean containsKey(Object paramObject)
  {
    return b().containsKey(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return b().containsValue(paramObject);
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    return b().entrySet();
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == this) || (b().equals(paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public V get(Object paramObject)
  {
    return b().get(paramObject);
  }

  public int hashCode()
  {
    return b().hashCode();
  }

  public boolean isEmpty()
  {
    return b().isEmpty();
  }

  public Set<K> keySet()
  {
    return b().keySet();
  }

  public V put(K paramK, V paramV)
  {
    return b().put(paramK, paramV);
  }

  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    b().putAll(paramMap);
  }

  public V remove(Object paramObject)
  {
    return b().remove(paramObject);
  }

  public int size()
  {
    return b().size();
  }

  public Collection<V> values()
  {
    return b().values();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ForwardingMap
 * JD-Core Version:    0.6.2
 */