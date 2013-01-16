package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E>
{
  private final int a;
  private int b;

  protected AbstractIndexedListIterator(int paramInt)
  {
    this(paramInt, 0);
  }

  protected AbstractIndexedListIterator(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndex(paramInt2, paramInt1);
    this.a = paramInt1;
    this.b = paramInt2;
  }

  protected abstract E a(int paramInt);

  public final boolean hasNext()
  {
    if (this.b < this.a);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public final boolean hasPrevious()
  {
    if (this.b > 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public final E next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    int i = this.b;
    this.b = (i + 1);
    return a(i);
  }

  public final int nextIndex()
  {
    return this.b;
  }

  public final E previous()
  {
    if (!hasPrevious())
      throw new NoSuchElementException();
    int i = -1 + this.b;
    this.b = i;
    return a(i);
  }

  public final int previousIndex()
  {
    return -1 + this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractIndexedListIterator
 * JD-Core Version:    0.6.2
 */