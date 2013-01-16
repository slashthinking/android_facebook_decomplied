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

public class LocalPhotoTagProvider extends SecureContentProvider
{
  public static final Uri a;
  private static final String b = BuildConstants.b() + ".provider.LocalPhotoTagProvider";
  private static final String c = "vnd.android.cursor.dir/" + b;
  private static final UriMatcher d;
  private static HashMap<String, String> e;
  private FacebookDatabaseHelper f;

  static
  {
    a = Uri.parse("content://" + b + "/" + "localphototags");
    d = new UriMatcher(-1);
    d.addURI(b, "localphototags", 1);
    d.addURI(b, "localphototags/*", 2);
    e = new HashMap();
    e.put("tagged_id", "tagged_id");
    e.put("x_pos", "x_pos");
    e.put("y_pos", "y_pos");
    e.put("created", "created");
    e.put("text", "text");
    e.put("image_hash", "image_hash");
  }

  public static String a()
  {
    return "localphototags";
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE localphototags (tagged_id INTEGER,x_pos REAL,y_pos REAL,created INTEGER,text TEXT,image_hash STRING);", "CREATE INDEX local_tag_image_hash_idx ON localphototags(image_hash)" };
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
    int i = this.f.getWritableDatabase().update("localphototags", paramContentValues, paramString, paramArrayOfString);
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
    int i = this.f.getWritableDatabase().delete("localphototags", paramString, paramArrayOfString);
    if (i > 0)
      getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("localphototags");
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
    long l = this.f.getWritableDatabase().insert("localphototags", null, paramContentValues);
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
 * Qualified Name:     com.facebook.katana.provider.LocalPhotoTagProvider
 * JD-Core Version:    0.6.0
 */