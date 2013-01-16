package com.facebook.orca.background;

import com.facebook.orca.annotations.CurrentFolderType;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.DbCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.threads.FolderType;

class MessagesBackgroundModule$FetchTheadListBackgroundTaskProvider extends AbstractProvider<FetchThreadListBackgroundTask>
{
  private MessagesBackgroundModule$FetchTheadListBackgroundTaskProvider(MessagesBackgroundModule paramMessagesBackgroundModule)
  {
  }

  public FetchThreadListBackgroundTask a()
  {
    return new FetchThreadListBackgroundTask((MeUserAuthDataStore)b(MeUserAuthDataStore.class), a(FolderType.class, CurrentFolderType.class), (DbCache)b(DbCache.class), (DataCache)b(DataCache.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.MessagesBackgroundModule.FetchTheadListBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */