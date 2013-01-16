package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractProvider;

class ThreadsDbModule$DbSendHandlerProvider extends AbstractProvider<DbSendHandler>
{
  private ThreadsDbModule$DbSendHandlerProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbSendHandler a()
  {
    return new DbSendHandler((ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (DbInsertThreadsHandler)b(DbInsertThreadsHandler.class), (DbFetchThreadHandler)b(DbFetchThreadHandler.class), (DbCache)b(DbCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbSendHandlerProvider
 * JD-Core Version:    0.6.0
 */