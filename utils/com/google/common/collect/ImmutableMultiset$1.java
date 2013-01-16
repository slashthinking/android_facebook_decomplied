package com.google.common.collect;

import java.util.Iterator;

class ImmutableMultiset$1 extends UnmodifiableIterator<E>
{
  int a;
  E b;

  ImmutableMultiset$1(ImmutableMultiset paramImmutableMultiset, Iterator paramIterator)
  {
  }

  public boolean hasNext()
  {
    if ((this.a > 0) || (this.c.hasNext()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public E next()
  {
    if (this.a <= 0)
    {
      Multiset.Entry localEntry = (Multiset.Entry)this.c.next();
      this.b = localEntry.a();
      this.a = localEntry.b();
    }
    this.a = (-1 + this.a);
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultiset.1
 * JD-Core Version:    0.6.2
 */