package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

class AbstractMultimap$WrappedCollection extends AbstractCollection<V>
{
  final K b;
  Collection<V> c;
  final AbstractMultimap<K, V>.WrappedCollection d;
  final Collection<V> e;

  AbstractMultimap$WrappedCollection(K paramK, Collection<V> paramCollection, AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    this.b = paramCollection;
    this.c = paramAbstractMultimap;
    Object localObject;
    this.d = localObject;
    if (localObject == null);
    for (Collection localCollection = null; ; localCollection = localObject.e())
    {
      this.e = localCollection;
      return;
    }
  }

  void a()
  {
    if (this.d != null)
    {
      this.d.a();
      if (this.d.e() != this.e)
        throw new ConcurrentModificationException();
    }
    else if (this.c.isEmpty())
    {
      Collection localCollection = (Collection)AbstractMultimap.a(this.f).get(this.b);
      if (localCollection != null)
        this.c = localCollection;
    }
  }

  public boolean add(V paramV)
  {
    a();
    boolean bool1 = this.c.isEmpty();
    boolean bool2 = this.c.add(paramV);
    if (bool2)
    {
      AbstractMultimap.c(this.f);
      if (bool1)
        d();
    }
    return bool2;
  }

  public boolean addAll(Collection<? extends V> paramCollection)
  {
    boolean bool;
    if (paramCollection.isEmpty())
      bool = false;
    while (true)
    {
      return bool;
      int i = size();
      bool = this.c.addAll(paramCollection);
      if (bool)
      {
        int j = this.c.size();
        AbstractMultimap.a(this.f, j - i);
        if (i == 0)
          d();
      }
    }
  }

  void b()
  {
    if (this.d != null)
      this.d.b();
    while (true)
    {
      return;
      if (this.c.isEmpty())
        AbstractMultimap.a(this.f).remove(this.b);
    }
  }

  K c()
  {
    return this.b;
  }

  public void clear()
  {
    int i = size();
    if (i == 0);
    while (true)
    {
      return;
      this.c.clear();
      AbstractMultimap.b(this.f, i);
      b();
    }
  }

  public boolean contains(Object paramObject)
  {
    a();
    return this.c.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    a();
    return this.c.containsAll(paramCollection);
  }

  void d()
  {
    if (this.d != null)
      this.d.d();
    while (true)
    {
      return;
      AbstractMultimap.a(this.f).put(this.b, this.c);
    }
  }

  Collection<V> e()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    for (boolean bool = true; ; bool = this.c.equals(paramObject))
    {
      return bool;
      a();
    }
  }

  AbstractMultimap<K, V>.WrappedCollection f()
  {
    return this.d;
  }

  public int hashCode()
  {
    a();
    return this.c.hashCode();
  }

  public Iterator<V> iterator()
  {
    a();
    return new AbstractMultimap.WrappedCollection.WrappedIterator(this);
  }

  public boolean remove(Object paramObject)
  {
    a();
    boolean bool = this.c.remove(paramObject);
    if (bool)
    {
      AbstractMultimap.b(this.f);
      b();
    }
    return bool;
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool;
    if (paramCollection.isEmpty())
      bool = false;
    while (true)
    {
      return bool;
      int i = size();
      bool = this.c.removeAll(paramCollection);
      if (bool)
      {
        int j = this.c.size();
        AbstractMultimap.a(this.f, j - i);
        b();
      }
    }
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    Preconditions.checkNotNull(paramCollection);
    int i = size();
    boolean bool = this.c.retainAll(paramCollection);
    if (bool)
    {
      int j = this.c.size();
      AbstractMultimap.a(this.f, j - i);
      b();
    }
    return bool;
  }

  public int size()
  {
    a();
    return this.c.size();
  }

  public String toString()
  {
    a();
    return this.c.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.WrappedCollection
 * JD-Core Version:    0.6.2
 */