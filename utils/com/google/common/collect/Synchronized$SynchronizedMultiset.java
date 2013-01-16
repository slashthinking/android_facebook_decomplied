package com.google.common.collect;

import java.util.Set;

class Synchronized$SynchronizedMultiset<E> extends Synchronized.SynchronizedCollection<E>
  implements Multiset<E>
{
  private static final long serialVersionUID;
  transient Set<E> a;
  transient Set<Multiset.Entry<E>> b;

  Synchronized$SynchronizedMultiset(Multiset<E> paramMultiset, Object paramObject)
  {
    super(paramMultiset, paramObject, null);
  }

  public int a(Object paramObject)
  {
    synchronized (this.mutex)
    {
      int i = d().a(paramObject);
      return i;
    }
  }

  public int a(E paramE, int paramInt)
  {
    synchronized (this.mutex)
    {
      int i = d().a(paramE, paramInt);
      return i;
    }
  }

  public Set<Multiset.Entry<E>> a()
  {
    synchronized (this.mutex)
    {
      if (this.b == null)
        this.b = Synchronized.b(d().a(), this.mutex);
      Set localSet = this.b;
      return localSet;
    }
  }

  public int b(Object paramObject, int paramInt)
  {
    synchronized (this.mutex)
    {
      int i = d().b(paramObject, paramInt);
      return i;
    }
  }

  Multiset<E> d()
  {
    return (Multiset)super.b();
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
        bool = d().equals(paramObject);
      }
    }
  }

  public Set<E> f()
  {
    synchronized (this.mutex)
    {
      if (this.a == null)
        this.a = Synchronized.b(d().f(), this.mutex);
      Set localSet = this.a;
      return localSet;
    }
  }

  public int hashCode()
  {
    synchronized (this.mutex)
    {
      int i = d().hashCode();
      return i;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedMultiset
 * JD-Core Version:    0.6.2
 */