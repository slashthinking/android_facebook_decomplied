package com.google.common.collect;

import java.util.Iterator;

final class Iterables$3 extends UnmodifiableIterator<Iterator<? extends T>>
{
  Iterables$3(Iterator paramIterator)
  {
  }

  public Iterator<? extends T> a()
  {
    return ((Iterable)this.a.next()).iterator();
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterables.3
 * JD-Core Version:    0.6.2
 */