package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class Synchronized$SynchronizedList<E> extends Synchronized.SynchronizedCollection<E>
  implements List<E>
{
  private static final long serialVersionUID;

  Synchronized$SynchronizedList(List<E> paramList, Object paramObject)
  {
    super(paramList, paramObject, null);
  }

  List<E> a()
  {
    return (List)super.b();
  }

  public void add(int paramInt, E paramE)
  {
    synchronized (this.mutex)
    {
      a().add(paramInt, paramE);
      return;
    }
  }

  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    synchronized (this.mutex)
    {
      boolean bool = a().addAll(paramInt, paramCollection);
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

  public E get(int paramInt)
  {
    synchronized (this.mutex)
    {
      Object localObject3 = a().get(paramInt);
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

  public int indexOf(Object paramObject)
  {
    synchronized (this.mutex)
    {
      int i = a().indexOf(paramObject);
      return i;
    }
  }

  public int lastIndexOf(Object paramObject)
  {
    synchronized (this.mutex)
    {
      int i = a().lastIndexOf(paramObject);
      return i;
    }
  }

  public ListIterator<E> listIterator()
  {
    return a().listIterator();
  }

  public ListIterator<E> listIterator(int paramInt)
  {
    return a().listIterator(paramInt);
  }

  public E remove(int paramInt)
  {
    synchronized (this.mutex)
    {
      Object localObject3 = a().remove(paramInt);
      return localObject3;
    }
  }

  public E set(int paramInt, E paramE)
  {
    synchronized (this.mutex)
    {
      Object localObject3 = a().set(paramInt, paramE);
      return localObject3;
    }
  }

  public List<E> subList(int paramInt1, int paramInt2)
  {
    synchronized (this.mutex)
    {
      List localList = Synchronized.a(a().subList(paramInt1, paramInt2), this.mutex);
      return localList;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedList
 * JD-Core Version:    0.6.2
 */