package com.facebook.orca.background;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.IsMobileAppDataEnabled;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.database.DbUsersPropertyUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class MessagesBackgroundModule$SyncMobileAppDataForTopContactsBackgroundTaskProvider extends AbstractProvider<SyncMobileAppDataForTopContactsBackgroundTask>
{
  private MessagesBackgroundModule$SyncMobileAppDataForTopContactsBackgroundTaskProvider(MessagesBackgroundModule paramMessagesBackgroundModule)
  {
  }

  public SyncMobileAppDataForTopContactsBackgroundTask a()
  {
    return new SyncMobileAppDataForTopContactsBackgroundTask((MeUserAuthDataStore)b(MeUserAuthDataStore.class), a(Boolean.class, IsMobileAppDataEnabled.class), (DbUsersPropertyUtil)b(DbUsersPropertyUtil.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.MessagesBackgroundModule.SyncMobileAppDataForTopContactsBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */