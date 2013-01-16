package com.facebook.orca.background;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesBackgroundModule$AppConfigBackgroundTaskProvider extends AbstractProvider<AppConfigBackgroundTask>
{
  private MessagesBackgroundModule$AppConfigBackgroundTaskProvider(MessagesBackgroundModule paramMessagesBackgroundModule)
  {
  }

  public AppConfigBackgroundTask a()
  {
    return new AppConfigBackgroundTask((MeUserAuthDataStore)b(MeUserAuthDataStore.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.MessagesBackgroundModule.AppConfigBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */