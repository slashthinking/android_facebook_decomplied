package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Map.Entry;

abstract class Multimaps$Entries<K, V> extends AbstractCollection<Map.Entry<K, V>>
{
  abstract Multimap<K, V> a();

  public void clear()
  {
    a().f();
  }

  public boolean contains(Object paramObject)
  {
    Map.Entry localEntry;
    if ((paramObject instanceof Map.Entry))
      localEntry = (Map.Entry)paramObject;
    for (boolean bool = a().b(localEntry.getKey(), localEntry.getValue()); ; bool = false)
      return bool;
  }

  public boolean remove(Object paramObject)
  {
    Map.Entry localEntry;
    if ((paramObject instanceof Map.Entry))
      localEntry = (Map.Entry)paramObject;
    for (boolean bool = a().c(localEntry.getKey(), localEntry.getValue()); ; bool = false)
      return bool;
  }

  public int size()
  {
    return a().d();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multimaps.Entries
 * JD-Core Version:    0.6.2
 */