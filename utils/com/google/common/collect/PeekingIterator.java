package com.google.common.collect;

import java.util.Iterator;

public abstract interface PeekingIterator<E> extends Iterator<E>
{
  public abstract E a();

  public abstract E next();

  public abstract void remove();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.PeekingIterator
 * JD-Core Version:    0.6.2
 */