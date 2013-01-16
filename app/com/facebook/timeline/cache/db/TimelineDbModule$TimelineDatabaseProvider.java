package com.facebook.timeline.cache.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.inject.AbstractProvider;

class TimelineDbModule$TimelineDatabaseProvider extends AbstractProvider<SQLiteDatabase>
{
  private TimelineDbModule$TimelineDatabaseProvider(TimelineDbModule paramTimelineDbModule)
  {
  }

  public SQLiteDatabase a()
  {
    return ((TimelineDatabaseSupplier)b(TimelineDatabaseSupplier.class)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbModule.TimelineDatabaseProvider
 * JD-Core Version:    0.6.0
 */