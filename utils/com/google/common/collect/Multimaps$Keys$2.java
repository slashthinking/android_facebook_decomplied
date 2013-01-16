package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map.Entry;

class Multimaps$Keys$2
  implements Function<Map.Entry<K, V>, K>
{
  Multimaps$Keys$2(Multimaps.Keys paramKeys)
  {
  }

  public K a(Map.Entry<K, V> paramEntry)
  {
    return paramEntry.getKey();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multimaps.Keys.2
 * JD-Core Version:    0.6.2
 */