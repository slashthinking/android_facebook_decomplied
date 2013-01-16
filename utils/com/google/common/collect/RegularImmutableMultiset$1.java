package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class RegularImmutableMultiset$1 extends UnmodifiableIterator<Multiset.Entry<E>>
{
  RegularImmutableMultiset$1(RegularImmutableMultiset paramRegularImmutableMultiset, Iterator paramIterator)
  {
  }

  public Multiset.Entry<E> a()
  {
    Map.Entry localEntry = (Map.Entry)this.a.next();
    return Multisets.a(localEntry.getKey(), ((Integer)localEntry.getValue()).intValue());
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMultiset.1
 * JD-Core Version:    0.6.2
 */