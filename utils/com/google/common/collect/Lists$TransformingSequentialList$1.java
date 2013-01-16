package com.google.common.collect;

import com.google.common.base.Function;
import java.util.ListIterator;

class Lists$TransformingSequentialList$1
  implements ListIterator<T>
{
  Lists$TransformingSequentialList$1(Lists.TransformingSequentialList paramTransformingSequentialList, ListIterator paramListIterator)
  {
  }

  public void add(T paramT)
  {
    throw new UnsupportedOperationException();
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }

  public boolean hasPrevious()
  {
    return this.a.hasPrevious();
  }

  public T next()
  {
    return this.b.function.apply(this.a.next());
  }

  public int nextIndex()
  {
    return this.a.nextIndex();
  }

  public T previous()
  {
    return this.b.function.apply(this.a.previous());
  }

  public int previousIndex()
  {
    return this.a.previousIndex();
  }

  public void remove()
  {
    this.a.remove();
  }

  public void set(T paramT)
  {
    throw new UnsupportedOperationException("not supported");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Lists.TransformingSequentialList.1
 * JD-Core Version:    0.6.2
 */