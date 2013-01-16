package com.google.common.collect;

import java.util.NoSuchElementException;

class SingletonImmutableList$1 extends UnmodifiableListIterator<E>
{
  boolean a;

  SingletonImmutableList$1(SingletonImmutableList paramSingletonImmutableList, int paramInt)
  {
    if (this.b == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.a = bool;
      return;
    }
  }

  public boolean hasNext()
  {
    return this.a;
  }

  public boolean hasPrevious()
  {
    if (!this.a);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public E next()
  {
    if (!this.a)
      throw new NoSuchElementException();
    this.a = false;
    return this.c.a;
  }

  public int nextIndex()
  {
    if (this.a);
    for (int i = 0; ; i = 1)
      return i;
  }

  public E previous()
  {
    if (this.a)
      throw new NoSuchElementException();
    this.a = true;
    return this.c.a;
  }

  public int previousIndex()
  {
    if (this.a);
    for (int i = -1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SingletonImmutableList.1
 * JD-Core Version:    0.6.2
 */