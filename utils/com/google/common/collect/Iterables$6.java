package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

final class Iterables$6 extends Iterables.IterableWithToString<T>
{
  Iterables$6(Iterable paramIterable, Predicate paramPredicate)
  {
  }

  public Iterator<T> iterator()
  {
    return Iterators.a(this.a.iterator(), this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterables.6
 * JD-Core Version:    0.6.2
 */