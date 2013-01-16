package com.google.common.collect;

import java.util.List;
import java.util.ListIterator;

class AbstractMultimap$WrappedList$WrappedListIterator extends AbstractMultimap<K, V>.WrappedCollection.WrappedIterator
  implements ListIterator<V>
{
  AbstractMultimap$WrappedList$WrappedListIterator(AbstractMultimap.WrappedList paramWrappedList)
  {
    super(paramWrappedList);
  }

  public AbstractMultimap$WrappedList$WrappedListIterator(AbstractMultimap.WrappedList paramWrappedList, int paramInt)
  {
    super(paramWrappedList, paramWrappedList.g().listIterator(paramInt));
  }

  private ListIterator<V> c()
  {
    return (ListIterator)b();
  }

  public void add(V paramV)
  {
    boolean bool = this.d.isEmpty();
    c().add(paramV);
    AbstractMultimap.c(this.d.g);
    if (bool)
      this.d.d();
  }

  public boolean hasPrevious()
  {
    return c().hasPrevious();
  }

  public int nextIndex()
  {
    return c().nextIndex();
  }

  public V previous()
  {
    return c().previous();
  }

  public int previousIndex()
  {
    return c().previousIndex();
  }

  public void set(V paramV)
  {
    c().set(paramV);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.WrappedList.WrappedListIterator
 * JD-Core Version:    0.6.2
 */