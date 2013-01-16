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
import android.text.TextUtils;
import com.facebook.base.BuildConstants;
import com.facebook.content.SecureContentProvider;
import java.util.HashMap;
import java.util.List;

public class UserStatusesProvider extends SecureContentProvider
{
  public static final Uri a;
  private static final String b = BuildConstants.b() + ".provider.UserStatusesProvider";
  private static final UriMatcher c;
  private static final HashMap<String, String> d;
  private FacebookDatabaseHelper e;

  static
  {
    a = Uri.parse("content://" + b + "/" + "user_statuses");
    c = new UriMatcher(-1);
    c.addURI(b, "user_statuses", 1);
    c.addURI(b, "user_statuses/#", 2);
    d = new HashMap();
    d.put("_id", "_id");
    d.put("user_id", "user_id");
    d.put("first_name", "first_name");
    d.put("last_name", "last_name");
    d.put("display_name", "display_name");
    d.put("user_pic", "user_pic");
    d.put("timestamp", "timestamp");
    d.put("message", "message");
    d.put("status_id", "status_id");
  }

  public static String a()
  {
    return "user_statuses";
  }

  public static String b()
  {
    return "CREATE TABLE user_statuses (_id INTEGER PRIMARY KEY,user_id INT,first_name TEXT,last_name TEXT,display_name TEXT,user_pic TEXT,timestamp INT,message TEXT,status_id INT);";
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.e.getWritableDatabase();
    switch (c.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    String str;
    for (int i = localSQLiteDatabase.update("user_statuses", paramContentValues, paramString, paramArrayOfString); ; i = localSQLiteDatabase.update("user_statuses", paramContentValues, "_id=" + str, null))
    {
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return i;
      str = (String)paramUri.getPathSegments().get(1);
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.e.getWritableDatabase();
    switch (c.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    String str;
    for (int i = localSQLiteDatabase.delete("user_statuses", paramString, paramArrayOfString); ; i = localSQLiteDatabase.delete("user_statuses", "_id=" + str, null))
    {
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return i;
      str = (String)paramUri.getPathSegments().get(1);
    }
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    switch (c.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      localSQLiteQueryBuilder.setTables("user_statuses");
      localSQLiteQueryBuilder.setProjectionMap(d);
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 2:
    }
    for (String str = "timestamp DESC"; ; str = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.e.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localSQLiteQueryBuilder.setTables("user_statuses");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      break;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues != null);
    for (ContentValues localContentValues = new ContentValues(paramContentValues); c.match(paramUri) != 1; localContentValues = new ContentValues())
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    long l = this.e.getWritableDatabase().insert("user_statuses", "user_id", localContentValues);
    if (l > 0L)
    {
      Uri localUri = Uri.withAppendedPath(a, Long.valueOf(l).toString());
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return localUri;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  protected String a(Uri paramUri)
  {
    switch (c.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    for (String str = "vnd.android.cursor.dir/vnd.facebook.katana.userstatuses"; ; str = "vnd.android.cursor.item/vnd.facebook.katana.userstatuses")
      return str;
  }

  public boolean onCreate()
  {
    this.e = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.UserStatusesProvider
 * JD-Core Version:    0.6.0
 */