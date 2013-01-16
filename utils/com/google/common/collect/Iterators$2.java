package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$2
  implements Iterator<Object>
{
  public boolean hasNext()
  {
    return false;
  }

  public Object next()
  {
    throw new NoSuchElementException();
  }

  public void remove()
  {
    throw new IllegalStateException();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterators.2
 * JD-Core Version:    0.6.2
 */