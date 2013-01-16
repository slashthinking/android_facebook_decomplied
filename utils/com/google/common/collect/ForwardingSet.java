package com.google.common.collect;

import java.util.Set;

public abstract class ForwardingSet<E> extends ForwardingCollection<E>
  implements Set<E>
{
  protected abstract Set<E> a();

  public boolean equals(Object paramObject)
  {
    if ((paramObject == this) || (a().equals(paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    return a().hashCode();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ForwardingSet
 * JD-Core Version:    0.6.2
 */