package com.google.common.base;

public final class Functions
{
  public static <E> Function<Object, E> constant(E paramE)
  {
    return new Functions.ConstantFunction(paramE);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Functions
 * JD-Core Version:    0.6.2
 */