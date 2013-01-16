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
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;
import com.facebook.content.SecureContentProvider;
import com.facebook.debug.Assert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservedContactsProvider extends SecureContentProvider
{
  public static final Uri a;
  public static final Uri b;
  private static Class<?> c = ObservedContactsProvider.class;
  private static final String d = BuildConstants.b() + ".provider.ObservedContactsProvider";
  private static final String e = "content://" + d + "/";
  private static final Map<String, String> f;
  private static final UriMatcher g;
  private FacebookDatabaseHelper h;

  static
  {
    a = Uri.parse(e + ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTENT.category);
    b = Uri.parse(e + ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTACT_ID.category + ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTACT_ID.uriSuffix);
    g = new UriMatcher(-1);
    for (ObservedContactsProvider.Selectors localSelectors : ObservedContactsProvider.Selectors.values())
    {
      String str = localSelectors.category + localSelectors.uriSuffix + localSelectors.uriMatcherSuffix;
      g.addURI(d, str, localSelectors.uriMatcherIndex());
    }
    f = new HashMap();
    f.put("_id", "_id");
    f.put("contact_id", "contact_id");
    f.put("signature", "signature");
    f.put("timestamp", "timestamp");
  }

  public static String[] a()
  {
    return new String[] { "observed_contacts" };
  }

  public static String[] b()
  {
    return new String[] { "CREATE TABLE observed_contacts (_id INTEGER PRIMARY KEY,contact_id INT,timestamp INT,signature INT);" };
  }

  protected int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int i = g.match(paramUri);
    if (i == ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTENT.uriMatcherIndex());
    String str;
    for (int j = localSQLiteDatabase.update("observed_contacts", paramContentValues, paramString, paramArrayOfString); ; j = localSQLiteDatabase.update("observed_contacts", paramContentValues, "contact_id=" + str, null))
    {
      if (j > 0)
        getContext().getContentResolver().notifyChange(paramUri, null);
      return j;
      if (i != ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTACT_ID.uriMatcherIndex())
        break;
      str = (String)paramUri.getPathSegments().get(2);
    }
    throw new IllegalArgumentException("Unknown URL " + paramUri);
  }

  protected int a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int i = g.match(paramUri);
    if (i == ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTENT.uriMatcherIndex());
    String str;
    for (int j = localSQLiteDatabase.delete("observed_contacts", paramString, paramArrayOfString); ; j = localSQLiteDatabase.delete("observed_contacts", "contact_id=" + str, null))
    {
      if (j > 0)
        getContext().getContentResolver().notifyChange(paramUri, null);
      return j;
      if (i != ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTACT_ID.uriMatcherIndex())
        break;
      str = (String)paramUri.getPathSegments().get(2);
    }
    throw new IllegalArgumentException("Unknown URL " + paramUri);
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    return a(paramUri, paramArrayOfContentValues, null);
  }

  protected int a(Uri paramUri, ContentValues[] paramArrayOfContentValues, List<Uri> paramList)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    int j = g.match(paramUri);
    localSQLiteDatabase.beginTransaction();
    if (j == ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTENT.uriMatcherIndex())
    {
      int k = paramArrayOfContentValues.length;
      int m = 0;
      if (m < k)
      {
        ContentValues localContentValues = paramArrayOfContentValues[m];
        long l = localSQLiteDatabase.insertOrThrow("observed_contacts", "signature", localContentValues);
        if (l > 0L)
        {
          i++;
          if (paramList != null)
            paramList.add(Uri.withAppendedPath(a, Long.toString(l)));
        }
        while (true)
        {
          m++;
          break;
          Log.b(c, "Could not insert into observed_contacts contact id " + localContentValues.getAsInteger("contact_id"));
        }
      }
    }
    else
    {
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    }
    if (i == paramArrayOfContentValues.length)
    {
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
    }
    localSQLiteDatabase.endTransaction();
    throw new SQLException("Failed to insert rows into " + paramUri);
  }

  protected Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    int i = g.match(paramUri);
    String str1;
    if (i == ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTENT.uriMatcherIndex())
    {
      localSQLiteQueryBuilder.setTables("observed_contacts");
      localSQLiteQueryBuilder.setProjectionMap(f);
      str1 = "contact_id ASC";
      if (!TextUtils.isEmpty(paramString2))
        break label197;
    }
    label197: for (String str2 = str1; ; str2 = paramString2)
    {
      Cursor localCursor = localSQLiteQueryBuilder.query(this.h.getWritableDatabase(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, str2, null);
      localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
      return localCursor;
      if (i == ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTACT_ID.uriMatcherIndex())
      {
        localSQLiteQueryBuilder.setTables("observed_contacts");
        localSQLiteQueryBuilder.appendWhereEscapeString("contact_id=" + (String)paramUri.getPathSegments().get(2));
        localSQLiteQueryBuilder.setProjectionMap(f);
        str1 = "contact_id ASC";
        break;
      }
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    }
  }

  protected Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    ContentValues[] arrayOfContentValues = { paramContentValues };
    ArrayList localArrayList = new ArrayList();
    Assert.a(1, a(paramUri, arrayOfContentValues, localArrayList));
    Assert.a(1, localArrayList.size());
    return (Uri)localArrayList.get(0);
  }

  protected String a(Uri paramUri)
  {
    int i = g.match(paramUri);
    if ((i == ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTENT.uriMatcherIndex()) || (i == ObservedContactsProvider.Selectors.OBSERVED_CONTACTS_CONTACT_ID.uriMatcherIndex()))
      return "vnd.android.cursor.item/vnd.com.facebook.katana.provider.observed_contacts";
    throw new IllegalArgumentException("Unknown URL " + paramUri);
  }

  public boolean onCreate()
  {
    this.h = FacebookDatabaseHelper.a(getContext());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.ObservedContactsProvider
 * JD-Core Version:    0.6.0
 */