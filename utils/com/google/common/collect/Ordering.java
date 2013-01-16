package com.google.common.collect;

import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Ordering<T>
  implements Comparator<T>
{
  public static <T> Ordering<T> a(Comparator<T> paramComparator)
  {
    if ((paramComparator instanceof Ordering));
    for (Object localObject = (Ordering)paramComparator; ; localObject = new ComparatorOrdering(paramComparator))
      return localObject;
  }

  public static <C extends Comparable> Ordering<C> b()
  {
    return NaturalOrdering.a;
  }

  public <S extends T> Ordering<S> a()
  {
    return new ReverseOrdering(this);
  }

  public <F> Ordering<F> a(Function<F, ? extends T> paramFunction)
  {
    return new ByFunctionOrdering(paramFunction, this);
  }

  public <E extends T> List<E> a(Iterable<E> paramIterable)
  {
    ArrayList localArrayList = Lists.a(paramIterable);
    Collections.sort(localArrayList, this);
    return localArrayList;
  }

  public <E extends T> ImmutableList<E> b(Iterable<E> paramIterable)
  {
    return ImmutableList.a(a(paramIterable));
  }

  public abstract int compare(T paramT1, T paramT2);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Ordering
 * JD-Core Version:    0.6.2
 */