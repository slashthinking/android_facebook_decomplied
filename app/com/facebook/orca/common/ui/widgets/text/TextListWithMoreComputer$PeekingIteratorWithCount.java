package com.facebook.orca.common.ui.widgets.text;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import java.util.Collection;

class TextListWithMoreComputer$PeekingIteratorWithCount<T>
  implements PeekingIterator<T>
{
  private final PeekingIterator<T> a;
  private int b;

  private TextListWithMoreComputer$PeekingIteratorWithCount(Collection<T> paramCollection)
  {
    this.a = Iterators.g(paramCollection.iterator());
    this.b = paramCollection.size();
  }

  public static <T> PeekingIteratorWithCount<T> a(Collection<T> paramCollection)
  {
    return new PeekingIteratorWithCount(paramCollection);
  }

  public T a()
  {
    return this.a.a();
  }

  public int b()
  {
    return this.b;
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }

  public T next()
  {
    Object localObject = this.a.next();
    this.b = (-1 + this.b);
    return localObject;
  }

  public void remove()
  {
    this.a.remove();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.TextListWithMoreComputer.PeekingIteratorWithCount
 * JD-Core Version:    0.6.0
 */