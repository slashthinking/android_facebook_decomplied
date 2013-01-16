package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

class Lists$TransformingRandomAccessList<F, T> extends AbstractList<T>
  implements Serializable, RandomAccess
{
  private static final long serialVersionUID;
  final List<F> fromList;
  final Function<? super F, ? extends T> function;

  Lists$TransformingRandomAccessList(List<F> paramList, Function<? super F, ? extends T> paramFunction)
  {
    this.fromList = ((List)Preconditions.checkNotNull(paramList));
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
  }

  public void clear()
  {
    this.fromList.clear();
  }

  public T get(int paramInt)
  {
    return this.function.apply(this.fromList.get(paramInt));
  }

  public boolean isEmpty()
  {
    return this.fromList.isEmpty();
  }

  public T remove(int paramInt)
  {
    return this.function.apply(this.fromList.remove(paramInt));
  }

  public int size()
  {
    return this.fromList.size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Lists.TransformingRandomAccessList
 * JD-Core Version:    0.6.2
 */