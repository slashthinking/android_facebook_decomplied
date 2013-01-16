package com.google.common.collect;

import java.util.NoSuchElementException;

final class Iterators$13 extends UnmodifiableIterator<T>
{
  boolean a;

  Iterators$13(Object paramObject)
  {
  }

  public boolean hasNext()
  {
    if (!this.a);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public T next()
  {
    if (this.a)
      throw new NoSuchElementException();
    this.a = true;
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterators.13
 * JD-Core Version:    0.6.2
 */