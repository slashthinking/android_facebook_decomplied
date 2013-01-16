package com.facebook.katana.provider;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$21 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("UPDATE cache SET timestamp=0 WHERE name=" + DatabaseUtils.sqlEscapeString("urimap"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.21
 * JD-Core Version:    0.6.0
 */