package com.google.common.collect;

import java.util.NoSuchElementException;

public abstract class AbstractLinkedIterator<T> extends UnmodifiableIterator<T>
{
  private T a;

  protected AbstractLinkedIterator(T paramT)
  {
    this.a = paramT;
  }

  protected abstract T a(T paramT);

  public final boolean hasNext()
  {
    if (this.a != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public final T next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    try
    {
      Object localObject2 = this.a;
      return localObject2;
    }
    finally
    {
      this.a = a(this.a);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractLinkedIterator
 * JD-Core Version:    0.6.2
 */