package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

class Synchronized$SynchronizedSortedSet<E> extends Synchronized.SynchronizedSet<E>
  implements SortedSet<E>
{
  private static final long serialVersionUID;

  Synchronized$SynchronizedSortedSet(SortedSet<E> paramSortedSet, Object paramObject)
  {
    super(paramSortedSet, paramObject);
  }

  public Comparator<? super E> comparator()
  {
    synchronized (this.mutex)
    {
      Comparator localComparator = d().comparator();
      return localComparator;
    }
  }

  SortedSet<E> d()
  {
    return (SortedSet)super.a();
  }

  public E first()
  {
    synchronized (this.mutex)
    {
      Object localObject3 = d().first();
      return localObject3;
    }
  }

  public SortedSet<E> headSet(E paramE)
  {
    synchronized (this.mutex)
    {
      SortedSet localSortedSet = Synchronized.a(d().headSet(paramE), this.mutex);
      return localSortedSet;
    }
  }

  public E last()
  {
    synchronized (this.mutex)
    {
      Object localObject3 = d().last();
      return localObject3;
    }
  }

  public SortedSet<E> subSet(E paramE1, E paramE2)
  {
    synchronized (this.mutex)
    {
      SortedSet localSortedSet = Synchronized.a(d().subSet(paramE1, paramE2), this.mutex);
      return localSortedSet;
    }
  }

  public SortedSet<E> tailSet(E paramE)
  {
    synchronized (this.mutex)
    {
      SortedSet localSortedSet = Synchronized.a(d().tailSet(paramE), this.mutex);
      return localSortedSet;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedSortedSet
 * JD-Core Version:    0.6.2
 */