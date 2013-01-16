package com.google.common.collect;

import java.util.Iterator;

public abstract class ImmutableCollection$Builder<E>
{
  public Builder<E> a(Iterable<? extends E> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      a(localIterator.next());
    return this;
  }

  public abstract Builder<E> a(E paramE);

  public Builder<E> a(Iterator<? extends E> paramIterator)
  {
    while (paramIterator.hasNext())
      a(paramIterator.next());
    return this;
  }

  public Builder<E> a(E[] paramArrayOfE)
  {
    int i = paramArrayOfE.length;
    for (int j = 0; j < i; j++)
      a(paramArrayOfE[j]);
    return this;
  }

  public abstract ImmutableCollection<E> a();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableCollection.Builder
 * JD-Core Version:    0.6.2
 */