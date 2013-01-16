package com.google.common.collect;

import java.util.Map;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$1$1 extends Multisets.AbstractEntry<E>
{
  AbstractMapBasedMultiset$1$1(AbstractMapBasedMultiset.1 param1, Map.Entry paramEntry)
  {
  }

  public E a()
  {
    return this.a.getKey();
  }

  public int b()
  {
    int i = ((Count)this.a.getValue()).a();
    Count localCount;
    if (i == 0)
    {
      localCount = (Count)AbstractMapBasedMultiset.a(this.b.c).get(a());
      if (localCount == null);
    }
    for (int j = localCount.a(); ; j = i)
      return j;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultiset.1.1
 * JD-Core Version:    0.6.2
 */