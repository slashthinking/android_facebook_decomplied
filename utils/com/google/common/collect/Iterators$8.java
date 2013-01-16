package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

final class Iterators$8
  implements Iterator<T>
{
  Iterators$8(Iterator paramIterator, Function paramFunction)
  {
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }

  public T next()
  {
    Object localObject = this.a.next();
    return this.b.apply(localObject);
  }

  public void remove()
  {
    this.a.remove();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterators.8
 * JD-Core Version:    0.6.2
 */