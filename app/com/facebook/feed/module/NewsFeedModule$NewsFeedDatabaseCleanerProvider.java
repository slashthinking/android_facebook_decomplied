package com.facebook.feed.module;

import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.db.NewsFeedDatabaseSupplier;
import com.facebook.feed.db.NewsFeedUserDataCleaner;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedDatabaseCleanerProvider extends AbstractProvider<NewsFeedUserDataCleaner>
{
  private NewsFeedModule$NewsFeedDatabaseCleanerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedUserDataCleaner a()
  {
    return new NewsFeedUserDataCleaner((NewsFeedDatabaseSupplier)b(NewsFeedDatabaseSupplier.class), (NewsFeedCache)b(NewsFeedCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedDatabaseCleanerProvider
 * JD-Core Version:    0.6.0
 */