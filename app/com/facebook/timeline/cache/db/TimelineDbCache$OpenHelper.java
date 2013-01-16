package com.facebook.timeline.cache.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.orca.common.util.StringUtil;

public class TimelineDbCache$OpenHelper extends SQLiteOpenHelper
{
  public TimelineDbCache$OpenHelper(Context paramContext)
  {
    super(paramContext, "timeline_db", null, 12);
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    monitorenter;
    try
    {
      paramSQLiteDatabase.delete("header", null, null);
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

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(StringUtil.a("CREATE TABLE %s (%s)", new Object[] { "header", "cachekey TEXT PRIMARY KEY, timestamp INT64, data TEXT" }));
    paramSQLiteDatabase.setMaximumSize(Math.min(paramSQLiteDatabase.getMaximumSize(), TimelineDbCache.a));
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS header");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbCache.OpenHelper
 * JD-Core Version:    0.6.0
 */