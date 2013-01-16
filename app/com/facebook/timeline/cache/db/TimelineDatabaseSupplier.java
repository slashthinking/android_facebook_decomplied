package com.facebook.timeline.cache.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.app.IHaveUserData;
import com.google.common.base.Supplier;

public class TimelineDatabaseSupplier
  implements IHaveUserData, Supplier<SQLiteDatabase>
{
  private final TimelineDbCache.OpenHelper a;
  private SQLiteDatabase b;

  public TimelineDatabaseSupplier(TimelineDbCache.OpenHelper paramOpenHelper)
  {
    this.a = paramOpenHelper;
    this.b = null;
  }

  public SQLiteDatabase a()
  {
    monitorenter;
    try
    {
      if (this.b == null)
        this.b = this.a.getWritableDatabase();
      SQLiteDatabase localSQLiteDatabase = this.b;
      monitorexit;
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void f()
  {
    monitorenter;
    try
    {
      this.a.a(a());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDatabaseSupplier
 * JD-Core Version:    0.6.0
 */