package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class Multimaps$Keys$KeysEntrySet extends Multisets.EntrySet<K>
{
  Multimaps$Keys$KeysEntrySet(Multimaps.Keys paramKeys)
  {
  }

  Multiset<K> a()
  {
    return this.a;
  }

  public boolean contains(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof Multiset.Entry))
    {
      Multiset.Entry localEntry = (Multiset.Entry)paramObject;
      Collection localCollection = (Collection)this.a.e().b().get(localEntry.a());
      if ((localCollection != null) && (localCollection.size() == localEntry.b()))
        bool = true;
    }
    while (true)
    {
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }

  public boolean isEmpty()
  {
    return this.a.e().e();
  }

  public Iterator<Multiset.Entry<K>> iterator()
  {
    return this.a.b();
  }

  public boolean remove(Object paramObject)
  {
    if ((paramObject instanceof Multiset.Entry))
    {
      Multiset.Entry localEntry = (Multiset.Entry)paramObject;
      Collection localCollection = (Collection)this.a.e().b().get(localEntry.a());
      if ((localCollection != null) && (localCollection.size() == localEntry.b()))
        localCollection.clear();
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int size()
  {
    return this.a.c();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multimaps.Keys.KeysEntrySet
 * JD-Core Version:    0.6.2
 */