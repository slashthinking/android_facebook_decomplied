package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$16 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    String[] arrayOfString1 = PhotosProvider.a();
    for (int j = 0; j < arrayOfString1.length; j++)
      FacebookDatabaseHelper.a(paramSQLiteDatabase, arrayOfString1[j]);
    a("drop tables");
    String[] arrayOfString2 = PhotosProvider.b();
    while (i < arrayOfString2.length)
    {
      paramSQLiteDatabase.execSQL(arrayOfString2[i]);
      i++;
    }
    a("recreate tables");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.16
 * JD-Core Version:    0.6.0
 */