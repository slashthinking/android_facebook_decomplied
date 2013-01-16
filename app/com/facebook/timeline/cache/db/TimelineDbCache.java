package com.facebook.timeline.cache.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.util.Log;
import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.timeline.cache.TimelineCachePlan;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class TimelineDbCache
{
  public static long a;
  private static final Class<?> b = TimelineDbCache.class;
  private SQLiteDatabase c;
  private Clock d;
  private final ObjectMapper e;
  private final UserInteractionController f;

  static
  {
    a = 10485760L;
  }

  public TimelineDbCache(SQLiteDatabase paramSQLiteDatabase, Clock paramClock, ObjectMapper paramObjectMapper, UserInteractionController paramUserInteractionController)
  {
    this.c = paramSQLiteDatabase;
    this.d = paramClock;
    this.e = paramObjectMapper;
    this.f = paramUserInteractionController;
  }

  private Parcelable a(String paramString, Class paramClass)
  {
    Parcelable localParcelable;
    if (paramString == null)
      localParcelable = null;
    while (true)
    {
      return localParcelable;
      try
      {
        JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(paramString);
        localJsonParser.setCodec(this.e);
        localParcelable = (Parcelable)localJsonParser.readValueAs(paramClass);
      }
      catch (IOException localIOException)
      {
        Log.b(b, "Parsing error when read stories from disk cache. Model classes changed recently?  Caused By:\n" + localIOException.toString());
        localParcelable = null;
      }
      catch (JsonParseException localJsonParseException)
      {
        label43: break label43;
      }
    }
  }

  public FetchParcelableResult a(TimelineCachePlan paramTimelineCachePlan)
  {
    this.f.c();
    String[] arrayOfString = { "timestamp", "data" };
    Cursor localCursor = this.c.query("header", arrayOfString, "cachekey=\"" + DatabaseUtils.sqlEscapeString(paramTimelineCachePlan.a()) + "\"", null, null, null, null, null);
    int i = localCursor.getColumnIndex("data");
    int j = localCursor.getColumnIndex("timestamp");
    while (true)
    {
      FetchParcelableResult localFetchParcelableResult;
      try
      {
        if (!localCursor.moveToNext())
          break label263;
        String str = localCursor.getString(i);
        if (str == null)
          break label263;
        long l2 = localCursor.getLong(j);
        localParcelable = a(str, paramTimelineCachePlan.f());
        l1 = l2;
        if (!localCursor.moveToNext())
          continue;
        Log.a(b, "Multiple rows in timeline db with same primary key!");
        localCursor.close();
        localFetchParcelableResult = null;
        if (localParcelable == null)
          return localFetchParcelableResult;
      }
      finally
      {
        localCursor.close();
      }
      Long localLong = Long.valueOf(this.d.a() - l1);
      if (localLong.longValue() < paramTimelineCachePlan.d());
      for (DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE; ; localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_STALE)
      {
        localFetchParcelableResult = new FetchParcelableResult(localParcelable, localDataFreshnessResult, l1);
        break;
        boolean bool = localLong.longValue() < 604800000L;
        localFetchParcelableResult = null;
        if (!bool)
          break;
      }
      label263: long l1 = -1L;
      Parcelable localParcelable = null;
    }
  }

  public void a(String paramString)
  {
    this.c.delete("header", "cachekey=\"" + DatabaseUtils.sqlEscapeString(paramString) + "\"", null);
  }

  public void a(String paramString, Parcelable paramParcelable)
  {
    this.f.c();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("timestamp", Long.valueOf(this.d.a()));
    localContentValues.put("data", this.e.writeValueAsString(paramParcelable));
    localContentValues.put("cachekey", DatabaseUtils.sqlEscapeString(paramString));
    try
    {
      this.c.replaceOrThrow("header", null, localContentValues);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        Log.b(b, "Error while inserting values. Clearing cache.", localSQLiteException);
        this.c.delete("header", null, null);
        this.c.replaceOrThrow("header", null, localContentValues);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.cache.db.TimelineDbCache
 * JD-Core Version:    0.6.0
 */