package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

class Lists$TransformingSequentialList<F, T> extends AbstractSequentialList<T>
  implements Serializable
{
  private static final long serialVersionUID;
  final List<F> fromList;
  final Function<? super F, ? extends T> function;

  Lists$TransformingSequentialList(List<F> paramList, Function<? super F, ? extends T> paramFunction)
  {
    this.fromList = ((List)Preconditions.checkNotNull(paramList));
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
  }

  public void clear()
  {
    this.fromList.clear();
  }

  public ListIterator<T> listIterator(int paramInt)
  {
    return new Lists.TransformingSequentialList.1(this, this.fromList.listIterator(paramInt));
  }

  public int size()
  {
    return this.fromList.size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Lists.TransformingSequentialList
 * JD-Core Version:    0.6.2
 */