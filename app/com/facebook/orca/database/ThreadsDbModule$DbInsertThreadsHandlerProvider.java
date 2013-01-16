package com.facebook.orca.database;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.threads.MessagesCollectionMerger;
import com.facebook.orca.threads.ThreadSummaryStitching;
import com.facebook.orca.users.User;

class ThreadsDbModule$DbInsertThreadsHandlerProvider extends AbstractProvider<DbInsertThreadsHandler>
{
  private ThreadsDbModule$DbInsertThreadsHandlerProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbInsertThreadsHandler a()
  {
    return new DbInsertThreadsHandler((ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (DbThreadsPropertyUtil)b(DbThreadsPropertyUtil.class), (DbFetchThreadHandler)b(DbFetchThreadHandler.class), (DbParticipantsSerialization)b(DbParticipantsSerialization.class), (DbAttachmentSerialization)b(DbAttachmentSerialization.class), (DbSharesSerialization)b(DbSharesSerialization.class), (DbCoordinatesSerialization)b(DbCoordinatesSerialization.class), (DbMediaResourceSerialization)b(DbMediaResourceSerialization.class), (DbDraftSerialization)b(DbDraftSerialization.class), (MessagesCollectionMerger)b(MessagesCollectionMerger.class), a(User.class, MeUser.class), (ThreadSummaryStitching)b(ThreadSummaryStitching.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbInsertThreadsHandlerProvider
 * JD-Core Version:    0.6.0
 */