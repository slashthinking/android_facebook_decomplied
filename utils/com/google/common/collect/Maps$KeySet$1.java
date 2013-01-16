package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map.Entry;

class Maps$KeySet$1
  implements Function<Map.Entry<K, V>, K>
{
  Maps$KeySet$1(Maps.KeySet paramKeySet)
  {
  }

  public K a(Map.Entry<K, V> paramEntry)
  {
    return paramEntry.getKey();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Maps.KeySet.1
 * JD-Core Version:    0.6.2
 */