package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Synchronized$SynchronizedAsMap<K, V> extends Synchronized.SynchronizedMap<K, Collection<V>>
{
  private static final long serialVersionUID;
  transient Set<Map.Entry<K, Collection<V>>> a;
  transient Collection<Collection<V>> b;

  Synchronized$SynchronizedAsMap(Map<K, Collection<V>> paramMap, Object paramObject)
  {
    super(paramMap, paramObject);
  }

  public Collection<V> a(Object paramObject)
  {
    synchronized (this.mutex)
    {
      Collection localCollection = (Collection)super.get(paramObject);
      if (localCollection == null)
      {
        localObject3 = null;
        return localObject3;
      }
      Object localObject3 = Synchronized.a(localCollection, this.mutex);
    }
  }

  public boolean containsValue(Object paramObject)
  {
    return values().contains(paramObject);
  }

  public Set<Map.Entry<K, Collection<V>>> entrySet()
  {
    synchronized (this.mutex)
    {
      if (this.a == null)
        this.a = new Synchronized.SynchronizedAsMapEntries(a().entrySet(), this.mutex);
      Set localSet = this.a;
      return localSet;
    }
  }

  public Collection<Collection<V>> values()
  {
    synchronized (this.mutex)
    {
      if (this.b == null)
        this.b = new Synchronized.SynchronizedAsMapValues(a().values(), this.mutex);
      Collection localCollection = this.b;
      return localCollection;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMap
 * JD-Core Version:    0.6.2
 */