package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

abstract class AbstractMultiset<E> extends AbstractCollection<E>
  implements Multiset<E>
{
  private transient Set<E> a;
  private transient Set<Multiset.Entry<E>> b;

  public int a(Object paramObject)
  {
    Iterator localIterator = a().iterator();
    Multiset.Entry localEntry;
    do
    {
      if (!localIterator.hasNext())
        break;
      localEntry = (Multiset.Entry)localIterator.next();
    }
    while (!Objects.equal(localEntry.a(), paramObject));
    for (int i = localEntry.b(); ; i = 0)
      return i;
  }

  public int a(E paramE, int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public Set<Multiset.Entry<E>> a()
  {
    Set localSet = this.b;
    if (localSet == null)
    {
      localSet = g();
      this.b = localSet;
    }
    return localSet;
  }

  public boolean add(E paramE)
  {
    a(paramE, 1);
    return true;
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    return Multisets.a(this, paramCollection);
  }

  public int b(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  abstract Iterator<Multiset.Entry<E>> b();

  abstract int c();

  public void clear()
  {
    Iterators.f(b());
  }

  public boolean contains(Object paramObject)
  {
    if (a(paramObject) > 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  Set<E> d()
  {
    return new AbstractMultiset.ElementSet(this);
  }

  public boolean equals(Object paramObject)
  {
    return Multisets.a(this, paramObject);
  }

  public Set<E> f()
  {
    Set localSet = this.a;
    if (localSet == null)
    {
      localSet = d();
      this.a = localSet;
    }
    return localSet;
  }

  Set<Multiset.Entry<E>> g()
  {
    return new AbstractMultiset.EntrySet(this);
  }

  public int hashCode()
  {
    return a().hashCode();
  }

  public boolean isEmpty()
  {
    return a().isEmpty();
  }

  public Iterator<E> iterator()
  {
    return Multisets.a(this);
  }

  public boolean remove(Object paramObject)
  {
    int i = 1;
    if (b(paramObject, i) > 0);
    while (true)
    {
      return i;
      int j = 0;
    }
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return Multisets.b(this, paramCollection);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return Multisets.c(this, paramCollection);
  }

  public int size()
  {
    return Multisets.b(this);
  }

  public String toString()
  {
    return a().toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultiset
 * JD-Core Version:    0.6.2
 */