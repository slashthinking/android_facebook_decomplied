package com.google.common.collect;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class AbstractMultimap$WrappedCollection$WrappedIterator
  implements Iterator<V>
{
  final Iterator<V> a;
  final Collection<V> b = this.c.c;

  AbstractMultimap$WrappedCollection$WrappedIterator(AbstractMultimap.WrappedCollection paramWrappedCollection)
  {
    this.a = AbstractMultimap.a(paramWrappedCollection.f, paramWrappedCollection.c);
  }

  AbstractMultimap$WrappedCollection$WrappedIterator(Iterator<V> paramIterator)
  {
    Object localObject;
    this.a = localObject;
  }

  void a()
  {
    this.c.a();
    if (this.c.c != this.b)
      throw new ConcurrentModificationException();
  }

  Iterator<V> b()
  {
    a();
    return this.a;
  }

  public boolean hasNext()
  {
    a();
    return this.a.hasNext();
  }

  public V next()
  {
    a();
    return this.a.next();
  }

  public void remove()
  {
    this.a.remove();
    AbstractMultimap.b(this.c.f);
    this.c.b();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.WrappedCollection.WrappedIterator
 * JD-Core Version:    0.6.2
 */