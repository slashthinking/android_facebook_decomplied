package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMultimap$AsMap$AsMapIterator
  implements Iterator<Map.Entry<K, Collection<V>>>
{
  final Iterator<Map.Entry<K, Collection<V>>> a = this.c.a.entrySet().iterator();
  Collection<V> b;

  AbstractMultimap$AsMap$AsMapIterator(AbstractMultimap.AsMap paramAsMap)
  {
  }

  public Map.Entry<K, Collection<V>> a()
  {
    Map.Entry localEntry = (Map.Entry)this.a.next();
    Object localObject = localEntry.getKey();
    this.b = ((Collection)localEntry.getValue());
    return Maps.a(localObject, AbstractMultimap.a(this.c.c, localObject, this.b));
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }

  public void remove()
  {
    this.a.remove();
    AbstractMultimap.b(this.c.c, this.b.size());
    this.b.clear();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.AsMap.AsMapIterator
 * JD-Core Version:    0.6.2
 */