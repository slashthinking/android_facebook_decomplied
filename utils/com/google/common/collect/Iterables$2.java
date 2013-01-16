package com.google.common.collect;

import java.util.Iterator;

final class Iterables$2 extends Iterables.IterableWithToString<T>
{
  Iterables$2(Iterable paramIterable)
  {
  }

  public Iterator<T> iterator()
  {
    return Iterators.e(Iterables.d(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterables.2
 * JD-Core Version:    0.6.2
 */