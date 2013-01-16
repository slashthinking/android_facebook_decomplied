package com.facebook.appcenter.workflow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;

public class WorkflowDatabaseHelper extends SQLiteOpenHelper
{
  public WorkflowDatabaseHelper(Context paramContext)
  {
    super(paramContext, "apps.db", null, 1);
  }

  public String a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("appsTable", new String[] { "packageName" }, "_appId=?", new String[] { paramString }, null, null, null);
    boolean bool = localCursor.moveToFirst();
    String str = null;
    if (bool)
      str = localCursor.getString(0);
    localCursor.close();
    localSQLiteDatabase.close();
    return str;
  }

  public void a(String paramString, long paramLong)
  {
    Preconditions.checkNotNull(paramString);
    BLog.a("WorkflowDatabaseHelper", "Set downloadId, appId: " + paramString + ", downloadId: " + paramLong);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("download_id", Long.valueOf(paramLong));
    if (localSQLiteDatabase.update("appsTable", localContentValues, "_appId=" + paramString, null) <= 0)
    {
      localContentValues.put("_appId", paramString);
      localSQLiteDatabase.replace("appsTable", null, localContentValues);
    }
    localSQLiteDatabase.close();
  }

  public void a(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1);
    BLog.a("WorkflowDatabaseHelper", "Set package name, appId: " + paramString1 + ", packageName: " + paramString2);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("packageName", paramString2);
    if (localSQLiteDatabase.update("appsTable", localContentValues, "_appId=" + paramString1, null) <= 0)
    {
      localContentValues.put("_appId", paramString1);
      localSQLiteDatabase.replace("appsTable", null, localContentValues);
    }
    localSQLiteDatabase.close();
  }

  public long b(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("appsTable", new String[] { "download_id" }, "_appId=?", new String[] { paramString }, null, null, null);
    long l;
    if (localCursor.moveToFirst())
      l = localCursor.getLong(0);
    while (true)
    {
      localCursor.close();
      localSQLiteDatabase.close();
      return l;
      l = -1L;
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table appsTable(_appId text primary key, packageName text, download_id integer);");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    BLog.a("WorkflowDatabaseHelper", "Upgrading database from version " + paramInt1 + " to " + paramInt2);
    paramSQLiteDatabase.execSQL("drop table if exists apps.db");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.WorkflowDatabaseHelper
 * JD-Core Version:    0.6.0
 */