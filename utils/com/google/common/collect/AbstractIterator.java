package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> extends UnmodifiableIterator<T>
{
  private AbstractIterator.State a = AbstractIterator.State.NOT_READY;
  private T b;

  private boolean c()
  {
    this.a = AbstractIterator.State.FAILED;
    this.b = a();
    if (this.a != AbstractIterator.State.DONE)
      this.a = AbstractIterator.State.READY;
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  protected abstract T a();

  protected final T b()
  {
    this.a = AbstractIterator.State.DONE;
    return null;
  }

  public final boolean hasNext()
  {
    boolean bool1;
    if (this.a != AbstractIterator.State.FAILED)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      int i = AbstractIterator.1.a[this.a.ordinal()];
      bool2 = false;
      switch (i)
      {
      default:
      case 1:
      case 2:
      }
    }
    for (boolean bool2 = c(); ; bool2 = true)
    {
      return bool2;
      bool1 = false;
      break;
    }
  }

  public final T next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    this.a = AbstractIterator.State.NOT_READY;
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractIterator
 * JD-Core Version:    0.6.2
 */