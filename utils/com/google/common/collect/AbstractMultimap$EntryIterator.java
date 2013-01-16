package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMultimap$EntryIterator
  implements Iterator<Map.Entry<K, V>>
{
  final Iterator<Map.Entry<K, Collection<V>>> a;
  K b;
  Collection<V> c;
  Iterator<V> d;

  AbstractMultimap$EntryIterator(AbstractMultimap paramAbstractMultimap)
  {
    this.a = AbstractMultimap.a(paramAbstractMultimap).entrySet().iterator();
    if (this.a.hasNext())
      a();
    while (true)
    {
      return;
      this.d = Iterators.b();
    }
  }

  void a()
  {
    Map.Entry localEntry = (Map.Entry)this.a.next();
    this.b = localEntry.getKey();
    this.c = ((Collection)localEntry.getValue());
    this.d = this.c.iterator();
  }

  public Map.Entry<K, V> b()
  {
    if (!this.d.hasNext())
      a();
    return Maps.a(this.b, this.d.next());
  }

  public boolean hasNext()
  {
    if ((this.a.hasNext()) || (this.d.hasNext()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void remove()
  {
    this.d.remove();
    if (this.c.isEmpty())
      this.a.remove();
    AbstractMultimap.b(this.e);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap.EntryIterator
 * JD-Core Version:    0.6.2
 */