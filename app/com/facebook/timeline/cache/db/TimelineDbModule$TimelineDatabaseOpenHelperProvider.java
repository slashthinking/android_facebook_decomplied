package com.facebook.timeline.cache.db;

import com.facebook.orca.inject.AbstractProvider;

class TimelineDbModule$TimelineDatabaseOpenHelperProvider extends AbstractProvider<TimelineDbCache.OpenHelper>
{
  private TimelineDbModule$TimelineDatabaseOpenHelperProvider(TimelineDbModule paramTimelineDbModule)
  {
  }

  public TimelineDbCache.OpenHelper a()
  {
    return new TimelineDbCache.OpenHelper(TimelineDbModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbModule.TimelineDatabaseOpenHelperProvider
 * JD-Core Version:    0.6.0
 */