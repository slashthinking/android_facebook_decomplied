package com.facebook.appcenter.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.appcenter.protocol.FetchAppDetailResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

public class DbAppDetailFetcher
{
  private final AppCenterDatabaseSupplier a;
  private final ObjectMapper b;

  public DbAppDetailFetcher(AppCenterDatabaseSupplier paramAppCenterDatabaseSupplier, ObjectMapper paramObjectMapper)
  {
    Preconditions.checkNotNull(paramAppCenterDatabaseSupplier);
    Preconditions.checkNotNull(paramObjectMapper);
    this.a = paramAppCenterDatabaseSupplier;
    this.b = paramObjectMapper;
  }

  public FetchAppDetailResult a(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.b();
    Cursor localCursor = localSQLiteDatabase.query("appdetails", new String[] { "data" }, "app_id == " + paramString, null, null, null, null);
    while (true)
    {
      try
      {
        if (!localCursor.moveToNext())
          break label192;
        localFetchAppDetailResult1 = (FetchAppDetailResult)this.b.readValue(localCursor.getString(0), FetchAppDetailResult.class);
        localCursor.close();
        if (localFetchAppDetailResult1 == null)
          break label184;
        long l = System.currentTimeMillis() - 300000L;
        if (localFetchAppDetailResult1.f() > l)
        {
          localFetchAppDetailResult2 = new FetchAppDetailResult(localFetchAppDetailResult1.a(), DataFreshnessResult.FROM_CACHE_UP_TO_DATE, localFetchAppDetailResult1.f());
          return localFetchAppDetailResult2;
        }
      }
      finally
      {
        localCursor.close();
      }
      localSQLiteDatabase.delete("appdetails", "app_id = '" + paramString + "'", null);
      FetchAppDetailResult localFetchAppDetailResult2 = FetchAppDetailResult.a;
      continue;
      label184: localFetchAppDetailResult2 = FetchAppDetailResult.a;
      continue;
      label192: FetchAppDetailResult localFetchAppDetailResult1 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.db.DbAppDetailFetcher
 * JD-Core Version:    0.6.0
 */