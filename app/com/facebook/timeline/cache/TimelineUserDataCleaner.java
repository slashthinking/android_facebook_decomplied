package com.facebook.timeline.cache;

import com.facebook.orca.app.IHaveUserData;
import com.facebook.timeline.cache.db.TimelineDatabaseSupplier;
import com.facebook.timeline.cache.ram.TimelineCacheServiceHandler;

public class TimelineUserDataCleaner
  implements IHaveUserData
{
  private final TimelineDatabaseSupplier a;
  private final TimelineCacheServiceHandler b;

  public TimelineUserDataCleaner(TimelineDatabaseSupplier paramTimelineDatabaseSupplier, TimelineCacheServiceHandler paramTimelineCacheServiceHandler)
  {
    this.a = paramTimelineDatabaseSupplier;
    this.b = paramTimelineCacheServiceHandler;
  }

  public void f()
  {
    this.a.f();
    this.b.f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.TimelineUserDataCleaner
 * JD-Core Version:    0.6.0
 */