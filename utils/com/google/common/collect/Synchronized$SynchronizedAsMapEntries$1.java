package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1 extends ForwardingIterator<Map.Entry<K, Collection<V>>>
{
  Synchronized$SynchronizedAsMapEntries$1(Synchronized.SynchronizedAsMapEntries paramSynchronizedAsMapEntries, Iterator paramIterator)
  {
  }

  protected Iterator<Map.Entry<K, Collection<V>>> a()
  {
    return this.a;
  }

  public Map.Entry<K, Collection<V>> b()
  {
    return new Synchronized.SynchronizedAsMapEntries.1.1(this, (Map.Entry)this.a.next());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
 * JD-Core Version:    0.6.2
 */