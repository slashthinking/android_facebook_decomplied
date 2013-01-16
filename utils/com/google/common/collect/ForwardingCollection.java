package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

public abstract class ForwardingCollection<E> extends ForwardingObject
  implements Collection<E>
{
  public boolean add(E paramE)
  {
    return b().add(paramE);
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    return b().addAll(paramCollection);
  }

  protected abstract Collection<E> b();

  public void clear()
  {
    b().clear();
  }

  public boolean contains(Object paramObject)
  {
    return b().contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return b().containsAll(paramCollection);
  }

  public boolean isEmpty()
  {
    return b().isEmpty();
  }

  public Iterator<E> iterator()
  {
    return b().iterator();
  }

  public boolean remove(Object paramObject)
  {
    return b().remove(paramObject);
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return b().removeAll(paramCollection);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return b().retainAll(paramCollection);
  }

  public int size()
  {
    return b().size();
  }

  public Object[] toArray()
  {
    return b().toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return b().toArray(paramArrayOfT);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ForwardingCollection
 * JD-Core Version:    0.6.2
 */