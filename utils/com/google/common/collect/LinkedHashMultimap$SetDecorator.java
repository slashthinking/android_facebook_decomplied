package com.google.common.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class LinkedHashMultimap$SetDecorator extends ForwardingSet<V>
{
  final Set<V> a;
  final K b;

  LinkedHashMultimap$SetDecorator(K paramK, Set<V> paramSet)
  {
    Object localObject;
    this.a = localObject;
    this.b = paramSet;
  }

  <E> Collection<Map.Entry<K, E>> a(Collection<E> paramCollection)
  {
    ArrayList localArrayList = Lists.c(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localArrayList.add(a(localIterator.next()));
    return localArrayList;
  }

  <E> Map.Entry<K, E> a(E paramE)
  {
    return Maps.a(this.b, paramE);
  }

  protected Set<V> a()
  {
    return this.a;
  }

  public boolean add(V paramV)
  {
    boolean bool = this.a.add(paramV);
    if (bool)
      this.c.b.add(a(paramV));
    return bool;
  }

  public boolean addAll(Collection<? extends V> paramCollection)
  {
    boolean bool = this.a.addAll(paramCollection);
    if (bool)
      this.c.b.addAll(a(a()));
    return bool;
  }

  public void clear()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      this.c.b.remove(a(localObject));
    }
    this.a.clear();
  }

  public Iterator<V> iterator()
  {
    return new LinkedHashMultimap.SetDecorator.1(this, this.a.iterator());
  }

  public boolean remove(Object paramObject)
  {
    boolean bool = this.a.remove(paramObject);
    if (bool)
      this.c.b.remove(a(paramObject));
    return bool;
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = this.a.removeAll(paramCollection);
    if (bool)
      this.c.b.removeAll(a(paramCollection));
    return bool;
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!paramCollection.contains(localObject))
      {
        localIterator.remove();
        this.c.b.remove(Maps.a(this.b, localObject));
        bool = true;
      }
    }
    return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.LinkedHashMultimap.SetDecorator
 * JD-Core Version:    0.6.2
 */