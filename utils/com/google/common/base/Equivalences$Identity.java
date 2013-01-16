package com.google.common.base;

import java.io.Serializable;

final class Equivalences$Identity extends Equivalence<Object>
  implements Serializable
{
  static final Identity INSTANCE = new Identity();
  private static final long serialVersionUID = 1L;

  private Object readResolve()
  {
    return INSTANCE;
  }

  protected boolean doEquivalent(Object paramObject1, Object paramObject2)
  {
    return false;
  }

  protected int doHash(Object paramObject)
  {
    return System.identityHashCode(paramObject);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Equivalences.Identity
 * JD-Core Version:    0.6.2
 */