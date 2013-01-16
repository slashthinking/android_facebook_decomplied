package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$NewsFeedDatabaseProvider extends AbstractProvider<SQLiteDatabase>
{
  private NewsFeedDbModule$NewsFeedDatabaseProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public SQLiteDatabase a()
  {
    return ((NewsFeedDatabaseSupplier)b(NewsFeedDatabaseSupplier.class)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.NewsFeedDatabaseProvider
 * JD-Core Version:    0.6.0
 */