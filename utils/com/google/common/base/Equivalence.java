package com.google.common.base;

public abstract class Equivalence<T>
{
  protected abstract boolean doEquivalent(T paramT1, T paramT2);

  protected abstract int doHash(T paramT);

  public final boolean equivalent(T paramT1, T paramT2)
  {
    boolean bool;
    if (paramT1 == paramT2)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramT1 == null) || (paramT2 == null))
        bool = false;
      else
        bool = doEquivalent(paramT1, paramT2);
    }
  }

  public final int hash(T paramT)
  {
    if (paramT == null);
    for (int i = 0; ; i = doHash(paramT))
      return i;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Equivalence
 * JD-Core Version:    0.6.2
 */