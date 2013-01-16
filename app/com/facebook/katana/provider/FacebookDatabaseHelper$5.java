package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.util.Log;

final class FacebookDatabaseHelper$5 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.e("DatabaseHelper", "Creating vault images table!");
    FacebookDatabaseHelper.a(paramSQLiteDatabase, VaultImageProvider.a());
    String[] arrayOfString = VaultImageProvider.b();
    for (int i = 0; i < arrayOfString.length; i++)
      paramSQLiteDatabase.execSQL(arrayOfString[i]);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.5
 * JD-Core Version:    0.6.0
 */