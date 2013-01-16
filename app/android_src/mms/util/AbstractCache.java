package android_src.mms.util;

import java.util.HashMap;

public abstract class AbstractCache<K, V>
{
  private final HashMap<K, AbstractCache.CacheEntry<V>> a = new HashMap();

  public V a(K paramK)
  {
    AbstractCache.CacheEntry localCacheEntry;
    if (paramK != null)
    {
      localCacheEntry = (AbstractCache.CacheEntry)this.a.get(paramK);
      if (localCacheEntry != null)
        localCacheEntry.a = (1 + localCacheEntry.a);
    }
    for (Object localObject = localCacheEntry.b; ; localObject = null)
      return localObject;
  }

  public void a()
  {
    this.a.clear();
  }

  public boolean a(K paramK, V paramV)
  {
    int i = this.a.size();
    int j = 0;
    if (i >= 500);
    while (true)
    {
      return j;
      j = 0;
      if (paramK == null)
        continue;
      AbstractCache.CacheEntry localCacheEntry = new AbstractCache.CacheEntry(null);
      localCacheEntry.b = paramV;
      this.a.put(paramK, localCacheEntry);
      j = 1;
    }
  }

  public V b(K paramK)
  {
    AbstractCache.CacheEntry localCacheEntry = (AbstractCache.CacheEntry)this.a.remove(paramK);
    if (localCacheEntry != null);
    for (Object localObject = localCacheEntry.b; ; localObject = null)
      return localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.AbstractCache
 * JD-Core Version:    0.6.0
 */