package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.ipc.pages.PagesContract;

final class FacebookDatabaseHelper$14 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    String[] arrayOfString1 = PagesContract.a();
    for (int j = 0; j < arrayOfString1.length; j++)
      FacebookDatabaseHelper.a(paramSQLiteDatabase, arrayOfString1[j]);
    String[] arrayOfString2 = PagesContract.b();
    while (i < arrayOfString2.length)
    {
      paramSQLiteDatabase.execSQL(arrayOfString2[i]);
      i++;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.14
 * JD-Core Version:    0.6.0
 */