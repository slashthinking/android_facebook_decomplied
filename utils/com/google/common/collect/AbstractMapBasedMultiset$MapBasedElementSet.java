package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AbstractMapBasedMultiset$MapBasedElementSet extends ForwardingSet<E>
{
  private final Map<E, Count> b;
  private final Set<E> c;

  AbstractMapBasedMultiset$MapBasedElementSet(Map<E, Count> paramMap)
  {
    Object localObject;
    this.b = localObject;
    this.c = localObject.keySet();
  }

  protected Set<E> a()
  {
    return this.c;
  }

  public void clear()
  {
    if (this.b == AbstractMapBasedMultiset.a(this.a))
      this.a.clear();
    while (true)
    {
      return;
      Iterator localIterator = iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        localIterator.remove();
      }
    }
  }

  public Iterator<E> iterator()
  {
    return new AbstractMapBasedMultiset.MapBasedElementSet.1(this, this.b.entrySet().iterator());
  }

  public boolean remove(Object paramObject)
  {
    if (AbstractMapBasedMultiset.a(this.a, paramObject, this.b) != 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return Iterators.a(iterator(), paramCollection);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return Iterators.b(iterator(), paramCollection);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultiset.MapBasedElementSet
 * JD-Core Version:    0.6.2
 */