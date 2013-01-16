package com.facebook.appcenter.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.protocol.FetchAppDetailResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

public class DbAppDetailInserter
{
  private static final Class<?> a = DbAppDetailInserter.class;
  private final ObjectMapper b;
  private final AppCenterDatabaseSupplier c;

  @Inject
  public DbAppDetailInserter(AppCenterDatabaseSupplier paramAppCenterDatabaseSupplier, ObjectMapper paramObjectMapper)
  {
    this.c = paramAppCenterDatabaseSupplier;
    this.b = paramObjectMapper;
  }

  public void a(AppDetail paramAppDetail)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.b();
    ContentValues localContentValues = new ContentValues();
    FetchAppDetailResult localFetchAppDetailResult = new FetchAppDetailResult(paramAppDetail, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, System.currentTimeMillis());
    localContentValues.put("app_id", paramAppDetail.id);
    localContentValues.put("data", this.b.writeValueAsString(localFetchAppDetailResult));
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.replaceOrThrow("appdetails", null, localContentValues);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.db.DbAppDetailInserter
 * JD-Core Version:    0.6.0
 */