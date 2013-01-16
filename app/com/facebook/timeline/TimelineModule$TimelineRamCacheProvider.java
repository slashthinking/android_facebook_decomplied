package com.facebook.timeline;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.timeline.cache.ram.TimelineRamCache;

class TimelineModule$TimelineRamCacheProvider extends AbstractProvider<TimelineRamCache>
{
  private TimelineModule$TimelineRamCacheProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineRamCache a()
  {
    return new TimelineRamCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineRamCacheProvider
 * JD-Core Version:    0.6.0
 */