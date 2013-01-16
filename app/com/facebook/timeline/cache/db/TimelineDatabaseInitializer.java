package com.facebook.timeline.cache.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.debug.BLog;

public class TimelineDatabaseInitializer
  implements INeedInit
{
  private static final Class<?> a = TimelineDatabaseInitializer.class;
  private TimelineDbCache.OpenHelper b;
  private Context c;

  public TimelineDatabaseInitializer(@FromApplication Context paramContext, TimelineDbCache.OpenHelper paramOpenHelper)
  {
    this.c = paramContext;
    this.b = paramOpenHelper;
  }

  public void i_()
  {
    try
    {
      this.b.getWritableDatabase();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        BLog.e(a, "Timeline database may be corrupted.", localSQLiteException);
        this.c.deleteDatabase("timeline_db");
        this.b.getWritableDatabase();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDatabaseInitializer
 * JD-Core Version:    0.6.0
 */