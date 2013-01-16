package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class Lists$ReverseList$1
  implements ListIterator<T>
{
  boolean a;
  boolean b;

  Lists$ReverseList$1(Lists.ReverseList paramReverseList, ListIterator paramListIterator)
  {
  }

  public void add(T paramT)
  {
    this.c.add(paramT);
    this.c.previous();
    this.a = false;
    this.b = false;
  }

  public boolean hasNext()
  {
    return this.c.hasPrevious();
  }

  public boolean hasPrevious()
  {
    return this.c.hasNext();
  }

  public T next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    this.a = true;
    this.b = true;
    return this.c.previous();
  }

  public int nextIndex()
  {
    return Lists.ReverseList.a(this.d, this.c.nextIndex());
  }

  public T previous()
  {
    if (!hasPrevious())
      throw new NoSuchElementException();
    this.a = true;
    this.b = true;
    return this.c.next();
  }

  public int previousIndex()
  {
    return -1 + nextIndex();
  }

  public void remove()
  {
    Preconditions.checkState(this.a);
    this.c.remove();
    this.b = false;
    this.a = false;
  }

  public void set(T paramT)
  {
    Preconditions.checkState(this.b);
    this.c.set(paramT);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Lists.ReverseList.1
 * JD-Core Version:    0.6.2
 */