package com.google.common.base;

public final class Equivalences
{
  public static Equivalence<Object> equals()
  {
    return Equivalences.Equals.INSTANCE;
  }

  public static Equivalence<Object> identity()
  {
    return Equivalences.Identity.INSTANCE;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Equivalences
 * JD-Core Version:    0.6.2
 */