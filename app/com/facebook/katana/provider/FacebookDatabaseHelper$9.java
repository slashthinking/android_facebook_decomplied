package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.util.Log;

final class FacebookDatabaseHelper$9 extends FacebookDatabaseHelper.DatabaseUpdater
{
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.e("DatabaseHelper", "Creating detected photos table");
    FacebookDatabaseHelper.a(paramSQLiteDatabase, DetectedPhotoProvider.a());
    String[] arrayOfString = DetectedPhotoProvider.b();
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
      paramSQLiteDatabase.execSQL(arrayOfString[j]);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.9
 * JD-Core Version:    0.6.0
 */