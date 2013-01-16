package com.facebook.timeline;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.timeline.cache.ram.TimelineCacheServiceHandler;
import com.facebook.timeline.cache.ram.TimelineRamCache;

class TimelineModule$TimelineCacheServiceHandlerProvider extends AbstractProvider<TimelineCacheServiceHandler>
{
  private TimelineModule$TimelineCacheServiceHandlerProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineCacheServiceHandler a()
  {
    return new TimelineCacheServiceHandler((TimelineRamCache)b(TimelineRamCache.class), (Clock)b(SystemClock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineCacheServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */