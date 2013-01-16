package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$10 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    FacebookDatabaseHelper.a(paramSQLiteDatabase, UserStatusesProvider.a());
    paramSQLiteDatabase.execSQL(UserStatusesProvider.b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.10
 * JD-Core Version:    0.6.0
 */