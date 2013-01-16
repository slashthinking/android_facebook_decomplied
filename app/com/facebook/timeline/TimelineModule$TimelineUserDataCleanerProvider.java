package com.facebook.timeline;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.facebook.timeline.cache.db.TimelineDatabaseSupplier;
import com.facebook.timeline.cache.ram.TimelineCacheServiceHandler;

class TimelineModule$TimelineUserDataCleanerProvider extends AbstractProvider<TimelineUserDataCleaner>
{
  private TimelineModule$TimelineUserDataCleanerProvider(TimelineModule paramTimelineModule)
  {
  }

  public TimelineUserDataCleaner a()
  {
    return new TimelineUserDataCleaner((TimelineDatabaseSupplier)b(TimelineDatabaseSupplier.class), (TimelineCacheServiceHandler)b(TimelineCacheServiceHandler.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.TimelineUserDataCleanerProvider
 * JD-Core Version:    0.6.0
 */