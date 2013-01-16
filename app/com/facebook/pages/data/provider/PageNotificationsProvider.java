package com.facebook.pages.data.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.content.SecureContentProvider;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.orca.inject.FbInjector;
import com.facebook.pages.data.db.PageDbOpenHelper;
import java.util.Map;

public class PageNotificationsProvider extends SecureContentProvider
{
  private static final Map<String, String> a = new PageNotificationsProvider.1();
  private PageDbOpenHelper b;
  private boolean c = false;
  private NotificationsContract d;

  public static String a()
  {
    return "notifications";
  }

  public static String b()
  {
    return "CREATE TABLE notifications (_id INTEGER PRIMARY KEY,notif_id INT,recipient_id INT,sender_id INT,sender_name TEXT,sender_url TEXT,updated INT,title TEXT,href TEXT,is_unread INT,icon_url TEXT,object_id TEXT,object_type TEXT,object_photo_url TEXT,join_data_string TEXT,  UNIQUE(notif_id) ON CONFLICT REPLACE);";
  }

  private void c()
  {
    monitorenter;
    try
    {
      boolean bool = this.c;
      if (bool);
      while (true)
      {
        return;
        this.d = ((NotificationsContract)FbInjector.a(getContext()).a(NotificationsContract.class));
        this.c = true;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    c();
    int i = this.b.getWritableDatabase().update("notifications", paramContentValues, paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    c();
    int i = this.b.getWritableDatabase().delete("notifications", paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = 0;
    c();
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    int j = 0;
    while (i < paramArrayOfContentValues.length)
    {
      if (localSQLiteDatabase.insert("notifications", "notif_id", paramArrayOfContentValues[i]) > 0L)
        j++;
      i++;
    }
    if (j > 0)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return j;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    c();
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("notifications");
    localSQLiteQueryBuilder.setProjectionMap(a);
    if (TextUtils.isEmpty(paramString2));
    for (String str = "updated DESC"; ; str = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.b.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    c();
    if (paramContentValues != null);
    for (ContentValues localContentValues = new ContentValues(paramContentValues); ; localContentValues = new ContentValues())
    {
      long l = this.b.getWritableDatabase().insert("notifications", "notif_id", localContentValues);
      if (l <= 0L)
        break;
      Uri localUri = Uri.withAppendedPath(this.d.c, Long.valueOf(l).toString());
      getContext().getContentResolver().notifyChange(paramUri, null);
      return localUri;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  protected String a(Uri paramUri)
  {
    c();
    return "vnd.android.cursor.dir/vnd.facebook.pages.notifications";
  }

  public boolean onCreate()
  {
    this.b = PageDbOpenHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.provider.PageNotificationsProvider
 * JD-Core Version:    0.6.0
 */