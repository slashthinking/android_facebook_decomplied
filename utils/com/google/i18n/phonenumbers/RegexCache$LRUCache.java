package com.google.i18n.phonenumbers;

import java.util.LinkedHashMap;

class RegexCache$LRUCache<K, V>
{
  private LinkedHashMap<K, V> map;
  private int size;

  public RegexCache$LRUCache(int paramInt)
  {
    this.size = paramInt;
    this.map = new RegexCache.LRUCache.1(this, 1 + paramInt * 4 / 3, 0.75F, true);
  }

  public V get(K paramK)
  {
    try
    {
      Object localObject2 = this.map.get(paramK);
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  public void put(K paramK, V paramV)
  {
    try
    {
      this.map.put(paramK, paramV);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.RegexCache.LRUCache
 * JD-Core Version:    0.6.2
 */