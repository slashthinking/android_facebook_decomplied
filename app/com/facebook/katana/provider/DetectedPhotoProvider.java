package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.base.BuildConstants;
import com.facebook.content.SecureContentProvider;
import java.util.HashMap;

public class DetectedPhotoProvider extends SecureContentProvider
{
  public static final Uri a;
  private static final String b = BuildConstants.b() + ".provider.DetectedPhotoProvider";
  private static final String c = "vnd.android.cursor.dir/" + b;
  private static final UriMatcher d;
  private static HashMap<String, String> e;
  private FacebookDatabaseHelper f;

  static
  {
    a = Uri.parse("content://" + b + "/" + "detectedphotos");
    d = new UriMatcher(-1);
    d.addURI(b, "detectedphotos", 1);
    e = new HashMap();
    e.put("image_hash", "image_hash");
  }

  public static String a()
  {
    return "detectedphotos";
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE detectedphotos (image_hash STRING);", "CREATE INDEX local_detected_photo_image_hash_idx ON detectedphotos(image_hash)" };
  }

  public int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  public int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (d.match(paramUri) == 1)
    {
      int i = this.f.getWritableDatabase().delete("detectedphotos", paramString, paramArrayOfString);
      if (i > 0)
        getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
    }
    throw new IllegalArgumentException("Unknown URI for delete: " + paramUri);
  }

  public Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("detectedphotos");
    localSQLiteQueryBuilder.setProjectionMap(e);
    if (d.match(paramUri) == 1)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.f.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, null);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
    }
    throw new IllegalArgumentException("Unknown URI for query: " + paramUri);
  }

  public Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (d.match(paramUri) == 1)
    {
      long l = this.f.getWritableDatabase().insert("detectedphotos", null, paramContentValues);
      if (l > 0L)
      {
        getContext().getContentResolver().notifyChange(paramUri, null);
        return ContentUris.withAppendedId(a, l);
      }
      throw new IllegalArgumentException("Unknown URI for insert: " + paramUri);
    }
    throw new IllegalArgumentException("Unknown URI for insert: " + paramUri);
  }

  public String a(Uri paramUri)
  {
    if (d.match(paramUri) == 1)
      return c;
    throw new IllegalArgumentException("Unknown URI: " + paramUri);
  }

  public boolean onCreate()
  {
    this.f = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.DetectedPhotoProvider
 * JD-Core Version:    0.6.0
 */