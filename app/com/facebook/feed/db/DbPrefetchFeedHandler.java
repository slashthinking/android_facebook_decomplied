package com.facebook.feed.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.google.common.base.Preconditions;

public class DbPrefetchFeedHandler
{
  private static final String[] a;
  private final SQLiteDatabase b;
  private final DbFeedHomeStoriesSerialization c;
  private final AndroidThreadUtil d;

  static
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.b.toString();
    arrayOfString[1] = NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.d.toString();
    a = arrayOfString;
  }

  public DbPrefetchFeedHandler(@NewsFeedDb SQLiteDatabase paramSQLiteDatabase, DbFeedHomeStoriesSerialization paramDbFeedHomeStoriesSerialization, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.b = ((SQLiteDatabase)Preconditions.checkNotNull(paramSQLiteDatabase));
    this.c = ((DbFeedHomeStoriesSerialization)Preconditions.checkNotNull(paramDbFeedHomeStoriesSerialization));
    this.d = ((AndroidThreadUtil)Preconditions.checkNotNull(paramAndroidThreadUtil));
  }

  public FetchNewsFeedResult a(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    this.d.b();
    Preconditions.checkNotNull(paramFetchNewsFeedParams.c());
    boolean bool;
    Cursor localCursor;
    int i;
    int j;
    DbFeedResult localDbFeedResult1;
    if (paramFetchNewsFeedParams.d() == null)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
      localAndExpression.a(NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.a.a(paramFetchNewsFeedParams.f().toString()));
      localAndExpression.a(NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.c.a(paramFetchNewsFeedParams.c()));
      SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
      localSQLiteQueryBuilder.setTables("prefetched_feed");
      localCursor = localSQLiteQueryBuilder.query(this.b, a, localAndExpression.a(), localAndExpression.b(), null, null, null);
      i = NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.d.a(localCursor);
      j = NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.b.a(localCursor);
      localDbFeedResult1 = DbFeedResult.a;
    }
    while (true)
    {
      FetchNewsFeedResult localFetchNewsFeedResult;
      try
      {
        if (!localCursor.moveToNext())
          break label250;
        DbFeedResult localDbFeedResult2 = new DbFeedResult(this.c.a(localCursor.getString(i)), localCursor.getLong(j));
        localDbFeedResult3 = localDbFeedResult2;
        localCursor.close();
        if (localDbFeedResult3.a())
        {
          return localFetchNewsFeedResult;
          bool = false;
        }
      }
      finally
      {
        localCursor.close();
      }
      continue;
      label250: DbFeedResult localDbFeedResult3 = localDbFeedResult1;
    }
  }

  public void a(NewsFeedType paramNewsFeedType)
  {
    this.d.b();
    SqlQueryBuilder.Expression localExpression = NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.a.a(paramNewsFeedType.toString());
    this.b.delete("prefetched_feed", localExpression.a(), localExpression.b());
  }

  public void a(FetchNewsFeedResult paramFetchNewsFeedResult)
  {
    this.d.b();
    FetchNewsFeedParams localFetchNewsFeedParams = paramFetchNewsFeedResult.b;
    Preconditions.checkNotNull(localFetchNewsFeedParams.c());
    boolean bool;
    ContentValues localContentValues;
    String str1;
    if (localFetchNewsFeedParams.d() == null)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      localContentValues = new ContentValues();
      localContentValues.put(NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.a.toString(), localFetchNewsFeedParams.f().toString());
      localContentValues.put(NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.b.toString(), Long.valueOf(paramFetchNewsFeedResult.f()));
      str1 = NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.c.toString();
      if (localFetchNewsFeedParams.c() != null)
        break label153;
    }
    label153: for (String str2 = "empty_cursor"; ; str2 = localFetchNewsFeedParams.c())
    {
      localContentValues.put(str1, str2);
      localContentValues.put(NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.d.toString(), this.c.a(paramFetchNewsFeedResult.c));
      this.b.replaceOrThrow("prefetched_feed", "", localContentValues);
      return;
      bool = false;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbPrefetchFeedHandler
 * JD-Core Version:    0.6.0
 */