package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractProvider;

class ThreadsDbModule$DbCacheProvider extends AbstractProvider<DbCache>
{
  private ThreadsDbModule$DbCacheProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbCache a()
  {
    return new DbCache((ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (DbThreadsPropertyUtil)b(DbThreadsPropertyUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbCacheProvider
 * JD-Core Version:    0.6.0
 */