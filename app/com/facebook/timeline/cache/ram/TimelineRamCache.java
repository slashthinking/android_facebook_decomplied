package com.facebook.timeline.cache.ram;

import com.facebook.timeline.cache.TimelineCachePlan;
import com.facebook.timeline.cache.TimelineClearCacheParams;
import java.util.Hashtable;

public class TimelineRamCache
{
  private Hashtable<String, Hashtable<String, TimelineRamCache.CacheEntry>> a = new Hashtable();
  private final int b = 30;

  private static String a(String paramString, long paramLong)
  {
    return paramString + ":" + String.valueOf(paramLong);
  }

  public TimelineRamCache.CacheEntry a(TimelineCachePlan paramTimelineCachePlan)
  {
    monitorenter;
    try
    {
      String str = a(paramTimelineCachePlan.c(), paramTimelineCachePlan.b());
      boolean bool = this.a.containsKey(str);
      if (!bool);
      for (TimelineRamCache.CacheEntry localCacheEntry = null; ; localCacheEntry = (TimelineRamCache.CacheEntry)((Hashtable)this.a.get(str)).get(paramTimelineCachePlan.a()))
        return localCacheEntry;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a()
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

  public void a(TimelineCachePlan paramTimelineCachePlan, TimelineRamCache.CacheEntry paramCacheEntry)
  {
    monitorenter;
    try
    {
      if (this.a.size() > 30)
        this.a.clear();
      String str = a(paramTimelineCachePlan.c(), paramTimelineCachePlan.b());
      if (!this.a.containsKey(str))
        this.a.put(str, new Hashtable());
      ((Hashtable)this.a.get(str)).put(paramTimelineCachePlan.a(), paramCacheEntry);
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

  public void a(TimelineClearCacheParams paramTimelineClearCacheParams)
  {
    monitorenter;
    try
    {
      String str = a(paramTimelineClearCacheParams.b(), paramTimelineClearCacheParams.a());
      boolean bool = this.a.containsKey(str);
      if (!bool);
      while (true)
      {
        return;
        this.a.remove(str);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.ram.TimelineRamCache
 * JD-Core Version:    0.6.0
 */