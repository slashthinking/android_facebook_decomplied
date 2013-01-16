package com.facebook.timeline.cache.db;

import com.facebook.orca.inject.AbstractProvider;

class TimelineDbModule$TimelineDatabaseSupplierProvider extends AbstractProvider<TimelineDatabaseSupplier>
{
  private TimelineDbModule$TimelineDatabaseSupplierProvider(TimelineDbModule paramTimelineDbModule)
  {
  }

  public TimelineDatabaseSupplier a()
  {
    return new TimelineDatabaseSupplier((TimelineDbCache.OpenHelper)b(TimelineDbCache.OpenHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbModule.TimelineDatabaseSupplierProvider
 * JD-Core Version:    0.6.0
 */