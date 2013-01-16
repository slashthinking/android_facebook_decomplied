package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class Multisets$ImmutableEntry<E> extends Multisets.AbstractEntry<E>
  implements Serializable
{
  private static final long serialVersionUID;
  final int count;
  final E element;

  Multisets$ImmutableEntry(E paramE, int paramInt)
  {
    this.element = paramE;
    this.count = paramInt;
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }

  public E a()
  {
    return this.element;
  }

  public int b()
  {
    return this.count;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multisets.ImmutableEntry
 * JD-Core Version:    0.6.2
 */