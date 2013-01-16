package com.facebook.bookmark.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.bookmark.ipc.BookmarkIpcConstants;
import com.facebook.orca.inject.FbInjector;
import java.util.ArrayList;

public class BookmarkProvider extends ContentProvider
{
  private static final UriMatcher a = new UriMatcher(-1);
  private SQLiteOpenHelper b;

  static
  {
    a.addURI(BookmarkIpcConstants.a, "bookmarks", 0);
    a.addURI(BookmarkIpcConstants.a, "BookmarkUnreadCount", 1);
    a.addURI(BookmarkIpcConstants.a, "bookmark_sync_status", 2);
    a.addURI(BookmarkIpcConstants.a, "bookmark_group_order", 3);
  }

  private SQLiteOpenHelper a()
  {
    if (this.b == null)
      this.b = ((SQLiteOpenHelper)FbInjector.a(getContext()).a(SQLiteOpenHelper.class, BookmarkDB.class));
    return this.b;
  }

  private static String a(Uri paramUri)
  {
    String str;
    switch (a.match(paramUri))
    {
    default:
      throw new SQLException("The uri " + paramUri + " is invalid for bookmark content provider.");
    case 0:
      str = "bookmarks";
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return str;
      str = "bookmarks";
      continue;
      str = "bookmark_sync_status";
      continue;
      str = "bookmark_group_order";
    }
  }

  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
  {
    SQLiteDatabase localSQLiteDatabase = a().getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ContentProviderResult[] arrayOfContentProviderResult = super.applyBatch(paramArrayList);
      localSQLiteDatabase.setTransactionSuccessful();
      return arrayOfContentProviderResult;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase;
    String str;
    switch (a.match(paramUri))
    {
    default:
      localSQLiteDatabase = a().getWritableDatabase();
      str = a(paramUri);
      localSQLiteDatabase.beginTransaction();
    case 2:
    case 1:
    }
    try
    {
      int j = paramArrayOfContentValues.length;
      int k = 0;
      if (k < j)
      {
        long l = localSQLiteDatabase.insert(str, null, paramArrayOfContentValues[k]);
        if (l >= 0L);
      }
      while (true)
      {
        return i;
        throw new SQLException("Could only insert records into sync_status table.");
        throw new SQLException(paramUri + " is only used for notification and updating.");
        k++;
        break;
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        i = paramArrayOfContentValues.length;
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (a.match(paramUri))
    {
    default:
      return a().getWritableDatabase().delete(a(paramUri), paramString, paramArrayOfString);
    case 2:
      throw new SQLException("Could only delete record from sync_status table.");
    case 1:
    }
    throw new SQLException(paramUri + " is only used for notification and updating.");
  }

  public String getType(Uri paramUri)
  {
    String str;
    switch (a.match(paramUri))
    {
    default:
      throw new SQLException("The uri " + paramUri + " is invalid for bookmark content provider.");
    case 0:
      str = "vnd.android.cursor.item/vnd.facebook.katana.bookmark";
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return str;
      str = "vnd.android.cursor.item/vnd.facebook.katana.bookmark_unread_count";
      continue;
      str = "vnd.android.cursor.item/vnd.facebook.katana.bookmark_sync_status";
      continue;
      str = "vnd.android.cursor.item/vnd.facebook.katana.bookmark_group_order";
    }
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (a.match(paramUri))
    {
    default:
      if (a().getWritableDatabase().insert(a(paramUri), null, paramContentValues) >= 0L)
        return paramUri;
      break;
    case 2:
      throw new SQLException("Could only insert record into sync_status table.");
    case 1:
      throw new SQLException(paramUri + " is only used for notification and updating.");
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  public boolean onCreate()
  {
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (a.match(paramUri) == 1)
      throw new SQLException(paramUri + " is only used for notification and updating.");
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables(a(paramUri));
    return localSQLiteQueryBuilder.query(a().getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return a().getWritableDatabase().update(a(paramUri), paramContentValues, paramString, paramArrayOfString);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.provider.BookmarkProvider
 * JD-Core Version:    0.6.2
 */