package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

class Synchronized$SynchronizedAsMapValues$1 extends ForwardingIterator<Collection<V>>
{
  Synchronized$SynchronizedAsMapValues$1(Synchronized.SynchronizedAsMapValues paramSynchronizedAsMapValues, Iterator paramIterator)
  {
  }

  protected Iterator<Collection<V>> a()
  {
    return this.a;
  }

  public Collection<V> b()
  {
    return Synchronized.a((Collection)this.a.next(), this.b.mutex);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
 * JD-Core Version:    0.6.2
 */