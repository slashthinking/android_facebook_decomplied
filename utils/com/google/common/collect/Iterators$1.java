package com.google.common.collect;

import java.util.NoSuchElementException;

final class Iterators$1 extends UnmodifiableIterator<Object>
{
  public boolean hasNext()
  {
    return false;
  }

  public Object next()
  {
    throw new NoSuchElementException();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterators.1
 * JD-Core Version:    0.6.2
 */