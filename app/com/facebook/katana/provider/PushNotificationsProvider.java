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
import com.facebook.common.util.ErrorReporting;
import com.facebook.content.SecureContentProvider;
import com.facebook.ipc.notifications.PushNotificationsContract;
import java.util.List;

public class PushNotificationsProvider extends SecureContentProvider
{
  private static final Class<?> a = PushNotificationsProvider.class;
  private static final UriMatcher b = new UriMatcher(-1);
  private FacebookDatabaseHelper c;

  static
  {
    b.addURI(PushNotificationsContract.a, "push_notifications", 1);
    b.addURI(PushNotificationsContract.a, "push_notifications/#", 2);
  }

  public static String a()
  {
    return "push_notifications";
  }

  public static void a(ContentResolver paramContentResolver)
  {
    if (paramContentResolver != null)
    {
      String str = String.valueOf(System.currentTimeMillis() - 604800000L);
      paramContentResolver.delete(PushNotificationsContract.b, "receipt_time<=?", new String[] { str });
    }
  }

  public static String b()
  {
    return "CREATE TABLE push_notifications (_id INTEGER PRIMARY KEY,noti_type TEXT,noti_time INT,receipt_time INT,target_uid INT,message TEXT,params TEXT,unread_count INT,href TEXT);";
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    switch (b.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    String str;
    for (int i = localSQLiteDatabase.update("push_notifications", paramContentValues, paramString, paramArrayOfString); ; i = localSQLiteDatabase.update("push_notifications", paramContentValues, "_id=" + str, null))
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      str = (String)paramUri.getPathSegments().get(1);
    }
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    switch (b.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    String str;
    for (int i = localSQLiteDatabase.delete("push_notifications", paramString, paramArrayOfString); ; i = localSQLiteDatabase.delete("push_notifications", "_id=" + str, null))
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      str = (String)paramUri.getPathSegments().get(1);
    }
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    switch (b.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      localSQLiteQueryBuilder.setTables("push_notifications");
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 2:
    }
    for (String str = "receipt_time DESC"; ; str = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.c.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localSQLiteQueryBuilder.setTables("push_notifications");
      localSQLiteQueryBuilder.appendWhere("_id=" + (String)paramUri.getPathSegments().get(1));
      break;
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (b.match(paramUri) != 1)
      throw new IllegalArgumentException("Unknown URI " + paramUri);
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    try
    {
      long l2 = localSQLiteDatabase.insertOrThrow("push_notifications", "_id", paramContentValues);
      l1 = l2;
      if (l1 > 0L)
      {
        localUri = Uri.withAppendedPath(PushNotificationsContract.b, String.valueOf(l1));
        getContext().getContentResolver().notifyChange(paramUri, null);
        return localUri;
      }
    }
    catch (SQLException localSQLException)
    {
      while (true)
      {
        ErrorReporting.a(a.getSimpleName(), "Failure during insert operation", localSQLException, true, 1);
        long l1 = 0L;
        continue;
        Uri localUri = null;
      }
    }
  }

  protected String a(Uri paramUri)
  {
    switch (b.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    for (String str = "vnd.android.cursor.dir/vnd.facebook.katana.push_notifications"; ; str = "vnd.android.cursor.item/vnd.facebook.katana.push_notifications")
      return str;
  }

  public boolean onCreate()
  {
    this.c = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.PushNotificationsProvider
 * JD-Core Version:    0.6.0
 */