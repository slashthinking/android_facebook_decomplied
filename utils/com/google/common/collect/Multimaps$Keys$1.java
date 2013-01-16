package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class Multimaps$Keys$1
  implements Iterator<Multiset.Entry<K>>
{
  Multimaps$Keys$1(Multimaps.Keys paramKeys, Iterator paramIterator)
  {
  }

  public Multiset.Entry<K> a()
  {
    return new Multimaps.Keys.1.1(this, (Map.Entry)this.a.next());
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }

  public void remove()
  {
    this.a.remove();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multimaps.Keys.1
 * JD-Core Version:    0.6.2
 */