package com.facebook.timeline.cache.ram;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.orca.app.IHaveUserData;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.facebook.timeline.cache.TimelineCachePlan;
import com.facebook.timeline.cache.TimelineCachePlan.Enabled;
import com.facebook.timeline.cache.TimelineClearCacheParams;

public class TimelineCacheServiceHandler
  implements IHaveUserData, OrcaServiceHandler.Filter
{
  private static final Class<?> a = TimelineCacheServiceHandler.class;
  private final TimelineRamCache b;
  private Clock c;

  public TimelineCacheServiceHandler(TimelineRamCache paramTimelineRamCache, Clock paramClock)
  {
    this.b = paramTimelineRamCache;
    this.c = paramClock;
  }

  private int a(OperationParams paramOperationParams)
  {
    if ("fetch_timeline_header".equals(paramOperationParams.a()));
    for (int i = 0; ; i = 10)
      return i;
  }

  private static OperationResult a(Parcelable paramParcelable, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    if ((paramParcelable instanceof FetchParcelableResult));
    for (FetchParcelableResult localFetchParcelableResult = (FetchParcelableResult)paramParcelable; ; localFetchParcelableResult = new FetchParcelableResult(paramParcelable, paramDataFreshnessResult, paramLong))
      return OperationResult.a(localFetchParcelableResult);
  }

  private OperationResult a(OperationResult paramOperationResult, TimelineCachePlan paramTimelineCachePlan)
  {
    Parcelable localParcelable;
    if (paramOperationResult.c())
    {
      localParcelable = paramOperationResult.h();
      if ((localParcelable instanceof FetchParcelableResult))
      {
        FetchParcelableResult localFetchParcelableResult = (FetchParcelableResult)localParcelable;
        TimelineRamCache.CacheEntry localCacheEntry3 = new TimelineRamCache.CacheEntry(localFetchParcelableResult.a, localFetchParcelableResult.f());
        this.b.a(paramTimelineCachePlan, localCacheEntry3);
      }
    }
    while (true)
    {
      return paramOperationResult;
      long l = this.c.a();
      TimelineRamCache.CacheEntry localCacheEntry2 = new TimelineRamCache.CacheEntry(localParcelable, l);
      this.b.a(paramTimelineCachePlan, localCacheEntry2);
      paramOperationResult = a(paramOperationResult.h(), DataFreshnessResult.FROM_SERVER, l);
      continue;
      if (this.b.a(paramTimelineCachePlan) == null)
        continue;
      TimelineRamCache.CacheEntry localCacheEntry1 = this.b.a(paramTimelineCachePlan);
      paramOperationResult = a(localCacheEntry1.a, DataFreshnessResult.FROM_CACHE_STALE, localCacheEntry1.b);
    }
  }

  private OperationResult a(TimelineCachePlan paramTimelineCachePlan)
  {
    TimelineRamCache.CacheEntry localCacheEntry = this.b.a(paramTimelineCachePlan);
    if ((localCacheEntry != null) && (paramTimelineCachePlan.e() == TimelineCachePlan.Enabled.CACHEABLE) && (this.c.a() - localCacheEntry.b <= paramTimelineCachePlan.d()));
    for (OperationResult localOperationResult = a(localCacheEntry.a, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, localCacheEntry.b); ; localOperationResult = null)
      return localOperationResult;
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Process.setThreadPriority(a(paramOperationParams));
    OperationResult localOperationResult;
    if (paramOperationParams.a().equals("clear_cache"))
    {
      TimelineClearCacheParams localTimelineClearCacheParams = (TimelineClearCacheParams)paramOperationParams.b().getParcelable("clearCacheParams");
      this.b.a(localTimelineClearCacheParams);
      if (localTimelineClearCacheParams.b().equals("fetch_timeline_header"))
        localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    }
    while (true)
    {
      return localOperationResult;
      localOperationResult = OperationResult.b();
      continue;
      TimelineCachePlan localTimelineCachePlan = new TimelineCachePlan(paramOperationParams);
      if (localTimelineCachePlan.e() == TimelineCachePlan.Enabled.NOT_CACHEABLE)
      {
        localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
        continue;
      }
      localOperationResult = a(localTimelineCachePlan);
      if (localOperationResult != null)
        continue;
      localOperationResult = a(paramOrcaServiceHandler.a(paramOperationParams), localTimelineCachePlan);
      Process.setThreadPriority(10);
    }
  }

  public void f()
  {
    this.b.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.ram.TimelineCacheServiceHandler
 * JD-Core Version:    0.6.0
 */