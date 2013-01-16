package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$20 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("UPDATE connections SET hash=0");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.20
 * JD-Core Version:    0.6.0
 */