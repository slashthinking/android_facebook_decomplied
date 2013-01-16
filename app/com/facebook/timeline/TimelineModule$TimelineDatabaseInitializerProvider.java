package com.facebook.timeline;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.timeline.cache.db.TimelineDatabaseInitializer;
import com.facebook.timeline.cache.db.TimelineDbCache.OpenHelper;

class TimelineModule$TimelineDatabaseInitializerProvider extends AbstractProvider<TimelineDatabaseInitializer>
{
  private TimelineModule$TimelineDatabaseInitializerProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineDatabaseInitializer a()
  {
    return new TimelineDatabaseInitializer(TimelineModule.a(this.a), (TimelineDbCache.OpenHelper)b(TimelineDbCache.OpenHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineDatabaseInitializerProvider
 * JD-Core Version:    0.6.0
 */