package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Synchronized$SynchronizedMap<K, V> extends Synchronized.SynchronizedObject
  implements Map<K, V>
{
  private static final long serialVersionUID;
  transient Set<K> c;
  transient Collection<V> d;
  transient Set<Map.Entry<K, V>> e;

  Synchronized$SynchronizedMap(Map<K, V> paramMap, Object paramObject)
  {
    super(paramMap, paramObject);
  }

  Map<K, V> a()
  {
    return (Map)super.c();
  }

  public void clear()
  {
    synchronized (this.mutex)
    {
      a().clear();
      return;
    }
  }

  public boolean containsKey(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = a().containsKey(paramObject);
      return bool;
    }
  }

  public boolean containsValue(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = a().containsValue(paramObject);
      return bool;
    }
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    synchronized (this.mutex)
    {
      if (this.e == null)
        this.e = Synchronized.a(a().entrySet(), this.mutex);
      Set localSet = this.e;
      return localSet;
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      synchronized (this.mutex)
      {
        bool = a().equals(paramObject);
      }
    }
  }

  public V get(Object paramObject)
  {
    synchronized (this.mutex)
    {
      Object localObject3 = a().get(paramObject);
      return localObject3;
    }
  }

  public int hashCode()
  {
    synchronized (this.mutex)
    {
      int i = a().hashCode();
      return i;
    }
  }

  public boolean isEmpty()
  {
    synchronized (this.mutex)
    {
      boolean bool = a().isEmpty();
      return bool;
    }
  }

  public Set<K> keySet()
  {
    synchronized (this.mutex)
    {
      if (this.c == null)
        this.c = Synchronized.a(a().keySet(), this.mutex);
      Set localSet = this.c;
      return localSet;
    }
  }

  public V put(K paramK, V paramV)
  {
    synchronized (this.mutex)
    {
      Object localObject3 = a().put(paramK, paramV);
      return localObject3;
    }
  }

  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    synchronized (this.mutex)
    {
      a().putAll(paramMap);
      return;
    }
  }

  public V remove(Object paramObject)
  {
    synchronized (this.mutex)
    {
      Object localObject3 = a().remove(paramObject);
      return localObject3;
    }
  }

  public int size()
  {
    synchronized (this.mutex)
    {
      int i = a().size();
      return i;
    }
  }

  public Collection<V> values()
  {
    synchronized (this.mutex)
    {
      if (this.d == null)
        this.d = Synchronized.b(a().values(), this.mutex);
      Collection localCollection = this.d;
      return localCollection;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedMap
 * JD-Core Version:    0.6.2
 */