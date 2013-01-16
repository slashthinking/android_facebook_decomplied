package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$13 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    String[] arrayOfString1 = MobileEventLogProvider.a();
    int j = arrayOfString1.length;
    for (int k = 0; k < j; k++)
      FacebookDatabaseHelper.a(paramSQLiteDatabase, arrayOfString1[k]);
    String[] arrayOfString2 = MobileEventLogProvider.b();
    int m = arrayOfString2.length;
    while (i < m)
    {
      paramSQLiteDatabase.execSQL(arrayOfString2[i]);
      i++;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.13
 * JD-Core Version:    0.6.0
 */