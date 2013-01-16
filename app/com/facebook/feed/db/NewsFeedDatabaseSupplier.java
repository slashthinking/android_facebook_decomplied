package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.base.Supplier;

public class NewsFeedDatabaseSupplier
  implements Supplier<SQLiteDatabase>
{
  private final NewsFeedDbOpenHelper a;
  private SQLiteDatabase b;

  public NewsFeedDatabaseSupplier(NewsFeedDbOpenHelper paramNewsFeedDbOpenHelper)
  {
    this.a = paramNewsFeedDbOpenHelper;
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

  public void b()
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
 * Qualified Name:     com.facebook.feed.db.NewsFeedDatabaseSupplier
 * JD-Core Version:    0.6.0
 */