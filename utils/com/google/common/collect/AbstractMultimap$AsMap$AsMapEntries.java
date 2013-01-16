package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class AbstractMultimap$AsMap$AsMapEntries extends Maps.EntrySet<K, Collection<V>>
{
  AbstractMultimap$AsMap$AsMapEntries(AbstractMultimap.AsMap paramAsMap)
  {
  }

  Map<K, Collection<V>> a()
  {
    return this.a;
  }

  public boolean contains(Object paramObject)
  {
    return Collections2.a(this.a.a.entrySet(), paramObject);
  }

  public Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    return new AbstractMultimap.AsMap.AsMapIterator(this.a);
  }

  public boolean remove(Object paramObject)
  {
    if (!contains(paramObject));
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      Map.Entry localEntry = (Map.Entry)paramObject;
      AbstractMultimap.a(this.a.c, localEntry.getKey());
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.AsMap.AsMapEntries
 * JD-Core Version:    0.6.2
 */