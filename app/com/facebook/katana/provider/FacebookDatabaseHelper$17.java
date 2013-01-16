package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$17 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    String[] arrayOfString1 = LoggingProvider.a();
    for (int j = 0; j < arrayOfString1.length; j++)
      FacebookDatabaseHelper.a(paramSQLiteDatabase, arrayOfString1[j]);
    String[] arrayOfString2 = LoggingProvider.b();
    while (i < arrayOfString2.length)
    {
      paramSQLiteDatabase.execSQL(arrayOfString2[i]);
      i++;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.17
 * JD-Core Version:    0.6.0
 */