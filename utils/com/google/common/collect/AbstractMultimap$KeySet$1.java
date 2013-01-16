package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMultimap$KeySet$1
  implements Iterator<K>
{
  final Iterator<Map.Entry<K, Collection<V>>> a = this.c.a.entrySet().iterator();
  Map.Entry<K, Collection<V>> b;

  AbstractMultimap$KeySet$1(AbstractMultimap.KeySet paramKeySet)
  {
  }

  public boolean hasNext()
  {
    return this.a.hasNext();
  }

  public K next()
  {
    this.b = ((Map.Entry)this.a.next());
    return this.b.getKey();
  }

  public void remove()
  {
    if (this.b != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      Collection localCollection = (Collection)this.b.getValue();
      this.a.remove();
      AbstractMultimap.b(this.c.b, localCollection.size());
      localCollection.clear();
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.KeySet.1
 * JD-Core Version:    0.6.2
 */