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

public class LocalFaceboxProvider extends SecureContentProvider
{
  public static final Uri a;
  private static final String b = BuildConstants.b() + ".provider.LocalFaceboxProvider";
  private static final String c = "vnd.android.cursor.dir/" + b;
  private static final UriMatcher d;
  private static HashMap<String, String> e;
  private FacebookDatabaseHelper f;

  static
  {
    a = Uri.parse("content://" + b + "/" + "localphotofaceboxes");
    d = new UriMatcher(-1);
    d.addURI(b, "localphotofaceboxes", 1);
    d.addURI(b, "localphotofaceboxes/*", 2);
    e = new HashMap();
    e.put("facebox_id", "facebox_id");
    e.put("x_pos", "x_pos");
    e.put("y_pos", "y_pos");
    e.put("width", "width");
    e.put("height", "height");
    e.put("image_hash", "image_hash");
  }

  public static String a()
  {
    return "localphotofaceboxes";
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE localphotofaceboxes (facebox_id STRING,x_pos REAL,y_pos REAL,width REAL,height REAL,image_hash STRING);", "CREATE INDEX local_facebox_image_hash_idx ON localphotofaceboxes(image_hash)" };
  }

  public int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  public int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URI for delete: " + paramUri);
    case 2:
      paramArrayOfString = new String[] { DatabaseUtils.sqlEscapeString(paramUri.getLastPathSegment()) };
    case 1:
    }
    int i = this.f.getWritableDatabase().delete("localphotofaceboxes", paramString, paramArrayOfString);
    if (i > 0)
      getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  public int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = 0;
    int i1;
    int i2;
    switch (d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URI for insert: " + paramUri);
    case 1:
      i1 = paramArrayOfContentValues.length;
      i2 = 0;
    case 2:
    }
    while (i2 < i1)
    {
      if (!paramArrayOfContentValues[i2].containsKey("image_hash"))
        throw new IllegalArgumentException("Missing image_hash for: " + paramUri);
      i2++;
      continue;
      String str = DatabaseUtils.sqlEscapeString(paramUri.getLastPathSegment());
      int j = paramArrayOfContentValues.length;
      for (int k = 0; k < j; k++)
        paramArrayOfContentValues[k].put("image_hash", str);
    }
    SQLiteDatabase localSQLiteDatabase = this.f.getWritableDatabase();
    while (true)
    {
      int n;
      try
      {
        localSQLiteDatabase.beginTransaction();
        int m = paramArrayOfContentValues.length;
        n = 0;
        if (n >= m)
          continue;
        if (localSQLiteDatabase.insert("localphotofaceboxes", null, paramArrayOfContentValues[n]) <= 0L)
          break label323;
        i++;
        break label323;
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        if (i > 0)
        {
          getContext().getContentResolver().notifyChange(paramUri, null);
          return i;
        }
      }
      catch (SQLException localSQLException)
      {
        throw new SQLException("Got SQLException Failed to insert " + paramArrayOfContentValues.length + " rows into " + paramUri);
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      throw new SQLException("Failed to insert " + paramArrayOfContentValues.length + " rows into " + paramUri);
      label323: n++;
    }
  }

  public Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("localphotofaceboxes");
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

  public Uri a(Uri paramUri, ContentValues paramContentValues)
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
    long l = this.f.getWritableDatabase().insert("localphotofaceboxes", null, paramContentValues);
    if (l > 0L)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return ContentUris.withAppendedId(a, l);
    }
    throw new SQLException("Failed to insert rows into " + paramUri);
  }

  public String a(Uri paramUri)
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
 * Qualified Name:     com.facebook.katana.provider.LocalFaceboxProvider
 * JD-Core Version:    0.6.0
 */