package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractProvider;

class ThreadsDbModule$DbThreadsPropertyUtilProvider extends AbstractProvider<DbThreadsPropertyUtil>
{
  private ThreadsDbModule$DbThreadsPropertyUtilProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbThreadsPropertyUtil a()
  {
    return new DbThreadsPropertyUtil((ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbThreadsPropertyUtilProvider
 * JD-Core Version:    0.6.0
 */