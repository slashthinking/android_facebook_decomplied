package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$MapBasedElementSet$1
  implements Iterator<E>
{
  Map.Entry<E, Count> a;

  AbstractMapBasedMultiset$MapBasedElementSet$1(AbstractMapBasedMultiset.MapBasedElementSet paramMapBasedElementSet, Iterator paramIterator)
  {
  }

  public boolean hasNext()
  {
    return this.b.hasNext();
  }

  public E next()
  {
    this.a = ((Map.Entry)this.b.next());
    return this.a.getKey();
  }

  public void remove()
  {
    if (this.a != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "no calls to next() since the last call to remove()");
      AbstractMapBasedMultiset.a(this.c.a, ((Count)this.a.getValue()).d(0));
      this.b.remove();
      this.a = null;
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultiset.MapBasedElementSet.1
 * JD-Core Version:    0.6.2
 */