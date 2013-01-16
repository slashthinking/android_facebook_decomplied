package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractProvider;

class ThreadsDbModule$DbFetchThreadsHandlerProvider extends AbstractProvider<DbFetchThreadsHandler>
{
  private ThreadsDbModule$DbFetchThreadsHandlerProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbFetchThreadsHandler a()
  {
    return new DbFetchThreadsHandler((ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (DbFetchThreadUsersHandler)b(DbFetchThreadUsersHandler.class), (DbThreadsPropertyUtil)b(DbThreadsPropertyUtil.class), (DbParticipantsSerialization)b(DbParticipantsSerialization.class), (DbDraftSerialization)b(DbDraftSerialization.class), (DbClock)b(DbClock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbFetchThreadsHandlerProvider
 * JD-Core Version:    0.6.0
 */