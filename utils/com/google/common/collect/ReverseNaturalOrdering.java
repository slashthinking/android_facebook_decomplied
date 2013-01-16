package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ReverseNaturalOrdering extends Ordering<Comparable>
  implements Serializable
{
  static final ReverseNaturalOrdering a = new ReverseNaturalOrdering();
  private static final long serialVersionUID;

  private Object readResolve()
  {
    return a;
  }

  public int a(Comparable paramComparable1, Comparable paramComparable2)
  {
    Preconditions.checkNotNull(paramComparable1);
    if (paramComparable1 == paramComparable2);
    for (int i = 0; ; i = paramComparable2.compareTo(paramComparable1))
      return i;
  }

  public <S extends Comparable> Ordering<S> a()
  {
    return Ordering.b();
  }

  public String toString()
  {
    return "Ordering.natural().reverse()";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ReverseNaturalOrdering
 * JD-Core Version:    0.6.2
 */