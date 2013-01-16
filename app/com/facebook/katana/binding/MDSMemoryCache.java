package com.facebook.katana.binding;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MDSMemoryCache<K, V>
{
  private static long b = -1L;
  protected Map<K, MDSMemoryCache.MemoryStoreEntry<V>> a = Maps.a();

  MDSMemoryCache.MemoryStoreEntry<V> a(K paramK)
  {
    monitorenter;
    try
    {
      MDSMemoryCache.MemoryStoreEntry localMemoryStoreEntry = (MDSMemoryCache.MemoryStoreEntry)this.a.get(paramK);
      monitorexit;
      return localMemoryStoreEntry;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a()
  {
    monitorenter;
    try
    {
      this.a.clear();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(long paramLong)
  {
    monitorenter;
    try
    {
      long l = System.currentTimeMillis() - 1000L * paramLong;
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        if (((MDSMemoryCache.MemoryStoreEntry)((Map.Entry)localIterator.next()).getValue()).b >= l)
          continue;
        localIterator.remove();
      }
    }
    finally
    {
      monitorexit;
    }
  }

  void a(K paramK, V paramV, long paramLong)
  {
    monitorenter;
    try
    {
      this.a.put(paramK, new MDSMemoryCache.MemoryStoreEntry(paramV, paramLong));
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void b()
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.a.values().iterator();
      if (localIterator.hasNext())
        ((MDSMemoryCache.MemoryStoreEntry)localIterator.next()).a();
    }
    finally
    {
      monitorexit;
    }
  }

  void b(K paramK)
  {
    monitorenter;
    try
    {
      this.a.remove(paramK);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.MDSMemoryCache
 * JD-Core Version:    0.6.0
 */