package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Multisets$MultisetIteratorImpl<E>
  implements Iterator<E>
{
  private final Multiset<E> a;
  private final Iterator<Multiset.Entry<E>> b;
  private Multiset.Entry<E> c;
  private int d;
  private int e;
  private boolean f;

  Multisets$MultisetIteratorImpl(Multiset<E> paramMultiset, Iterator<Multiset.Entry<E>> paramIterator)
  {
    this.a = paramMultiset;
    this.b = paramIterator;
  }

  public boolean hasNext()
  {
    if ((this.d > 0) || (this.b.hasNext()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public E next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    if (this.d == 0)
    {
      this.c = ((Multiset.Entry)this.b.next());
      int i = this.c.b();
      this.d = i;
      this.e = i;
    }
    this.d = (-1 + this.d);
    this.f = true;
    return this.c.a();
  }

  public void remove()
  {
    Preconditions.checkState(this.f, "no calls to next() since the last call to remove()");
    if (this.e == 1)
      this.b.remove();
    while (true)
    {
      this.e = (-1 + this.e);
      this.f = false;
      return;
      this.a.remove(this.c.a());
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multisets.MultisetIteratorImpl
 * JD-Core Version:    0.6.2
 */