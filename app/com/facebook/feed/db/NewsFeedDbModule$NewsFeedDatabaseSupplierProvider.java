package com.facebook.feed.db;

import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$NewsFeedDatabaseSupplierProvider extends AbstractProvider<NewsFeedDatabaseSupplier>
{
  private NewsFeedDbModule$NewsFeedDatabaseSupplierProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public NewsFeedDatabaseSupplier a()
  {
    return new NewsFeedDatabaseSupplier((NewsFeedDbOpenHelper)b(NewsFeedDbOpenHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.NewsFeedDatabaseSupplierProvider
 * JD-Core Version:    0.6.0
 */