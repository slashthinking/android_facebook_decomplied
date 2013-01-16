package com.google.common.collect;

import java.util.Iterator;

public abstract class ForwardingIterator<T> extends ForwardingObject
  implements Iterator<T>
{
  protected abstract Iterator<T> a();

  public boolean hasNext()
  {
    return a().hasNext();
  }

  public T next()
  {
    return a().next();
  }

  public void remove()
  {
    a().remove();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ForwardingIterator
 * JD-Core Version:    0.6.2
 */