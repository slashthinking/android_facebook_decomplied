package com.google.common.collect;

import java.util.NoSuchElementException;

final class EmptyImmutableList$1 extends UnmodifiableListIterator<Object>
{
  public boolean hasNext()
  {
    return false;
  }

  public boolean hasPrevious()
  {
    return false;
  }

  public Object next()
  {
    throw new NoSuchElementException();
  }

  public int nextIndex()
  {
    return 0;
  }

  public Object previous()
  {
    throw new NoSuchElementException();
  }

  public int previousIndex()
  {
    return -1;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.EmptyImmutableList.1
 * JD-Core Version:    0.6.2
 */