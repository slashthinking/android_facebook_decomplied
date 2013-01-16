package com.facebook.orca.background;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.IsLastActiveEnabled;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.database.DbUsersPropertyUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class MessagesBackgroundModule$SyncLastActiveForTopContactsBackgroundTaskProvider extends AbstractProvider<SyncLastActiveForTopContactsBackgroundTask>
{
  private MessagesBackgroundModule$SyncLastActiveForTopContactsBackgroundTaskProvider(MessagesBackgroundModule paramMessagesBackgroundModule)
  {
  }

  public SyncLastActiveForTopContactsBackgroundTask a()
  {
    return new SyncLastActiveForTopContactsBackgroundTask((MeUserAuthDataStore)b(MeUserAuthDataStore.class), a(Boolean.class, IsLastActiveEnabled.class), (DbUsersPropertyUtil)b(DbUsersPropertyUtil.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.MessagesBackgroundModule.SyncLastActiveForTopContactsBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */