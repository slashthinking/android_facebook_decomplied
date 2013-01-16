package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class AbstractMultimap$WrappedList extends AbstractMultimap<K, V>.WrappedCollection
  implements List<V>
{
  AbstractMultimap$WrappedList(K paramK, List<V> paramList, AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    super(paramK, paramList, paramAbstractMultimap, localWrappedCollection);
  }

  public void add(int paramInt, V paramV)
  {
    a();
    boolean bool = e().isEmpty();
    g().add(paramInt, paramV);
    AbstractMultimap.c(this.g);
    if (bool)
      d();
  }

  public boolean addAll(int paramInt, Collection<? extends V> paramCollection)
  {
    boolean bool;
    if (paramCollection.isEmpty())
      bool = false;
    while (true)
    {
      return bool;
      int i = size();
      bool = g().addAll(paramInt, paramCollection);
      if (bool)
      {
        int j = e().size();
        AbstractMultimap.a(this.g, j - i);
        if (i == 0)
          d();
      }
    }
  }

  List<V> g()
  {
    return (List)e();
  }

  public V get(int paramInt)
  {
    a();
    return g().get(paramInt);
  }

  public int indexOf(Object paramObject)
  {
    a();
    return g().indexOf(paramObject);
  }

  public int lastIndexOf(Object paramObject)
  {
    a();
    return g().lastIndexOf(paramObject);
  }

  public ListIterator<V> listIterator()
  {
    a();
    return new AbstractMultimap.WrappedList.WrappedListIterator(this);
  }

  public ListIterator<V> listIterator(int paramInt)
  {
    a();
    return new AbstractMultimap.WrappedList.WrappedListIterator(this, paramInt);
  }

  public V remove(int paramInt)
  {
    a();
    Object localObject = g().remove(paramInt);
    AbstractMultimap.b(this.g);
    b();
    return localObject;
  }

  public V set(int paramInt, V paramV)
  {
    a();
    return g().set(paramInt, paramV);
  }

  public List<V> subList(int paramInt1, int paramInt2)
  {
    a();
    AbstractMultimap localAbstractMultimap = this.g;
    Object localObject = c();
    List localList = g().subList(paramInt1, paramInt2);
    if (f() == null);
    while (true)
    {
      return AbstractMultimap.a(localAbstractMultimap, localObject, localList, this);
      this = f();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.WrappedList
 * JD-Core Version:    0.6.2
 */