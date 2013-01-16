package com.google.common.collect;

import java.util.Map.Entry;

final class CustomConcurrentHashMap$WriteThroughEntry extends AbstractMapEntry<K, V>
{
  final K a;
  V b;

  CustomConcurrentHashMap$WriteThroughEntry(K paramK, V paramV)
  {
    this.a = paramV;
    Object localObject;
    this.b = localObject;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (bool1)
    {
      Map.Entry localEntry = (Map.Entry)paramObject;
      boolean bool3 = this.a.equals(localEntry.getKey());
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.b.equals(localEntry.getValue());
        bool2 = false;
        if (bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public K getKey()
  {
    return this.a;
  }

  public V getValue()
  {
    return this.b;
  }

  public int hashCode()
  {
    return this.a.hashCode() ^ this.b.hashCode();
  }

  public V setValue(V paramV)
  {
    Object localObject = this.c.put(this.a, paramV);
    this.b = paramV;
    return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.WriteThroughEntry
 * JD-Core Version:    0.6.2
 */