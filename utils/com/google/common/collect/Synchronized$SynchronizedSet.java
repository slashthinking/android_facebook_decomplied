package com.google.common.collect;

import java.util.Set;

class Synchronized$SynchronizedSet<E> extends Synchronized.SynchronizedCollection<E>
  implements Set<E>
{
  private static final long serialVersionUID;

  Synchronized$SynchronizedSet(Set<E> paramSet, Object paramObject)
  {
    super(paramSet, paramObject, null);
  }

  Set<E> a()
  {
    return (Set)super.b();
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

  public int hashCode()
  {
    synchronized (this.mutex)
    {
      int i = a().hashCode();
      return i;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedSet
 * JD-Core Version:    0.6.2
 */