package com.facebook.feed.module;

import com.facebook.feed.db.NewsFeedDatabaseInitializer;
import com.facebook.feed.db.NewsFeedDbOpenHelper;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedDatabaseInitializerProvider extends AbstractProvider<NewsFeedDatabaseInitializer>
{
  private NewsFeedModule$NewsFeedDatabaseInitializerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedDatabaseInitializer a()
  {
    return new NewsFeedDatabaseInitializer(NewsFeedModule.a(this.a), (NewsFeedDbOpenHelper)b(NewsFeedDbOpenHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedDatabaseInitializerProvider
 * JD-Core Version:    0.6.0
 */