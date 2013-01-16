package com.facebook.pages.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.orca.common.util.StringUtil;

public class PageDbOpenHelper extends SQLiteOpenHelper
{
  private static PageDbOpenHelper a;

  public PageDbOpenHelper(Context paramContext)
  {
    super(paramContext, "pages_db", null, 1);
  }

  public static PageDbOpenHelper a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (a != null);
      for (PageDbOpenHelper localPageDbOpenHelper = a; ; localPageDbOpenHelper = a)
      {
        return localPageDbOpenHelper;
        a = new PageDbOpenHelper(paramContext);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String b(String paramString)
  {
    return StringUtil.a("DROP TABLE IF EXISTS %s", new Object[] { paramString });
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    PageDbOpenHelper.PageNotificationsTable.a(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    PageDbOpenHelper.PageNotificationsTable.b(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.db.PageDbOpenHelper
 * JD-Core Version:    0.6.0
 */