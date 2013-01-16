package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

final class Iterables$8 extends Iterables.IterableWithToString<T>
{
  Iterables$8(Iterable paramIterable, Function paramFunction)
  {
  }

  public Iterator<T> iterator()
  {
    return Iterators.a(this.a.iterator(), this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterables.8
 * JD-Core Version:    0.6.2
 */