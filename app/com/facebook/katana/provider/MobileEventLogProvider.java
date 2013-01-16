package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.ErrorReporting;
import com.facebook.content.SecureContentProvider;
import com.facebook.katana.util.StringUtils;
import java.util.HashMap;

public class MobileEventLogProvider extends SecureContentProvider
{
  public static final Uri a;
  public static final HashMap<String, String> b;
  private static final String c = BuildConstants.b() + ".provider.MobileEventLogProvider";
  private static final String d = "content://" + c + "/" + "mobile_event_log";
  private static final UriMatcher e;
  private FacebookDatabaseHelper f;

  static
  {
    a = Uri.parse(d);
    e = new UriMatcher(-1);
    e.addURI(c, "mobile_event_log", 1);
    b = new MobileEventLogProvider.1();
  }

  static String[] a()
  {
    return new String[] { "mobile_event_log" };
  }

  private int b(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
    int j = paramArrayOfContentValues.length;
    for (int k = 0; k < j; k++)
    {
      if (localSQLiteDatabase.insertOrThrow("mobile_event_log", "data", paramArrayOfContentValues[k]) <= 0L)
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
    long l = this.f.getWritableDatabase().insertOrThrow("mobile_event_log", "data", paramContentValues);
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
    return new String[] { "CREATE TABLE mobile_event_log (_id INTEGER PRIMARY KEY,time INT,data TEXT,pre_ctx TEXT,post_ctx TEXT);" };
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    }
    int i = localSQLiteDatabase.update("mobile_event_log", paramContentValues, paramString, paramArrayOfString);
    if (i > 0)
      getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    }
    int i;
    String str1;
    StringBuilder localStringBuilder;
    try
    {
      int j = localSQLiteDatabase.delete("mobile_event_log", paramString, paramArrayOfString);
      i = j;
      if (i > 0)
        getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      str1 = MobileEventLogProvider.class.getSimpleName();
      localStringBuilder = new StringBuilder().append("Failure in deleting entries in mobile_event_log; selection: ").append(paramString).append("; selectionArgs: ");
      if (paramArrayOfString != null);
    }
    for (String str2 = "null"; ; str2 = StringUtils.a(",", (Object[])paramArrayOfString))
    {
      ErrorReporting.a(str1, str2, localSQLiteException, true);
      i = -1;
      break;
    }
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    switch (e.match(paramUri))
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
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    }
    localSQLiteQueryBuilder.setTables("mobile_event_log");
    localSQLiteQueryBuilder.setProjectionMap(b);
    if (paramString2 == null);
    for (String str = "_id ASC"; ; str = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.f.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues != null);
    for (ContentValues localContentValues = new ContentValues(paramContentValues); ; localContentValues = new ContentValues())
      switch (e.match(paramUri))
      {
      default:
        throw new IllegalArgumentException("Unknown URL " + paramUri);
      case 1:
      }
    return b(paramUri, localContentValues);
  }

  protected String a(Uri paramUri)
  {
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    }
    return "vnd.android.cursor.dir/vnd.facebook.katana.mobileeventlog";
  }

  public boolean onCreate()
  {
    this.f = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.MobileEventLogProvider
 * JD-Core Version:    0.6.0
 */