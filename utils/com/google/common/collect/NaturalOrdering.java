package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class NaturalOrdering extends Ordering<Comparable>
  implements Serializable
{
  static final NaturalOrdering a = new NaturalOrdering();
  private static final long serialVersionUID;

  private Object readResolve()
  {
    return a;
  }

  public int a(Comparable paramComparable1, Comparable paramComparable2)
  {
    Preconditions.checkNotNull(paramComparable2);
    if (paramComparable1 == paramComparable2);
    for (int i = 0; ; i = paramComparable1.compareTo(paramComparable2))
      return i;
  }

  public <S extends Comparable> Ordering<S> a()
  {
    return ReverseNaturalOrdering.a;
  }

  public <E extends Comparable> List<E> a(Iterable<E> paramIterable)
  {
    ArrayList localArrayList = Lists.a(paramIterable);
    Collections.sort(localArrayList);
    return localArrayList;
  }

  public String toString()
  {
    return "Ordering.natural()";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.NaturalOrdering
 * JD-Core Version:    0.6.2
 */