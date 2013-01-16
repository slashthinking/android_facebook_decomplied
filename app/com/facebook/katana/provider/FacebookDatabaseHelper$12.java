package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;

final class FacebookDatabaseHelper$12 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    String[] arrayOfString1 = ConnectionsProvider.a();
    for (int j = 0; j < arrayOfString1.length; j++)
      FacebookDatabaseHelper.a(paramSQLiteDatabase, arrayOfString1[j]);
    String[] arrayOfString2 = ConnectionsProvider.b();
    for (int k = 0; k < arrayOfString2.length; k++)
      FacebookDatabaseHelper.a(paramSQLiteDatabase, arrayOfString2[k]);
    String[] arrayOfString3 = ConnectionsProvider.c();
    while (i < arrayOfString3.length)
    {
      paramSQLiteDatabase.execSQL(arrayOfString3[i]);
      i++;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.12
 * JD-Core Version:    0.6.0
 */