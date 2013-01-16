package com.facebook.analytics;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsStorage
{
  private static final String[] a = { "id", "sid", "uid", "seq", "timestamp", "active", "meta" };
  private static final String[] b = { "data", "timestamp" };
  private static final String[] c = { "timestamp" };
  private final AnalyticsDatabaseSupplier d;

  public AnalyticsStorage(AnalyticsDatabaseSupplier paramAnalyticsDatabaseSupplier)
  {
    this.d = paramAnalyticsDatabaseSupplier;
  }

  public void a()
  {
    SQLiteDatabase localSQLiteDatabase = this.d.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("active", Integer.valueOf(0));
      localSQLiteDatabase.update("batches", localContentValues, null, null);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  public void a(AnalyticsEvent paramAnalyticsEvent, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.d.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("bid", paramString);
    localContentValues.put("type", paramAnalyticsEvent.a());
    localContentValues.put("data", paramAnalyticsEvent.e().toString());
    localContentValues.put("timestamp", Long.valueOf(paramAnalyticsEvent.b()));
    localSQLiteDatabase.insert("events", null, localContentValues);
  }

  public void a(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.d.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.delete("events", "bid=?", new String[] { paramString });
      localSQLiteDatabase.delete("batches", "id=?", new String[] { paramString });
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  public void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    SQLiteDatabase localSQLiteDatabase = this.d.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      a();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("id", paramString1);
      localContentValues.put("sid", paramString2);
      localContentValues.put("uid", paramString3);
      localContentValues.put("seq", Long.valueOf(paramLong1));
      localContentValues.put("timestamp", Long.valueOf(paramLong2));
      localContentValues.put("active", Integer.valueOf(1));
      localSQLiteDatabase.insert("batches", null, localContentValues);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  public int b()
  {
    Cursor localCursor = this.d.b().query("events", c, null, null, null, null, null);
    try
    {
      int i = localCursor.getCount();
      return i;
    }
    finally
    {
      localCursor.close();
    }
  }

  public String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    SQLiteDatabase localSQLiteDatabase = this.d.b();
    localSQLiteDatabase.beginTransaction();
    Cursor localCursor;
    try
    {
      localCursor = localSQLiteDatabase.query("events", b, "bid=?", new String[] { paramString }, null, null, "timestamp");
    }
    finally
    {
      try
      {
        if (!localCursor.moveToNext())
          break label110;
        String str = localCursor.getString(0);
        if (localStringBuilder.length() > 0)
          localStringBuilder.append(",");
        localStringBuilder.append(str);
      }
      finally
      {
        localCursor.close();
      }
      localSQLiteDatabase.endTransaction();
    }
    label110: localCursor.close();
    localSQLiteDatabase.endTransaction();
    return localStringBuilder.toString();
  }

  public List<AnalyticsStorage.EventBatchInfo> c()
  {
    ArrayList localArrayList = new ArrayList();
    SQLiteDatabase localSQLiteDatabase = this.d.b();
    localSQLiteDatabase.beginTransaction();
    Cursor localCursor;
    while (true)
    {
      try
      {
        d();
        localCursor = localSQLiteDatabase.query("batches", a, "active=0", null, null, null, "timestamp");
      }
      finally
      {
        try
        {
          if (!localCursor.moveToNext())
            break;
          String str1 = localCursor.getString(0);
          String str2 = localCursor.getString(1);
          String str3 = localCursor.getString(2);
          long l1 = localCursor.getLong(3);
          long l2 = localCursor.getLong(4);
          if (localCursor.getInt(5) > 0)
          {
            bool = true;
            localArrayList.add(new AnalyticsStorage.EventBatchInfo(this, str1, str2, l2, str3, l1, bool));
          }
        }
        finally
        {
          localCursor.close();
          localSQLiteDatabase.setTransactionSuccessful();
        }
      }
      boolean bool = false;
    }
    localCursor.close();
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
    return localArrayList;
  }

  public void d()
  {
    long l = System.currentTimeMillis() - 129600000L;
    SQLiteDatabase localSQLiteDatabase = this.d.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = Long.toString(l);
      localSQLiteDatabase.delete("events", "timestamp<?", arrayOfString1);
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = Long.toString(l);
      localSQLiteDatabase.delete("batches", "timestamp<?", arrayOfString2);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsStorage
 * JD-Core Version:    0.6.2
 */