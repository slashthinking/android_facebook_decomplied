package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.ErrorReporting;
import com.facebook.content.SecureContentProvider;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserValuesProvider extends SecureContentProvider
{
  public static final String a;
  public static final Uri b;
  public static final Uri c;
  private static final String[] d = { "value" };
  private static final HashMap<String, String> e;
  private static final UriMatcher f;
  private FacebookDatabaseHelper g;
  private FbInjector h;
  private boolean i;

  static
  {
    a = BuildConstants.b() + ".provider.UserValuesProvider";
    b = Uri.parse("content://" + a + "/" + "user_values");
    c = Uri.parse("content://" + a + "/" + "user_values" + "/name");
    f = new UriMatcher(-1);
    f.addURI(a, "user_values", 1);
    f.addURI(a, "user_values/name/*", 2);
    e = new HashMap();
    e.put("_id", "_id");
    e.put("name", "name");
    e.put("value", "value");
  }

  public static String a()
  {
    return "user_values";
  }

  private Cursor b(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    switch (f.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
      localSQLiteQueryBuilder.setTables("user_values");
      localSQLiteQueryBuilder.setProjectionMap(e);
      if (!TextUtils.isEmpty(paramString2))
        break;
    case 2:
    }
    for (String str = "name DESC"; ; str = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.g.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      localSQLiteQueryBuilder.setTables("user_values");
      localSQLiteQueryBuilder.appendWhere("name='" + (String)paramUri.getPathSegments().get(2) + "'");
      break;
    }
  }

  public static String b()
  {
    return "CREATE TABLE user_values (_id INTEGER PRIMARY KEY,name TEXT,value TEXT);";
  }

  private void c()
  {
    monitorenter;
    try
    {
      boolean bool = this.i;
      if (bool);
      while (true)
      {
        return;
        this.h = FbInjector.a(getContext());
        this.i = true;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private String d(Uri paramUri, String paramString)
  {
    if (paramUri != null);
    String str;
    switch (f.match(paramUri))
    {
    default:
      str = null;
    case 1:
    case 2:
    }
    while (true)
    {
      return str;
      if (!"name='active_session_info'".equals(paramString))
        break;
      str = "active_session_info";
      continue;
      str = paramUri.getLastPathSegment();
    }
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.g.getWritableDatabase();
    switch (f.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    String str;
    for (int j = localSQLiteDatabase.delete("user_values", paramString, paramArrayOfString); ; j = localSQLiteDatabase.delete("user_values", "name=" + str, null))
    {
      getContext().getContentResolver().notifyChange(paramUri, null, false);
      return j;
      str = (String)paramUri.getPathSegments().get(1);
    }
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    String str1 = d(paramUri, paramString1);
    if (str1 != null)
    {
      c();
      ((AppInitLock)this.h.a(AppInitLock.class)).b();
      String str2 = ((OrcaSharedPreferences)this.h.a(OrcaSharedPreferences.class)).a((PrefKey)FbandroidPrefKeys.f.c(str1), null);
      Object localObject;
      if (str2 == null)
        localObject = b(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      while (true)
      {
        return localObject;
        if (paramArrayOfString1 == null)
          paramArrayOfString1 = d;
        ArrayList localArrayList = new ArrayList();
        int j = paramArrayOfString1.length;
        int k = 0;
        if (k < j)
        {
          String str3 = paramArrayOfString1[k];
          if ("name".equals(str3))
            localArrayList.add(str1);
          while (true)
          {
            k++;
            break;
            if (!"value".equals(str3))
              break label166;
            localArrayList.add(str2);
          }
          label166: throw new IllegalArgumentException("Only name and value are supported in the projection map");
        }
        localObject = new MatrixCursor(paramArrayOfString1);
        ((MatrixCursor)localObject).addRow(localArrayList.toArray());
      }
    }
    throw new IllegalArgumentException("Unknown URL " + paramUri);
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (paramContentValues != null);
    for (ContentValues localContentValues = new ContentValues(paramContentValues); f.match(paramUri) != 1; localContentValues = new ContentValues())
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    long l = this.g.getWritableDatabase().insert("user_values", "name", localContentValues);
    Uri localUri;
    if (l > 0L)
    {
      localUri = Uri.withAppendedPath(b, Long.valueOf(l).toString());
      getContext().getContentResolver().notifyChange(paramUri, null, false);
    }
    while (true)
    {
      ErrorReporting.a("UserValuesProvider", "UserValuesProvider should not create any new entry in old table", true);
      return localUri;
      localUri = null;
    }
  }

  protected String a(Uri paramUri)
  {
    switch (f.match(paramUri))
    {
    default:
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 1:
    case 2:
    }
    return "vnd.android.cursor.item/vnd.facebook.katana.uservalues";
  }

  public boolean onCreate()
  {
    this.g = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.UserValuesProvider
 * JD-Core Version:    0.6.0
 */