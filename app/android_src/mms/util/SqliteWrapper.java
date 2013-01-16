package android_src.mms.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.facebook.orca.debug.BLog;

public final class SqliteWrapper
{
  public static int a(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int j = paramContentResolver.update(paramUri, paramContentValues, paramString, paramArrayOfString);
      i = j;
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        BLog.d("SqliteWrapper", "Catch a SQLiteException when update: ", localSQLiteException);
        a(paramContext, localSQLiteException);
        int i = -1;
      }
    }
  }

  public static int a(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int j = paramContentResolver.delete(paramUri, paramString, paramArrayOfString);
      i = j;
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        BLog.d("SqliteWrapper", "Catch a SQLiteException when delete: ", localSQLiteException);
        a(paramContext, localSQLiteException);
        int i = -1;
      }
    }
  }

  public static Cursor a(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      Cursor localCursor2 = paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      localCursor1 = localCursor2;
      return localCursor1;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        BLog.d("SqliteWrapper", "Catch a SQLiteException when query: ", localSQLiteException);
        a(paramContext, localSQLiteException);
        Cursor localCursor1 = null;
      }
    }
  }

  public static Uri a(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues)
  {
    try
    {
      Uri localUri2 = paramContentResolver.insert(paramUri, paramContentValues);
      localUri1 = localUri2;
      return localUri1;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        BLog.d("SqliteWrapper", "Catch a SQLiteException when insert: ", localSQLiteException);
        a(paramContext, localSQLiteException);
        Uri localUri1 = null;
      }
    }
  }

  public static void a(Context paramContext, SQLiteException paramSQLiteException)
  {
    throw paramSQLiteException;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.SqliteWrapper
 * JD-Core Version:    0.6.0
 */