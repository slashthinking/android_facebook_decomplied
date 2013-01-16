package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMultimap$Values$1 extends UnmodifiableIterator<V>
{
  ImmutableMultimap$Values$1(ImmutableMultimap.Values paramValues, Iterator paramIterator)
  {
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }

  public V next()
  {
    return ((Map.Entry)this.a.next()).getValue();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultimap.Values.1
 * JD-Core Version:    0.6.2
 */