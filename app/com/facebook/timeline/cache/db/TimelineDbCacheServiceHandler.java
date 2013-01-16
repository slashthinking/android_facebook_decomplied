package com.facebook.timeline.cache.db;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.facebook.timeline.cache.TimelineCachePlan;
import com.facebook.timeline.cache.TimelineCachePlan.Enabled;
import com.facebook.timeline.cache.TimelineClearCacheParams;

public class TimelineDbCacheServiceHandler
  implements OrcaServiceHandler.Filter
{
  private OrcaSharedPreferences a;
  private TimelineDbCache b;
  private Clock c;

  public TimelineDbCacheServiceHandler(OrcaSharedPreferences paramOrcaSharedPreferences, TimelineDbCache paramTimelineDbCache, Clock paramClock)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = paramTimelineDbCache;
    this.c = paramClock;
  }

  private OperationResult a(OperationParams paramOperationParams)
  {
    TimelineClearCacheParams localTimelineClearCacheParams = (TimelineClearCacheParams)paramOperationParams.b().getParcelable("clearCacheParams");
    if (localTimelineClearCacheParams.b().equals("fetch_timeline_header"))
      this.b.a(TimelineCachePlan.a(localTimelineClearCacheParams.a()));
    return OperationResult.b();
  }

  private OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler, String paramString)
  {
    OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
    if (localOperationResult.c())
    {
      Parcelable localParcelable = localOperationResult.h();
      if (paramString != null)
        this.b.a(paramString, localParcelable);
      localOperationResult = OperationResult.a(new FetchParcelableResult(localParcelable, DataFreshnessResult.FROM_SERVER, this.c.a()));
    }
    return localOperationResult;
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    Object localObject2;
    if ("clear_cache".equals(str))
      localObject2 = a(paramOperationParams);
    while (true)
    {
      return localObject2;
      TimelineCachePlan localTimelineCachePlan = new TimelineCachePlan(paramOperationParams);
      if (localTimelineCachePlan.e() == TimelineCachePlan.Enabled.NOT_CACHEABLE)
      {
        localObject2 = paramOrcaServiceHandler.a(paramOperationParams);
        continue;
      }
      if ((this.a != null) && (!this.a.a(FeedPrefKeys.d, true)))
      {
        localObject2 = a(paramOperationParams, paramOrcaServiceHandler, null);
        continue;
      }
      if (!"fetch_timeline_header".equals(str))
      {
        localObject2 = a(paramOperationParams, paramOrcaServiceHandler, null);
        continue;
      }
      Tracer localTracer = Tracer.a("TimelineDbCacheServiceHandler.handleFetchHeader");
      try
      {
        if (localTimelineCachePlan.e() == TimelineCachePlan.Enabled.CACHEABLE)
        {
          FetchParcelableResult localFetchParcelableResult2 = this.b.a(localTimelineCachePlan);
          if ((localFetchParcelableResult2 != null) && (localFetchParcelableResult2.e() != DataFreshnessResult.FROM_CACHE_STALE))
          {
            OperationResult localOperationResult3 = OperationResult.a(localFetchParcelableResult2);
            localObject2 = localOperationResult3;
            localTracer.a();
            continue;
          }
          localObject2 = a(paramOperationParams, paramOrcaServiceHandler, localTimelineCachePlan.a());
          if ((!((OperationResult)localObject2).c()) && (localFetchParcelableResult2 != null))
          {
            localFetchParcelableResult2.a(((OperationResult)localObject2).e());
            OperationResult localOperationResult2 = OperationResult.a(localFetchParcelableResult2);
            localObject2 = localOperationResult2;
            localTracer.a();
            continue;
          }
          localTracer.a();
          continue;
        }
        localObject2 = a(paramOperationParams, paramOrcaServiceHandler, localTimelineCachePlan.a());
        if (!((OperationResult)localObject2).c())
        {
          FetchParcelableResult localFetchParcelableResult1 = this.b.a(localTimelineCachePlan);
          if (localFetchParcelableResult1 != null)
          {
            localFetchParcelableResult1.a(((OperationResult)localObject2).e());
            OperationResult localOperationResult1 = OperationResult.a(localFetchParcelableResult1);
            localObject2 = localOperationResult1;
            localTracer.a();
            continue;
          }
        }
        localTracer.a();
        continue;
      }
      finally
      {
        localTracer.a();
      }
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbCacheServiceHandler
 * JD-Core Version:    0.6.0
 */