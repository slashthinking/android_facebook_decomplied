package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

class Collections2$TransformedCollection<F, T> extends AbstractCollection<T>
{
  final Collection<F> a;
  final Function<? super F, ? extends T> b;

  Collections2$TransformedCollection(Collection<F> paramCollection, Function<? super F, ? extends T> paramFunction)
  {
    this.a = ((Collection)Preconditions.checkNotNull(paramCollection));
    this.b = ((Function)Preconditions.checkNotNull(paramFunction));
  }

  public void clear()
  {
    this.a.clear();
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public Iterator<T> iterator()
  {
    return Iterators.a(this.a.iterator(), this.b);
  }

  public int size()
  {
    return this.a.size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Collections2.TransformedCollection
 * JD-Core Version:    0.6.2
 */