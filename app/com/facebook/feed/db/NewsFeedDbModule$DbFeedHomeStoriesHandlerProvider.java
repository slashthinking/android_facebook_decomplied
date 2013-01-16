package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.inject.AbstractProvider;
import java.util.concurrent.ExecutorService;

class NewsFeedDbModule$DbFeedHomeStoriesHandlerProvider extends AbstractProvider<DbFeedHomeStoriesHandler>
{
  private NewsFeedDbModule$DbFeedHomeStoriesHandlerProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public DbFeedHomeStoriesHandler a()
  {
    return new DbFeedHomeStoriesHandler((SQLiteDatabase)b(SQLiteDatabase.class, NewsFeedDb.class), (DbFeedHomeStoriesSerialization)b(DbFeedHomeStoriesSerialization.class), (ExecutorService)b(ExecutorService.class, DefaultExecutorService.class), (UserInteractionController)b(UserInteractionController.class), (PerformanceLogger)b(PerformanceLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.DbFeedHomeStoriesHandlerProvider
 * JD-Core Version:    0.6.0
 */