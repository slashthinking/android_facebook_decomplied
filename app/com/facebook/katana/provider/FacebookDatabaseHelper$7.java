package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.util.Log;

final class FacebookDatabaseHelper$7 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.e("DatabaseHelper", "Creating local photo tag table");
    FacebookDatabaseHelper.a(paramSQLiteDatabase, LocalPhotoTagProvider.a());
    String[] arrayOfString = LocalPhotoTagProvider.b();
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
      paramSQLiteDatabase.execSQL(arrayOfString[j]);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.7
 * JD-Core Version:    0.6.0
 */