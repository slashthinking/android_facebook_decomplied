package com.facebook.katana.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MediaUploadWorker$DbOpenHelper extends SQLiteOpenHelper
{
  MediaUploadWorker$DbOpenHelper(MediaUploadWorker paramMediaUploadWorker, Context paramContext)
  {
    super(paramContext, "uploadmanager.db", null, 16);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE pendingphotos(_id INTEGER PRIMARY KEY AUTOINCREMENT, albumId TEXT, caption TEXT, filename TEXT, profileId INTEGER, checkinId INTEGER, publish INTEGER, tags TEXT, place INTEGER, target_id INTEGER, privacy TEXT, title TEXT, type TEXT, retry_attempt INTEGER, retry_time INTEGER,logging_id STRING)");
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS pendingphotos");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.MediaUploadWorker.DbOpenHelper
 * JD-Core Version:    0.6.0
 */