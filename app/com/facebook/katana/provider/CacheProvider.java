package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.base.BuildConstants;
import com.facebook.content.SecureContentProvider;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.HashMap;
import java.util.List;

public class CacheProvider extends SecureContentProvider
{
  public static final Uri a;
  public static final Uri b;
  public static final Uri c;
  public static final Uri d;
  private static final String e = BuildConstants.b() + ".provider.CacheProvider";
  private static final HashMap<String, String> f;
  private static final UriMatcher g;
  private FacebookDatabaseHelper h;

  static
  {
    a = Uri.parse("content://" + e + "/" + "cache");
    b = Uri.parse("content://" + e + "/" + "cache" + "/name");
    c = Uri.parse("content://" + e + "/" + "cache" + "/prefix");
    d = Uri.parse("content://" + e + "/" + "cache" + "/sweep_prefix");
    g = new UriMatcher(-1);
    g.addURI(e, "cache", 1);
    g.addURI(e, "cache/#", 2);
    g.addURI(e, "cache/name/*", 3);
    g.addURI(e, "cache/prefix/*", 4);
    g.addURI(e, "cache/sweep_prefix/*/#", 5);
    f = new HashMap();
    f.put("_id", "_id");
    f.put("name", "name");
    f.put("value", "value");
    f.put("timestamp", "timestamp");
  }

  public static String[] a()
  {
    return new String[] { "cache" };
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE cache (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,timestamp INTEGER DEFAULT 0);" };
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int i;
    switch (g.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      i = localSQLiteDatabase.update("cache", paramContentValues, paramString, paramArrayOfString);
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return i;
      String str3 = (String)paramUri.getPathSegments().get(1);
      i = localSQLiteDatabase.update("cache", paramContentValues, "_id=" + str3, null);
      continue;
      String str2 = (String)paramUri.getPathSegments().get(2);
      i = localSQLiteDatabase.update("cache", paramContentValues, "name=" + DatabaseUtils.sqlEscapeString(str2), null);
      continue;
      String str1 = (String)paramUri.getPathSegments().get(2);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = "name";
      arrayOfObject[1] = Integer.valueOf(str1.length());
      arrayOfObject[2] = DatabaseUtils.sqlEscapeString(str1);
      i = localSQLiteDatabase.update("cache", paramContentValues, StringLocaleUtil.a("SUBSTR(%s, 1, %d)=%s", arrayOfObject), null);
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int j;
    switch (g.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      j = localSQLiteDatabase.delete("cache", paramString, paramArrayOfString);
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return j;
      String str4 = (String)paramUri.getPathSegments().get(1);
      j = localSQLiteDatabase.delete("cache", "_id=" + str4, null);
      continue;
      String str3 = (String)paramUri.getPathSegments().get(2);
      j = localSQLiteDatabase.delete("cache", "name=" + DatabaseUtils.sqlEscapeString(str3), null);
      continue;
      String str2 = (String)paramUri.getPathSegments().get(2);
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = "name";
      arrayOfObject2[1] = Integer.valueOf(str2.length());
      arrayOfObject2[2] = DatabaseUtils.sqlEscapeString(str2);
      j = localSQLiteDatabase.delete("cache", StringLocaleUtil.a("SUBSTR(%s, 1, %d)=%s", arrayOfObject2), null);
      continue;
      String str1 = (String)paramUri.getPathSegments().get(2);
      int i = Integer.parseInt((String)paramUri.getPathSegments().get(3));
      Object[] arrayOfObject1 = new Object[6];
      arrayOfObject1[0] = "name";
      arrayOfObject1[1] = Integer.valueOf(str1.length());
      arrayOfObject1[2] = DatabaseUtils.sqlEscapeString(str1);
      arrayOfObject1[3] = Long.valueOf(System.currentTimeMillis() / 1000L);
      arrayOfObject1[4] = "timestamp";
      arrayOfObject1[5] = Integer.valueOf(i);
      j = localSQLiteDatabase.delete("cache", StringLocaleUtil.a("SUBSTR(%s, 1, %d)=%s AND (%d-%s > %d)", arrayOfObject1), null);
    }
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    switch (g.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      localSQLiteQueryBuilder.setTables("cache");
      localSQLiteQueryBuilder.setProjectionMap(f);
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 2:
    case 3:
    case 4:
    }
    for (String str2 = "name DESC"; ; str2 = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.h.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str2);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localSQLiteQueryBuilder.setTables("cache");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      break;
      localSQLiteQueryBuilder.setTables("cache");
      localSQLiteQueryBuilder.appendWhere("name=" + DatabaseUtils.sqlEscapeString((String)paramUri.getPathSegments().get(2)));
      break;
      String str1 = (String)paramUri.getPathSegments().get(2);
      localSQLiteQueryBuilder.setTables("cache");
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = "name";
      arrayOfObject[1] = Integer.valueOf(str1.length());
      arrayOfObject[2] = DatabaseUtils.sqlEscapeString(str1);
      localSQLiteQueryBuilder.appendWhere(StringLocaleUtil.a("SUBSTR(%s, 1, %d)=%s", arrayOfObject));
      break;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues != null);
    for (ContentValues localContentValues = new ContentValues(paramContentValues); g.match(paramUri) != 1; localContentValues = new ContentValues())
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    long l = this.h.getWritableDatabase().insert("cache", "name", localContentValues);
    if (l > 0L)
    {
      Uri localUri = Uri.withAppendedPath(a, Long.toString(l));
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return localUri;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  protected String a(Uri paramUri)
  {
    switch (g.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    case 3:
    }
    return "vnd.android.cursor.item/vnd.facebook.katana.cache";
  }

  public boolean onCreate()
  {
    this.h = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.CacheProvider
 * JD-Core Version:    0.6.0
 */