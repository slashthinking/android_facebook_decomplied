package com.facebook.timeline.cache.db;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class TimelineDbModule$TimelineDbCacheServiceHandlerProvider extends AbstractProvider<TimelineDbCacheServiceHandler>
{
  private TimelineDbModule$TimelineDbCacheServiceHandlerProvider(TimelineDbModule paramTimelineDbModule)
  {
  }

  public TimelineDbCacheServiceHandler a()
  {
    return new TimelineDbCacheServiceHandler((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (TimelineDbCache)b(TimelineDbCache.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbModule.TimelineDbCacheServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */