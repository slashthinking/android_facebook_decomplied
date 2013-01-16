package com.facebook.timeline.cache.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class TimelineDbModule$TimelineDbCacheProvider extends AbstractProvider<TimelineDbCache>
{
  private TimelineDbModule$TimelineDbCacheProvider(TimelineDbModule paramTimelineDbModule)
  {
  }

  public TimelineDbCache a()
  {
    return new TimelineDbCache((SQLiteDatabase)b(SQLiteDatabase.class, TimelineDb.class), (Clock)b(Clock.class), (ObjectMapper)b(ObjectMapper.class), (UserInteractionController)b(UserInteractionController.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbModule.TimelineDbCacheProvider
 * JD-Core Version:    0.6.0
 */