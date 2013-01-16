package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableSortedMap$3 extends UnmodifiableIterator<V>
{
  ImmutableSortedMap$3(ImmutableSortedMap paramImmutableSortedMap, UnmodifiableIterator paramUnmodifiableIterator)
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
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.3
 * JD-Core Version:    0.6.2
 */