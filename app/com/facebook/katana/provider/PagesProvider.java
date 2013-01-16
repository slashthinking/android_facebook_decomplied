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
import com.facebook.content.SecureContentProvider;
import com.facebook.ipc.pages.PagesContract;
import java.util.HashMap;
import java.util.List;

public class PagesProvider extends SecureContentProvider
{
  private static final HashMap<String, String> a;
  private static final HashMap<String, String> b;
  private static final UriMatcher c = new UriMatcher(-1);
  private FacebookDatabaseHelper d;

  static
  {
    c.addURI(PagesContract.a, "page_search_results", 31);
    c.addURI(PagesContract.a, "page_search_results/#", 32);
    c.addURI(PagesContract.a, "page_search_results/uid/#", 33);
    a = new HashMap();
    a.put("_id", "_id");
    a.put("pic", "pic");
    b = new HashMap();
    b.put("_id", "_id");
    b.put("page_id", "page_id");
    b.put("display_name", "display_name");
    b.put("pic", "pic");
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
    int i;
    switch (c.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 31:
      i = localSQLiteDatabase.update("page_search_results", paramContentValues, paramString, paramArrayOfString);
    case 32:
    case 33:
    }
    while (true)
    {
      if (i > 0)
        getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      String str2 = (String)paramUri.getPathSegments().get(1);
      i = localSQLiteDatabase.update("page_search_results", paramContentValues, "_id=" + str2, null);
      continue;
      String str1 = (String)paramUri.getPathSegments().get(2);
      i = localSQLiteDatabase.update("page_search_results", paramContentValues, "page_id=" + str1, null);
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
    int i;
    switch (c.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 31:
      i = localSQLiteDatabase.delete("page_search_results", paramString, paramArrayOfString);
    case 32:
    case 33:
    }
    while (true)
    {
      if (i > 0)
        getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      String str2 = (String)paramUri.getPathSegments().get(1);
      i = localSQLiteDatabase.delete("page_search_results", "_id=" + str2, null);
      continue;
      String str1 = (String)paramUri.getPathSegments().get(2);
      i = localSQLiteDatabase.delete("page_search_results", "page_id=" + str1, null);
    }
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
    switch (c.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 31:
    }
    int j = 0;
    while (i < paramArrayOfContentValues.length)
    {
      if (localSQLiteDatabase.insert("page_search_results", "page_id", paramArrayOfContentValues[i]) > 0L)
        j++;
      i++;
    }
    if (j > 0)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return j;
    }
    throw new SQLException("Failed to insert rows into " + paramUri);
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    String str1;
    switch (c.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 31:
      localSQLiteQueryBuilder.setTables("page_search_results");
      localSQLiteQueryBuilder.setProjectionMap(b);
      str1 = "_id ASC";
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 32:
    case 33:
    }
    for (String str2 = str1; ; str2 = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.d.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str2, null);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localSQLiteQueryBuilder.setTables("page_search_results");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      localSQLiteQueryBuilder.setProjectionMap(b);
      str1 = "_id ASC";
      break;
      localSQLiteQueryBuilder.setTables("page_search_results");
      localSQLiteQueryBuilder.appendWhere("page_id=" + (String)paramUri.getPathSegments().get(2));
      localSQLiteQueryBuilder.setProjectionMap(b);
      str1 = "_id ASC";
      break;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues != null);
    SQLiteDatabase localSQLiteDatabase;
    for (ContentValues localContentValues = new ContentValues(paramContentValues); ; localContentValues = new ContentValues())
    {
      localSQLiteDatabase = this.d.getWritableDatabase();
      switch (c.match(paramUri))
      {
      default:
        throw new IllegalArgumentException("Unknown URL " + paramUri);
      case 31:
      }
    }
    long l = localSQLiteDatabase.insert("page_search_results", "display_name", localContentValues);
    if (l > 0L)
    {
      Uri localUri = Uri.withAppendedPath(PagesContract.c, Long.valueOf(l).toString());
      getContext().getContentResolver().notifyChange(paramUri, null);
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
    case 31:
    case 32:
    case 33:
    }
    return "vnd.android.cursor.item/vnd.com.facebook.katana.provider.search_results";
  }

  public boolean onCreate()
  {
    this.d = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.PagesProvider
 * JD-Core Version:    0.6.0
 */