package com.google.common.base;

import java.util.Collection;

public final class Predicates
{
  private static final Joiner COMMA_JOINER = Joiner.on(",");

  public static <T> Predicate<T> in(Collection<? extends T> paramCollection)
  {
    return new Predicates.InPredicate(paramCollection, null);
  }

  public static <T> Predicate<T> not(Predicate<T> paramPredicate)
  {
    return new Predicates.NotPredicate(paramPredicate);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Predicates
 * JD-Core Version:    0.6.2
 */