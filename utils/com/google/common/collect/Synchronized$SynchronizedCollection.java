package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

class Synchronized$SynchronizedCollection<E> extends Synchronized.SynchronizedObject
  implements Collection<E>
{
  private static final long serialVersionUID;

  private Synchronized$SynchronizedCollection(Collection<E> paramCollection, Object paramObject)
  {
    super(paramCollection, paramObject);
  }

  public boolean add(E paramE)
  {
    synchronized (this.mutex)
    {
      boolean bool = b().add(paramE);
      return bool;
    }
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    synchronized (this.mutex)
    {
      boolean bool = b().addAll(paramCollection);
      return bool;
    }
  }

  Collection<E> b()
  {
    return (Collection)super.c();
  }

  public void clear()
  {
    synchronized (this.mutex)
    {
      b().clear();
      return;
    }
  }

  public boolean contains(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = b().contains(paramObject);
      return bool;
    }
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    synchronized (this.mutex)
    {
      boolean bool = b().containsAll(paramCollection);
      return bool;
    }
  }

  public boolean isEmpty()
  {
    synchronized (this.mutex)
    {
      boolean bool = b().isEmpty();
      return bool;
    }
  }

  public Iterator<E> iterator()
  {
    return b().iterator();
  }

  public boolean remove(Object paramObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = b().remove(paramObject);
      return bool;
    }
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    synchronized (this.mutex)
    {
      boolean bool = b().removeAll(paramCollection);
      return bool;
    }
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    synchronized (this.mutex)
    {
      boolean bool = b().retainAll(paramCollection);
      return bool;
    }
  }

  public int size()
  {
    synchronized (this.mutex)
    {
      int i = b().size();
      return i;
    }
  }

  public Object[] toArray()
  {
    synchronized (this.mutex)
    {
      Object[] arrayOfObject = b().toArray();
      return arrayOfObject;
    }
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    synchronized (this.mutex)
    {
      Object[] arrayOfObject = b().toArray(paramArrayOfT);
      return arrayOfObject;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedCollection
 * JD-Core Version:    0.6.2
 */