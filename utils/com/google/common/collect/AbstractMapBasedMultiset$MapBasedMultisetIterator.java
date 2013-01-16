package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMapBasedMultiset$MapBasedMultisetIterator
  implements Iterator<E>
{
  final Iterator<Map.Entry<E, Count>> a;
  Map.Entry<E, Count> b;
  int c;
  boolean d;

  AbstractMapBasedMultiset$MapBasedMultisetIterator(AbstractMapBasedMultiset paramAbstractMapBasedMultiset)
  {
    this.a = AbstractMapBasedMultiset.a(paramAbstractMapBasedMultiset).entrySet().iterator();
  }

  public boolean hasNext()
  {
    if ((this.c > 0) || (this.a.hasNext()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public E next()
  {
    if (this.c == 0)
    {
      this.b = ((Map.Entry)this.a.next());
      this.c = ((Count)this.b.getValue()).a();
    }
    this.c = (-1 + this.c);
    this.d = true;
    return this.b.getKey();
  }

  public void remove()
  {
    Preconditions.checkState(this.d, "no calls to next() since the last call to remove()");
    if (((Count)this.b.getValue()).a() <= 0)
      throw new ConcurrentModificationException();
    if (((Count)this.b.getValue()).b(-1) == 0)
      this.a.remove();
    AbstractMapBasedMultiset.b(this.e);
    this.d = false;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultiset.MapBasedMultisetIterator
 * JD-Core Version:    0.6.2
 */