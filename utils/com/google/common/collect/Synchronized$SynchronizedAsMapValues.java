package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

class Synchronized$SynchronizedAsMapValues<V> extends Synchronized.SynchronizedCollection<Collection<V>>
{
  private static final long serialVersionUID;

  Synchronized$SynchronizedAsMapValues(Collection<Collection<V>> paramCollection, Object paramObject)
  {
    super(paramCollection, paramObject, null);
  }

  public Iterator<Collection<V>> iterator()
  {
    return new Synchronized.SynchronizedAsMapValues.1(this, super.iterator());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMapValues
 * JD-Core Version:    0.6.2
 */