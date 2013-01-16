package com.facebook.feed.db;

import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.orca.app.IHaveUserData;

public class NewsFeedUserDataCleaner
  implements IHaveUserData
{
  private NewsFeedDatabaseSupplier a;
  private NewsFeedCache b;

  public NewsFeedUserDataCleaner(NewsFeedDatabaseSupplier paramNewsFeedDatabaseSupplier, NewsFeedCache paramNewsFeedCache)
  {
    this.a = paramNewsFeedDatabaseSupplier;
    this.b = paramNewsFeedCache;
  }

  public void a(NewsFeedUserDataCleaner.StoreType paramStoreType)
  {
    if (NewsFeedUserDataCleaner.StoreType.Memory.equals(paramStoreType))
      this.b.a();
    if (NewsFeedUserDataCleaner.StoreType.Disk.equals(paramStoreType))
      this.a.b();
  }

  public void f()
  {
    a(NewsFeedUserDataCleaner.StoreType.Memory);
    a(NewsFeedUserDataCleaner.StoreType.Disk);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedUserDataCleaner
 * JD-Core Version:    0.6.0
 */