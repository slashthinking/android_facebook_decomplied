package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.base.BuildConstants;
import com.facebook.content.SecureContentProvider;
import java.util.HashMap;

public class LoggingProvider extends SecureContentProvider
{
  public static final Uri a;
  public static final Uri b;
  public static final HashMap<String, String> c;
  private static final String d = BuildConstants.b() + ".provider.LoggingProvider";
  private static final String e = "content://" + d + "/" + "perf_sessions";
  private static final UriMatcher f;
  private FacebookDatabaseHelper g;

  static
  {
    a = Uri.parse(e);
    b = Uri.parse(e + "/sid");
    f = new UriMatcher(-1);
    f.addURI(d, "perf_sessions", 1);
    f.addURI(d, "perf_sessions/#", 2);
    c = new HashMap();
    c.put("session_id", "session_id");
    c.put("start_time", "start_time");
    c.put("end_time", "end_time");
    c.put("api_log", "api_log");
  }

  static String[] a()
  {
    return new String[] { "perf_sessions" };
  }

  private int b(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = 0;
    int j = paramArrayOfContentValues.length;
    for (int k = 0; k < j; k++)
    {
      ContentValues localContentValues = paramArrayOfContentValues[k];
      if (this.g.getWritableDatabase().insert("perf_sessions", "session_id", localContentValues) <= 0L)
        continue;
      i++;
    }
    if (i > 0)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
    }
    throw new SQLException("Failed to insert rows into " + paramUri);
  }

  private Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    long l = this.g.getWritableDatabase().insert("perf_sessions", "session_id", paramContentValues);
    if (l > 0L)
    {
      Uri localUri = Uri.withAppendedPath(a, Long.valueOf(l).toString());
      getContext().getContentResolver().notifyChange(paramUri, null);
      return localUri;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  static String[] b()
  {
    return new String[] { "CREATE TABLE perf_sessions (_id INTEGER PRIMARY KEY,session_id INT,start_time INT,end_time INT,api_log TEXT);" };
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.g.getWritableDatabase();
    switch (f.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    }
    int i = localSQLiteDatabase.update("perf_sessions", paramContentValues, paramString, paramArrayOfString);
    if (i > 0)
      getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.g.getWritableDatabase();
    switch (f.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    }
    int i = localSQLiteDatabase.delete("perf_sessions", paramString, paramArrayOfString);
    if (i > 0)
      getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    switch (f.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    }
    return b(paramUri, paramArrayOfContentValues);
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    switch (f.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    }
    localSQLiteQueryBuilder.setTables("perf_sessions");
    localSQLiteQueryBuilder.setProjectionMap(c);
    Cursor localCursor = localSQLiteQueryBuilder.query(this.g.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, "session_id ASC");
    localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
    return localCursor;
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues != null);
    for (ContentValues localContentValues = new ContentValues(paramContentValues); ; localContentValues = new ContentValues())
      switch (f.match(paramUri))
      {
      default:
        throw new IllegalArgumentException("Unknown URL " + paramUri);
      case 1:
      }
    return b(paramUri, localContentValues);
  }

  protected String a(Uri paramUri)
  {
    switch (f.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    return "vnd.android.cursor.dir/vnd.facebook.logresult";
  }

  public boolean onCreate()
  {
    this.g = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.LoggingProvider
 * JD-Core Version:    0.6.0
 */