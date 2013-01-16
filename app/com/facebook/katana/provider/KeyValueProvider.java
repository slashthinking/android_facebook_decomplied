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

public class KeyValueProvider extends SecureContentProvider
{
  static final String a = BuildConstants.b() + ".provider.KeyValueProvider";
  public static final Uri b = Uri.parse("content://" + a + "/" + "key_value");
  public static final Uri c = Uri.parse("content://" + a + "/" + "key_value" + "/key");
  private static final HashMap<String, String> d;
  private static final UriMatcher e = new UriMatcher(-1);
  private FacebookDatabaseHelper f;

  static
  {
    e.addURI(a, "key_value", 1);
    e.addURI(a, "key_value/#", 2);
    e.addURI(a, "key_value/key/*", 3);
    d = new HashMap();
    d.put("_id", "_id");
    d.put("key", "key");
    d.put("value", "value");
  }

  public static String[] a()
  {
    return new String[] { "key_value" };
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE key_value (_id INTEGER PRIMARY KEY,key TEXT UNIQUE,value TEXT);" };
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
    int i;
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      i = localSQLiteDatabase.update("key_value", paramContentValues, paramString, paramArrayOfString);
    case 2:
    case 3:
    }
    while (true)
    {
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return i;
      String str2 = (String)paramUri.getPathSegments().get(1);
      i = localSQLiteDatabase.update("key_value", paramContentValues, "_id=" + str2, null);
      continue;
      String str1 = (String)paramUri.getPathSegments().get(2);
      i = localSQLiteDatabase.update("key_value", paramContentValues, "key='" + str1 + "'", null);
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
    int i;
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      i = localSQLiteDatabase.delete("key_value", paramString, paramArrayOfString);
    case 2:
    case 3:
    }
    while (true)
    {
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return i;
      String str2 = (String)paramUri.getPathSegments().get(1);
      i = localSQLiteDatabase.delete("key_value", "_id=" + str2, null);
      continue;
      String str1 = (String)paramUri.getPathSegments().get(1);
      i = localSQLiteDatabase.delete("key_value", "key=" + str1, null);
    }
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      localSQLiteQueryBuilder.setTables("key_value");
      localSQLiteQueryBuilder.setProjectionMap(d);
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 2:
    case 3:
    }
    for (String str = "key DESC"; ; str = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.f.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localSQLiteQueryBuilder.setTables("key_value");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      break;
      localSQLiteQueryBuilder.setTables("key_value");
      localSQLiteQueryBuilder.appendWhere("key='" + (String)paramUri.getPathSegments().get(2) + "'");
      break;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues != null);
    for (ContentValues localContentValues = new ContentValues(paramContentValues); e.match(paramUri) != 1; localContentValues = new ContentValues())
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    long l = this.f.getWritableDatabase().insert("key_value", "key", localContentValues);
    if (l > 0L)
    {
      Uri localUri = Uri.withAppendedPath(b, Long.valueOf(l).toString());
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return localUri;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  protected String a(Uri paramUri)
  {
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    case 3:
    }
    return "vnd.android.cursor.item/vnd.facebook.katana.keyvalue";
  }

  public boolean onCreate()
  {
    this.f = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.KeyValueProvider
 * JD-Core Version:    0.6.0
 */