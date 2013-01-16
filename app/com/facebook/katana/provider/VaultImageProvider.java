package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.content.SecureContentProvider;
import com.facebook.orca.common.util.StringUtil;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class VaultImageProvider extends SecureContentProvider
{
  public static final Uri a;
  public static String[] b;
  private static final String c = BuildConstants.b() + ".provider.VaultImageProvider";
  private static final String d = "vnd.android.cursor.dir/" + c;
  private static final UriMatcher e;
  private static HashMap<String, String> f;
  private FacebookDatabaseHelper g;

  static
  {
    a = Uri.parse("content://" + c + "/" + "images");
    e = new UriMatcher(-1);
    e.addURI(c, "images", 1);
    e.addURI(c, "images/*", 2);
    b = new String[] { "image_hash", "image_fbid", "date_taken", "upload_date", "failure_count", "shared", "upload_state", "queue_state", "last_attempt" };
    f = new HashMap();
    f.put("image_hash", "image_hash");
    f.put("image_fbid", "image_fbid");
    f.put("date_taken", "date_taken");
    f.put("upload_date", "upload_date");
    f.put("failure_count", "failure_count");
    f.put("upload_state", "upload_state");
    f.put("shared", "shared");
    f.put("queue_state", "queue_state");
    f.put("last_attempt", "last_attempt");
  }

  public static Pair<String, Long> a(String paramString)
  {
    String[] arrayOfString = paramString.split("/");
    if (arrayOfString.length != 2)
    {
      Log.a("invalid image hash: " + paramString);
      ErrorReporting.a("vault_bad_image_hash", paramString);
    }
    for (Pair localPair = null; ; localPair = new Pair(arrayOfString[0], Long.valueOf(Long.parseLong(arrayOfString[1]))))
      return localPair;
  }

  public static String a()
  {
    return "images";
  }

  public static String a(String paramString, long paramLong)
  {
    return paramString + "/" + paramLong;
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE images (image_hash STRING PRIMARY KEY,image_fbid INTEGER,date_taken INTEGER,upload_date INTEGER,failure_count INTEGER,upload_state INTEGER,shared INTEGER,queue_state INTEGER,last_attempt INTEGER);", "CREATE INDEX vault_upload_state_idx ON images(upload_state)", "CREATE INDEX vault_image_hash_idx ON images(image_hash)" };
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.g.getWritableDatabase();
    int i;
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL for update: " + paramUri);
    case 1:
      i = localSQLiteDatabase.update("images", paramContentValues, paramString, paramArrayOfString);
      if (i <= 0)
        break;
      getContext().getContentResolver().notifyChange(paramUri, null);
    case 2:
    }
    while (true)
    {
      return i;
      String str = Uri.decode(paramUri.getLastPathSegment());
      if (TextUtils.isEmpty(paramString))
      {
        ArrayList localArrayList2 = Lists.a();
        localArrayList2.add(str);
        i = localSQLiteDatabase.update("images", paramContentValues, StringUtil.a("%s = ?", new Object[] { "image_hash" }), (String[])localArrayList2.toArray(new String[localArrayList2.size()]));
        continue;
      }
      ArrayList localArrayList1 = new ArrayList(Arrays.asList(paramArrayOfString));
      localArrayList1.add(str);
      i = localSQLiteDatabase.update("images", paramContentValues, StringUtil.a("%s and (%s = ?)", new Object[] { paramString, "image_hash" }), (String[])localArrayList1.toArray(new String[localArrayList1.size()]));
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.g.getWritableDatabase();
    int i;
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL for delete: " + paramUri);
    case 1:
      i = localSQLiteDatabase.delete("images", paramString, paramArrayOfString);
      if (i <= 0)
        break;
      getContext().getContentResolver().notifyChange(paramUri, null);
    case 2:
    }
    while (true)
    {
      return i;
      String str = Uri.decode(paramUri.getLastPathSegment());
      if (TextUtils.isEmpty(paramString))
      {
        ArrayList localArrayList2 = Lists.a();
        localArrayList2.add(str);
        i = localSQLiteDatabase.delete("images", StringUtil.a("%s = ?", new Object[] { "image_hash" }), (String[])localArrayList2.toArray(new String[localArrayList2.size()]));
        continue;
      }
      ArrayList localArrayList1 = new ArrayList(Arrays.asList(paramArrayOfString));
      localArrayList1.add(str);
      i = localSQLiteDatabase.delete("images", StringUtil.a("%s and (%s = ?)", new Object[] { paramString, "image_hash" }), (String[])localArrayList1.toArray(new String[localArrayList1.size()]));
    }
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("images");
    localSQLiteQueryBuilder.setProjectionMap(f);
    ArrayList localArrayList;
    if (paramArrayOfString2 == null)
    {
      localArrayList = new ArrayList();
      switch (e.match(paramUri))
      {
      case 1:
      default:
      case 2:
      }
    }
    while (true)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.g.getWritableDatabase(), paramArrayOfString1, paramString1, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, null, paramString2);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localArrayList = new ArrayList(Arrays.asList(paramArrayOfString2));
      break;
      String str = Uri.decode(paramUri.getLastPathSegment());
      localSQLiteQueryBuilder.appendWhere(StringUtil.a("%s = ?", new Object[] { "image_hash" }));
      localArrayList.add(str);
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.g.getWritableDatabase();
    switch (e.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL for insert: " + paramUri);
    case 1:
      if (paramContentValues.containsKey("image_hash"))
        break;
      throw new IllegalArgumentException("Missing primary key (IMAGE_HASH) for:" + paramUri);
    case 2:
      paramContentValues.put("image_hash", Uri.decode(paramUri.getLastPathSegment()));
    }
    long l = localSQLiteDatabase.replace("images", "image_fbid", paramContentValues);
    if (l > 0L)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return ContentUris.withAppendedId(a, l);
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
    }
    return d;
  }

  public boolean onCreate()
  {
    this.g = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.VaultImageProvider
 * JD-Core Version:    0.6.0
 */