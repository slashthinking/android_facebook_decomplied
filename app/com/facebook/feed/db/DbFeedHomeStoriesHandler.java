package com.facebook.feed.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.protocol.FetchNewsFeedParamsBuilder;
import com.facebook.feed.protocol.FetchNewsFeedResult;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class DbFeedHomeStoriesHandler
{
  private static final Class<DbFeedHomeStoriesHandler> a = DbFeedHomeStoriesHandler.class;
  private static final String[] b;
  private final SQLiteDatabase c;
  private final DbFeedHomeStoriesSerialization d;
  private final UserInteractionController e;
  private final ExecutorService f;
  private final PerformanceLogger g;
  private int h;

  static
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.b.toString();
    arrayOfString[1] = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.c.toString();
    arrayOfString[2] = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.d.toString();
    arrayOfString[3] = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.e.toString();
    b = arrayOfString;
  }

  public DbFeedHomeStoriesHandler(@NewsFeedDb SQLiteDatabase paramSQLiteDatabase, DbFeedHomeStoriesSerialization paramDbFeedHomeStoriesSerialization, ExecutorService paramExecutorService, UserInteractionController paramUserInteractionController, PerformanceLogger paramPerformanceLogger)
  {
    this.c = ((SQLiteDatabase)Preconditions.checkNotNull(paramSQLiteDatabase));
    this.d = ((DbFeedHomeStoriesSerialization)Preconditions.checkNotNull(paramDbFeedHomeStoriesSerialization));
    this.f = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
    this.h = 10;
    this.e = ((UserInteractionController)Preconditions.checkNotNull(paramUserInteractionController));
    this.g = paramPerformanceLogger;
  }

  private List<FeedUnitEdge> a(FeedHomeStories paramFeedHomeStories1, FeedHomeStories paramFeedHomeStories2)
  {
    return ImmutableList.e().b(paramFeedHomeStories1.feedUnitEdges).b(paramFeedHomeStories2.feedUnitEdges).b();
  }

  private DbFeedResult b(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("home_stories");
    SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
    localAndExpression.a(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.a.a(paramFetchNewsFeedParams.f().toString()));
    NewsFeedDbOpenHelper.Column localColumn = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.c;
    String str;
    if (paramFetchNewsFeedParams.d() == null)
      str = "empty_cursor";
    while (true)
    {
      localAndExpression.a(localColumn.a(str));
      Cursor localCursor = localSQLiteQueryBuilder.query(this.c, b, localAndExpression.a(), localAndExpression.b(), null, null, NewsFeedDbOpenHelper.Column.a.a());
      int i = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.e.a(localCursor);
      int j = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.b.a(localCursor);
      try
      {
        if (localCursor.moveToNext())
        {
          localDbFeedResult = new DbFeedResult(this.d.a(localCursor.getString(i)), localCursor.getLong(j));
          return localDbFeedResult;
          str = paramFetchNewsFeedParams.d();
          continue;
        }
        localCursor.close();
        DbFeedResult localDbFeedResult = DbFeedResult.a;
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  FetchNewsFeedResult a(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    monitorenter;
    try
    {
      boolean bool;
      DbFeedResult localDbFeedResult1;
      FeedHomeStories localFeedHomeStories;
      if (paramFetchNewsFeedParams.c() == null)
      {
        bool = true;
        Preconditions.checkArgument(bool, "before cursor should be null");
        this.g.a("NNFDbFeedLoadStories1stPass");
        this.e.c();
        localDbFeedResult1 = b(paramFetchNewsFeedParams);
        this.g.b("NNFDbFeedLoadStories1stPass");
        if (!localDbFeedResult1.a())
          break label258;
        localFeedHomeStories = localDbFeedResult1.b;
        if (localDbFeedResult1.b.feedUnitEdges.size() < paramFetchNewsFeedParams.b())
        {
          FetchNewsFeedParams localFetchNewsFeedParams = FetchNewsFeedParams.newBuilder().e(localDbFeedResult1.b.pageInfo.endCursor).b(paramFetchNewsFeedParams.f()).b(paramFetchNewsFeedParams.e()).c();
          this.g.a("NNFDbFeedLoadStories2ndPass");
          DbFeedResult localDbFeedResult2 = b(localFetchNewsFeedParams);
          this.g.b("NNFDbFeedLoadStories2ndPass");
          if (localDbFeedResult2.a())
            localFeedHomeStories = new FeedHomeStories(a(localDbFeedResult1.b, localDbFeedResult2.b), new GraphQLPageInfo(localDbFeedResult1.b.pageInfo.startCursor, localDbFeedResult2.b.pageInfo.endCursor, localDbFeedResult1.b.pageInfo.hasPreviousPage, localDbFeedResult2.b.pageInfo.hasNextPage));
        }
      }
      label258: for (FetchNewsFeedResult localFetchNewsFeedResult = new FetchNewsFeedResult(paramFetchNewsFeedParams, localFeedHomeStories, DataFreshnessResult.FROM_CACHE_STALE, localDbFeedResult1.c); ; localFetchNewsFeedResult = FetchNewsFeedResult.a)
      {
        return localFetchNewsFeedResult;
        bool = false;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(NewsFeedType paramNewsFeedType, List<String> paramList)
  {
    SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
    localAndExpression.a(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.a.a(paramNewsFeedType.toString()));
    localAndExpression.a(SqlQueryBuilder.a(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.d.toString() + " NOT IN " + SqlUtil.b(paramList)));
    this.c.delete("home_stories", localAndExpression.a(), localAndExpression.b());
  }

  void a(FetchNewsFeedResult paramFetchNewsFeedResult)
  {
    this.f.submit(new DbFeedHomeStoriesHandler.1(this, paramFetchNewsFeedResult));
  }

  void b(FetchNewsFeedResult paramFetchNewsFeedResult)
  {
    monitorenter;
    while (true)
    {
      FetchNewsFeedParams localFetchNewsFeedParams;
      FeedHomeStories localFeedHomeStories1;
      FeedHomeStories localFeedHomeStories3;
      try
      {
        this.e.c();
        this.c.beginTransaction();
        try
        {
          localFetchNewsFeedParams = paramFetchNewsFeedResult.b;
          NewsFeedType localNewsFeedType = localFetchNewsFeedParams.f();
          localFeedHomeStories1 = paramFetchNewsFeedResult.c;
          if ((localFetchNewsFeedParams.c() == null) || (localFeedHomeStories1.pageInfo.hasNextPage))
            break label634;
          localFeedHomeStories3 = new FeedHomeStories(localFeedHomeStories1.feedUnitEdges, new GraphQLPageInfo(localFeedHomeStories1.pageInfo.startCursor, localFeedHomeStories1.pageInfo.endCursor, localFeedHomeStories1.pageInfo.hasPreviousPage, true));
          SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
          localAndExpression.a(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.d.a(localFetchNewsFeedParams.c()));
          localAndExpression.a(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.a.a(localNewsFeedType.toString()));
          SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
          localSQLiteQueryBuilder.setTables("home_stories");
          Cursor localCursor = localSQLiteQueryBuilder.query(this.c, b, localAndExpression.a(), localAndExpression.b(), null, null, NewsFeedDbOpenHelper.Column.a.a());
          try
          {
            if (!localCursor.moveToNext())
              break label627;
            int i = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.e.a(localCursor);
            FeedHomeStories localFeedHomeStories5 = this.d.a(localCursor.getString(i));
            if (localFeedHomeStories5 == null)
              break label627;
            if (localFeedHomeStories5.feedUnitEdges.size() < this.h)
              continue;
            ContentValues localContentValues2 = new ContentValues();
            localContentValues2.put(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.c.toString(), localFeedHomeStories3.pageInfo.endCursor);
            this.c.update("home_stories", localContentValues2, localAndExpression.a(), localAndExpression.b());
            localFeedHomeStories4 = localFeedHomeStories3;
            localCursor.close();
            localFeedHomeStories2 = localFeedHomeStories4;
            ContentValues localContentValues1 = new ContentValues();
            localContentValues1.put(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.a.toString(), paramFetchNewsFeedResult.b.f().toString());
            localContentValues1.put(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.b.toString(), Long.valueOf(paramFetchNewsFeedResult.f()));
            String str1 = NewsFeedDbOpenHelper.HomeStoriesTable.Columns.c.toString();
            if (localFetchNewsFeedParams.d() == null)
            {
              localObject3 = "empty_cursor";
              localContentValues1.put(str1, (String)localObject3);
              localContentValues1.put(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.d.toString(), localFeedHomeStories2.pageInfo.startCursor);
              localContentValues1.put(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.e.toString(), this.d.a(localFeedHomeStories2));
              long l = this.c.insertOrThrow("home_stories", "", localContentValues1);
              if (l % 5L != 0L)
                continue;
              SqlQueryBuilder.Expression localExpression = NewsFeedDbOpenHelper.Column.a.b(String.valueOf(l - 10L));
              this.c.delete("home_stories", localExpression.a(), localExpression.b());
              this.c.setTransactionSuccessful();
              this.c.endTransaction();
              monitorexit;
              return;
              this.c.delete("home_stories", localAndExpression.a(), localAndExpression.b());
              localFeedHomeStories4 = new FeedHomeStories(a(localFeedHomeStories3, localFeedHomeStories5), new GraphQLPageInfo(localFeedHomeStories3.pageInfo.startCursor, localFeedHomeStories5.pageInfo.endCursor, localFeedHomeStories3.pageInfo.hasPreviousPage, localFeedHomeStories5.pageInfo.hasNextPage));
              continue;
            }
          }
          finally
          {
            localCursor.close();
          }
        }
        finally
        {
          this.c.endTransaction();
        }
      }
      finally
      {
        monitorexit;
      }
      String str2 = localFetchNewsFeedParams.d();
      Object localObject3 = str2;
      continue;
      label627: FeedHomeStories localFeedHomeStories4 = localFeedHomeStories3;
      continue;
      label634: FeedHomeStories localFeedHomeStories2 = localFeedHomeStories1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbFeedHomeStoriesHandler
 * JD-Core Version:    0.6.0
 */