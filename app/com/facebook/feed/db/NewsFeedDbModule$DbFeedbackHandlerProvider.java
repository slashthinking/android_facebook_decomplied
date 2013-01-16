package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$DbFeedbackHandlerProvider extends AbstractProvider<DbFeedbackHandler>
{
  private NewsFeedDbModule$DbFeedbackHandlerProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public DbFeedbackHandler a()
  {
    return new DbFeedbackHandler((SQLiteDatabase)b(SQLiteDatabase.class, NewsFeedDb.class), (DbFeedbackSerialization)b(DbFeedbackSerialization.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.DbFeedbackHandlerProvider
 * JD-Core Version:    0.6.0
 */