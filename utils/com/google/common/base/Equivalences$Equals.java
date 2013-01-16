package com.google.common.base;

import java.io.Serializable;

final class Equivalences$Equals extends Equivalence<Object>
  implements Serializable
{
  static final Equals INSTANCE = new Equals();
  private static final long serialVersionUID = 1L;

  private Object readResolve()
  {
    return INSTANCE;
  }

  protected boolean doEquivalent(Object paramObject1, Object paramObject2)
  {
    return paramObject1.equals(paramObject2);
  }

  public int doHash(Object paramObject)
  {
    return paramObject.hashCode();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Equivalences.Equals
 * JD-Core Version:    0.6.2
 */