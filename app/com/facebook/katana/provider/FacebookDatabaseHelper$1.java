package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$1 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    FacebookDatabaseHelper.a(paramSQLiteDatabase, UserValuesProvider.a());
    paramSQLiteDatabase.execSQL(UserValuesProvider.b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.1
 * JD-Core Version:    0.6.0
 */