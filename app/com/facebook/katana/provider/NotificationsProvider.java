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
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.orca.inject.FbInjector;
import java.util.List;
import java.util.Map;

public class NotificationsProvider extends SecureContentProvider
{
  private static final Map<String, String> a = new NotificationsProvider.1();
  private FacebookDatabaseHelper b;
  private boolean c = false;
  private UriMatcher d;
  private NotificationsContract e;

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
        this.e = ((NotificationsContract)FbInjector.a(getContext()).a(NotificationsContract.class));
        this.d = new UriMatcher(-1);
        this.d.addURI(this.e.b, "notifications", 1);
        this.d.addURI(this.e.b, "notifications/#", 2);
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
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    switch (this.d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    String str;
    for (int i = localSQLiteDatabase.update("notifications", paramContentValues, paramString, paramArrayOfString); ; i = localSQLiteDatabase.update("notifications", paramContentValues, "_id=" + str, null))
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      str = (String)paramUri.getPathSegments().get(1);
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    c();
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    switch (this.d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    String str;
    for (int i = localSQLiteDatabase.delete("notifications", paramString, paramArrayOfString); ; i = localSQLiteDatabase.delete("notifications", "_id=" + str, null))
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      str = (String)paramUri.getPathSegments().get(1);
    }
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = 0;
    c();
    if (this.d.match(paramUri) != 1)
      throw new IllegalArgumentException("Unknown URL " + paramUri);
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
    switch (this.d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      localSQLiteQueryBuilder.setTables("notifications");
      localSQLiteQueryBuilder.setProjectionMap(a);
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 2:
    }
    for (String str = "updated DESC"; ; str = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.b.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localSQLiteQueryBuilder.setTables("notifications");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      break;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    c();
    if (paramContentValues != null);
    for (ContentValues localContentValues = new ContentValues(paramContentValues); this.d.match(paramUri) != 1; localContentValues = new ContentValues())
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    long l = this.b.getWritableDatabase().insert("notifications", "notif_id", localContentValues);
    if (l > 0L)
    {
      Uri localUri = Uri.withAppendedPath(this.e.c, Long.valueOf(l).toString());
      getContext().getContentResolver().notifyChange(paramUri, null);
      return localUri;
    }
    throw new SQLException("Failed to insert row into " + paramUri);
  }

  protected String a(Uri paramUri)
  {
    c();
    switch (this.d.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    return "vnd.android.cursor.dir/vnd.facebook.katana.notifications";
  }

  public boolean onCreate()
  {
    this.b = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.NotificationsProvider
 * JD-Core Version:    0.6.0
 */