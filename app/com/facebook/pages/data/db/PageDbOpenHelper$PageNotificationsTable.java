package com.facebook.pages.data.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.pages.data.provider.PageNotificationsProvider;

public final class PageDbOpenHelper$PageNotificationsTable
{
  private static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(PageNotificationsProvider.b());
  }

  private static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(PageDbOpenHelper.a(PageNotificationsProvider.a()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.db.PageDbOpenHelper.PageNotificationsTable
 * JD-Core Version:    0.6.0
 */