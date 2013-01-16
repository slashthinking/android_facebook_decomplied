package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$DbPrefetchFeedHandlerProvider extends AbstractProvider<DbPrefetchFeedHandler>
{
  private NewsFeedDbModule$DbPrefetchFeedHandlerProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public DbPrefetchFeedHandler a()
  {
    return new DbPrefetchFeedHandler((SQLiteDatabase)b(SQLiteDatabase.class, NewsFeedDb.class), (DbFeedHomeStoriesSerialization)b(DbFeedHomeStoriesSerialization.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.DbPrefetchFeedHandlerProvider
 * JD-Core Version:    0.6.0
 */