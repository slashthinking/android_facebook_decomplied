package com.google.common.collect;

import java.util.Map.Entry;
import java.util.Set;

abstract class Multimaps$EntrySet<K, V> extends Multimaps.Entries<K, V>
  implements Set<Map.Entry<K, V>>
{
  public boolean equals(Object paramObject)
  {
    return Sets.a(this, paramObject);
  }

  public int hashCode()
  {
    return Sets.a(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multimaps.EntrySet
 * JD-Core Version:    0.6.2
 */