package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

class Iterators$PeekingImpl<E>
  implements PeekingIterator<E>
{
  private final Iterator<? extends E> a;
  private boolean b;
  private E c;

  public Iterators$PeekingImpl(Iterator<? extends E> paramIterator)
  {
    this.a = ((Iterator)Preconditions.checkNotNull(paramIterator));
  }

  public E a()
  {
    if (!this.b)
    {
      this.c = this.a.next();
      this.b = true;
    }
    return this.c;
  }

  public boolean hasNext()
  {
    if ((this.b) || (this.a.hasNext()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public E next()
  {
    Object localObject;
    if (!this.b)
      localObject = this.a.next();
    while (true)
    {
      return localObject;
      localObject = this.c;
      this.b = false;
      this.c = null;
    }
  }

  public void remove()
  {
    if (!this.b);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Can't remove after you've peeked at next");
      this.a.remove();
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterators.PeekingImpl
 * JD-Core Version:    0.6.2
 */