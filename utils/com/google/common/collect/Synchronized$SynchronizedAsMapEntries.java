package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class Synchronized$SynchronizedAsMapEntries<K, V> extends Synchronized.SynchronizedSet<Map.Entry<K, Collection<V>>>
{
  private static final long serialVersionUID;

  Synchronized$SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, Object paramObject)
  {
    super(paramSet, paramObject);
  }

  public boolean contains(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = Maps.a(a(), paramObject);
      return bool;
    }
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    synchronized (this.mutex)
    {
      boolean bool = Collections2.a(a(), paramCollection);
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
        bool = Sets.a(a(), paramObject);
      }
    }
  }

  public Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    return new Synchronized.SynchronizedAsMapEntries.1(this, super.iterator());
  }

  public boolean remove(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = Maps.b(a(), paramObject);
      return bool;
    }
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    synchronized (this.mutex)
    {
      boolean bool = Iterators.a(a().iterator(), paramCollection);
      return bool;
    }
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    synchronized (this.mutex)
    {
      boolean bool = Iterators.b(a().iterator(), paramCollection);
      return bool;
    }
  }

  public Object[] toArray()
  {
    synchronized (this.mutex)
    {
      Object[] arrayOfObject = ObjectArrays.a(a());
      return arrayOfObject;
    }
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    synchronized (this.mutex)
    {
      Object[] arrayOfObject = ObjectArrays.a(a(), paramArrayOfT);
      return arrayOfObject;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMapEntries
 * JD-Core Version:    0.6.2
 */