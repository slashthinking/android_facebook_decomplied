package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMultimap$EntryCollection$1 extends UnmodifiableIterator<Map.Entry<K, V>>
{
  K a;
  Iterator<V> b;

  ImmutableMultimap$EntryCollection$1(ImmutableMultimap.EntryCollection paramEntryCollection, Iterator paramIterator)
  {
  }

  public Map.Entry<K, V> a()
  {
    if ((this.a == null) || (!this.b.hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)this.c.next();
      this.a = localEntry.getKey();
      this.b = ((ImmutableCollection)localEntry.getValue()).b();
    }
    return Maps.a(this.a, this.b.next());
  }

  public boolean hasNext()
  {
    if (((this.a != null) && (this.b.hasNext())) || (this.c.hasNext()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultimap.EntryCollection.1
 * JD-Core Version:    0.6.2
 */