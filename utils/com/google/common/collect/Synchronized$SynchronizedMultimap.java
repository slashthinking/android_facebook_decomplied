package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Synchronized$SynchronizedMultimap<K, V> extends Synchronized.SynchronizedObject
  implements Multimap<K, V>
{
  private static final long serialVersionUID;
  transient Set<K> a;
  transient Collection<Map.Entry<K, V>> b;
  transient Map<K, Collection<V>> c;
  transient Multiset<K> d;

  Synchronized$SynchronizedMultimap(Multimap<K, V> paramMultimap, Object paramObject)
  {
    super(paramMultimap, paramObject);
  }

  Multimap<K, V> a()
  {
    return (Multimap)super.c();
  }

  public boolean a(K paramK, Iterable<? extends V> paramIterable)
  {
    synchronized (this.mutex)
    {
      boolean bool = a().a(paramK, paramIterable);
      return bool;
    }
  }

  public boolean a(K paramK, V paramV)
  {
    synchronized (this.mutex)
    {
      boolean bool = a().a(paramK, paramV);
      return bool;
    }
  }

  public Collection<V> b(K paramK)
  {
    synchronized (this.mutex)
    {
      Collection localCollection = Synchronized.a(a().b(paramK), this.mutex);
      return localCollection;
    }
  }

  public Map<K, Collection<V>> b()
  {
    synchronized (this.mutex)
    {
      if (this.c == null)
        this.c = new Synchronized.SynchronizedAsMap(a().b(), this.mutex);
      Map localMap = this.c;
      return localMap;
    }
  }

  public boolean b(Object paramObject1, Object paramObject2)
  {
    synchronized (this.mutex)
    {
      boolean bool = a().b(paramObject1, paramObject2);
      return bool;
    }
  }

  public boolean c(Object paramObject1, Object paramObject2)
  {
    synchronized (this.mutex)
    {
      boolean bool = a().c(paramObject1, paramObject2);
      return bool;
    }
  }

  public int d()
  {
    synchronized (this.mutex)
    {
      int i = a().d();
      return i;
    }
  }

  public boolean d(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = a().d(paramObject);
      return bool;
    }
  }

  public boolean e()
  {
    synchronized (this.mutex)
    {
      boolean bool = a().e();
      return bool;
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

  public void f()
  {
    synchronized (this.mutex)
    {
      a().f();
      return;
    }
  }

  public Set<K> g()
  {
    synchronized (this.mutex)
    {
      if (this.a == null)
        this.a = Synchronized.b(a().g(), this.mutex);
      Set localSet = this.a;
      return localSet;
    }
  }

  public Multiset<K> h()
  {
    synchronized (this.mutex)
    {
      if (this.d == null)
        this.d = Synchronized.a(a().h(), this.mutex);
      Multiset localMultiset = this.d;
      return localMultiset;
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

  public Collection<Map.Entry<K, V>> i()
  {
    synchronized (this.mutex)
    {
      if (this.b == null)
        this.b = Synchronized.a(a().i(), this.mutex);
      Collection localCollection = this.b;
      return localCollection;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedMultimap
 * JD-Core Version:    0.6.2
 */