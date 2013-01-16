package com.facebook.feed.db;

import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$NewsFeedDatabaseOpenHelperProvider extends AbstractProvider<NewsFeedDbOpenHelper>
{
  private NewsFeedDbModule$NewsFeedDatabaseOpenHelperProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public NewsFeedDbOpenHelper a()
  {
    return new NewsFeedDbOpenHelper(NewsFeedDbModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.NewsFeedDatabaseOpenHelperProvider
 * JD-Core Version:    0.6.0
 */