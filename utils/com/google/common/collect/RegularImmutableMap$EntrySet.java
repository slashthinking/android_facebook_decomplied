package com.google.common.collect;

import java.util.Map.Entry;

class RegularImmutableMap$EntrySet<K, V> extends ImmutableSet.ArrayImmutableSet<Map.Entry<K, V>>
{
  final transient RegularImmutableMap<K, V> b;

  RegularImmutableMap$EntrySet(RegularImmutableMap<K, V> paramRegularImmutableMap)
  {
    super(RegularImmutableMap.a(paramRegularImmutableMap));
    this.b = paramRegularImmutableMap;
  }

  public boolean contains(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (bool1)
    {
      Map.Entry localEntry = (Map.Entry)paramObject;
      Object localObject = this.b.get(localEntry.getKey());
      bool2 = false;
      if (localObject != null)
      {
        boolean bool3 = localObject.equals(localEntry.getValue());
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
    }
    return bool2;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMap.EntrySet
 * JD-Core Version:    0.6.2
 */