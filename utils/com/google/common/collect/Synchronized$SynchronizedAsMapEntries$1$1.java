package com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1$1 extends ForwardingMapEntry<K, Collection<V>>
{
  Synchronized$SynchronizedAsMapEntries$1$1(Synchronized.SynchronizedAsMapEntries.1 param1, Map.Entry paramEntry)
  {
  }

  protected Map.Entry<K, Collection<V>> a()
  {
    return this.a;
  }

  public Collection<V> b()
  {
    return Synchronized.a((Collection)this.a.getValue(), this.b.b.mutex);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1
 * JD-Core Version:    0.6.2
 */