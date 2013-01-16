package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractProvider;

class ThreadsDbModule$DbFetchThreadHandlerProvider extends AbstractProvider<DbFetchThreadHandler>
{
  private ThreadsDbModule$DbFetchThreadHandlerProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbFetchThreadHandler a()
  {
    return new DbFetchThreadHandler((ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (DbThreadsPropertyUtil)b(DbThreadsPropertyUtil.class), (DbFetchThreadUsersHandler)b(DbFetchThreadUsersHandler.class), (DbParticipantsSerialization)b(DbParticipantsSerialization.class), (DbAttachmentSerialization)b(DbAttachmentSerialization.class), (DbSharesSerialization)b(DbSharesSerialization.class), (DbCoordinatesSerialization)b(DbCoordinatesSerialization.class), (DbMediaResourceSerialization)b(DbMediaResourceSerialization.class), (DbDraftSerialization)b(DbDraftSerialization.class), (DbMessageCache)b(DbMessageCache.class), (DbClock)b(DbClock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbFetchThreadHandlerProvider
 * JD-Core Version:    0.6.0
 */