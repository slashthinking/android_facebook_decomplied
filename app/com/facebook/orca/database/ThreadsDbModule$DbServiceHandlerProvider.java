package com.facebook.orca.database;

import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.orca.appconfig.AppConfigSerialization;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.threads.MessagesCollectionMerger;

class ThreadsDbModule$DbServiceHandlerProvider extends AbstractProvider<DbServiceHandler>
{
  private ThreadsDbModule$DbServiceHandlerProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbServiceHandler a()
  {
    return new DbServiceHandler((OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), (DataCache)b(DataCache.class), (DbFetchThreadsHandler)b(DbFetchThreadsHandler.class), (DbFetchThreadHandler)b(DbFetchThreadHandler.class), (DbInsertThreadsHandler)b(DbInsertThreadsHandler.class), (DbInsertThreadUsersHandler)b(DbInsertThreadUsersHandler.class), (DbSendHandler)b(DbSendHandler.class), (DbThreadsPropertyUtil)b(DbThreadsPropertyUtil.class), (ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (AppConfigSerialization)b(AppConfigSerialization.class), (MessagesCollectionMerger)b(MessagesCollectionMerger.class), (OrcaDataManager)b(OrcaDataManager.class), (DbCache)b(DbCache.class), a(Boolean.class, IsClientSmsEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */