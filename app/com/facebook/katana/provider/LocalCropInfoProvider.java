package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.base.BuildConstants;
import com.facebook.content.SecureContentProvider;
import java.util.HashMap;

public class LocalCropInfoProvider extends SecureContentProvider
{
  public static final Uri a;
  private static final String b = BuildConstants.b() + ".provider.LocalCropInfoProvider";
  private static final String c = "vnd.android.cursor.dir/" + b;
  private static final UriMatcher d;
  private static HashMap<String, String> e;
  private FacebookDatabaseHelper f;

  static
  {
    a = Uri.parse("content://" + b + "/" + "localcropdata");
    d = new UriMatcher(-1);
    d.addURI(b, "localcropdata", 1);
    d.addURI(b, "localcropdata/*", 2);
    e = new HashMap();
    e.put("coordinates0", "coordinates0");
    e.put("coordinates1", "coordinates1");
    e.put("coordinates2", "coordinates2");
    e.put("coordinates3", "coordinates3");
    e.put("coordinates4", "coordinates4");
    e.put("coordinates5", "coordinates5");
    e.put("coordinates6", "coordinates6");
    e.put("coordinates7", "coordinates7");
    e.put("image_hash", "image_hash");
  }

  public static String a()
  {
    return "localcropdata";
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE localcropdata (coordinates0 REAL,coordinates1 REAL,coordinates2 REAL,coordinates3 REAL,coordinates4 REAL,coordinates5 REAL,coordinates6 REAL,coordinates7 REAL,image_hash STRING);", "CREATE INDEX local_crop_data_image_hash_idx ON localcropdata(image_hash)" };
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    switch (d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URI for update: " + paramUri);
    case 2:
      paramContentValues.put("image_hash", DatabaseUtils.sqlEscapeString(paramUri.getLastPathSegment()));
    case 1:
    }
    int i = this.f.getWritableDatabase().update("localcropdata", paramContentValues, paramString, paramArrayOfString);
    if (i > 0)
      getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URI for delete: " + paramUri);
    case 2:
      paramArrayOfString = new String[] { DatabaseUtils.sqlEscapeString(paramUri.getLastPathSegment()) };
    case 1:
    }
    int i = this.f.getWritableDatabase().delete("localcropdata", paramString, paramArrayOfString);
    if (i > 0)
      getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("localcropdata");
    localSQLiteQueryBuilder.setProjectionMap(e);
    switch (d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URI for query: " + paramUri);
    case 2:
      localSQLiteQueryBuilder.appendWhere("image_hash=" + DatabaseUtils.sqlEscapeString(paramUri.getLastPathSegment()));
    case 1:
    }
    Cursor localCursor = localSQLiteQueryBuilder.query(this.f.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, null);
    localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
    return localCursor;
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    switch (d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URI for insert: " + paramUri);
    case 1:
      if (paramContentValues.containsKey("image_hash"))
        break;
      throw new IllegalArgumentException("Missing image_hash for: " + paramUri);
    case 2:
      paramContentValues.put("image_hash", DatabaseUtils.sqlEscapeString(paramUri.getLastPathSegment()));
    }
    long l = this.f.getWritableDatabase().insert("localcropdata", null, paramContentValues);
    if (l > 0L)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return ContentUris.withAppendedId(a, l);
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  protected String a(Uri paramUri)
  {
    switch (d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URI: " + paramUri);
    case 1:
    case 2:
    }
    return c;
  }

  public boolean onCreate()
  {
    this.f = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.LocalCropInfoProvider
 * JD-Core Version:    0.6.0
 */