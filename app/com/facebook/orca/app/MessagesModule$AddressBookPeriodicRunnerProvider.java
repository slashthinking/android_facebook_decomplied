package com.facebook.orca.app;

import android.app.AlarmManager;
import com.facebook.background.AreBackgroundTasksEnabled;
import com.facebook.contacts.annotations.IsRolodexPickerEnabled;
import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.IsContactsDownloadPermitted;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.AddressBookPeriodicRunner;
import com.facebook.orca.database.DbUsersPropertyUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import java.util.concurrent.ExecutorService;

class MessagesModule$AddressBookPeriodicRunnerProvider extends AbstractProvider<AddressBookPeriodicRunner>
{
  private MessagesModule$AddressBookPeriodicRunnerProvider(MessagesModule paramMessagesModule)
  {
  }

  public AddressBookPeriodicRunner a()
  {
    return new AddressBookPeriodicRunner(MessagesModule.a(this.a), (AlarmManager)b(AlarmManager.class, FromApplication.class), (DbUsersPropertyUtil)b(DbUsersPropertyUtil.class), (DbContactsPropertyUtil)b(DbContactsPropertyUtil.class), (MeUserAuthDataStore)b(MeUserAuthDataStore.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (Clock)b(Clock.class), (ExecutorService)b(ExecutorService.class, DefaultExecutorService.class), a(Boolean.class, AreBackgroundTasksEnabled.class), a(Boolean.class, IsContactsDownloadPermitted.class), a(Boolean.class, IsRolodexPickerEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AddressBookPeriodicRunnerProvider
 * JD-Core Version:    0.6.0
 */