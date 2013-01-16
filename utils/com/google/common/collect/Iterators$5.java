package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$5
  implements Iterator<T>
{
  Iterator<? extends T> a = Iterators.a();
  Iterator<? extends T> b;

  Iterators$5(Iterator paramIterator)
  {
  }

  public boolean hasNext()
  {
    boolean bool;
    while (true)
    {
      bool = ((Iterator)Preconditions.checkNotNull(this.a)).hasNext();
      if ((bool) || (!this.c.hasNext()))
        break;
      this.a = ((Iterator)this.c.next());
    }
    return bool;
  }

  public T next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    this.b = this.a;
    return this.a.next();
  }

  public void remove()
  {
    if (this.b != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "no calls to next() since last call to remove()");
      this.b.remove();
      this.b = null;
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterators.5
 * JD-Core Version:    0.6.2
 */