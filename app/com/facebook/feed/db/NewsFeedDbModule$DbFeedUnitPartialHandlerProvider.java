package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$DbFeedUnitPartialHandlerProvider extends AbstractProvider<DbFeedUnitPartialHandler>
{
  private NewsFeedDbModule$DbFeedUnitPartialHandlerProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public DbFeedUnitPartialHandler a()
  {
    return new DbFeedUnitPartialHandler((SQLiteDatabase)b(SQLiteDatabase.class, NewsFeedDb.class), (DbFeedStoryPartialSerialization)b(DbFeedStoryPartialSerialization.class), (DbPagesYouMayLikeFeedUnitPartialSerialization)b(DbPagesYouMayLikeFeedUnitPartialSerialization.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.DbFeedUnitPartialHandlerProvider
 * JD-Core Version:    0.6.0
 */