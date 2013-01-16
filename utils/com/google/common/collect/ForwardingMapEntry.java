package com.google.common.collect;

import java.util.Map.Entry;

public abstract class ForwardingMapEntry<K, V> extends ForwardingObject
  implements Map.Entry<K, V>
{
  protected abstract Map.Entry<K, V> a();

  public boolean equals(Object paramObject)
  {
    return a().equals(paramObject);
  }

  public K getKey()
  {
    return a().getKey();
  }

  public V getValue()
  {
    return a().getValue();
  }

  public int hashCode()
  {
    return a().hashCode();
  }

  public V setValue(V paramV)
  {
    return a().setValue(paramV);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ForwardingMapEntry
 * JD-Core Version:    0.6.2
 */