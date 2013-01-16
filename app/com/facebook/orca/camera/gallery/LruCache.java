package com.facebook.orca.camera.gallery;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class LruCache<K, V>
{
  private final HashMap<K, V> a;
  private final HashMap<K, LruCache.Entry<K, V>> b = new HashMap();
  private ReferenceQueue<V> c = new ReferenceQueue();

  public LruCache(int paramInt)
  {
    this.a = new LruCache.1(this, 16, 0.75F, true, paramInt);
  }

  private void b()
  {
    for (LruCache.Entry localEntry = (LruCache.Entry)this.c.poll(); localEntry != null; localEntry = (LruCache.Entry)this.c.poll())
      this.b.remove(localEntry.a);
  }

  public V a(K paramK)
  {
    monitorenter;
    try
    {
      b();
      Object localObject2 = this.a.get(paramK);
      Object localObject3 = localObject2;
      if (localObject3 != null);
      while (true)
      {
        return localObject3;
        LruCache.Entry localEntry = (LruCache.Entry)this.b.get(paramK);
        if (localEntry == null)
        {
          localObject3 = null;
          continue;
        }
        Object localObject4 = localEntry.get();
        localObject3 = localObject4;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public V a(K paramK, V paramV)
  {
    monitorenter;
    try
    {
      b();
      this.a.put(paramK, paramV);
      LruCache.Entry localEntry = (LruCache.Entry)this.b.put(paramK, new LruCache.Entry(paramK, paramV, this.c));
      if (localEntry == null);
      Object localObject2;
      for (Object localObject3 = null; ; localObject3 = localObject2)
      {
        return localObject3;
        localObject2 = localEntry.get();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public void a()
  {
    monitorenter;
    try
    {
      this.a.clear();
      this.b.clear();
      this.c = new ReferenceQueue();
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
 * Qualified Name:     com.facebook.orca.camera.gallery.LruCache
 * JD-Core Version:    0.6.0
 */