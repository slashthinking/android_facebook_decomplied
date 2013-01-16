package com.facebook.orca.app;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.prefs.GlobalNotificationPrefsSynchronizer;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesModule$GlobalNotificationPrefsSynchronizerProvider extends AbstractProvider<GlobalNotificationPrefsSynchronizer>
{
  private MessagesModule$GlobalNotificationPrefsSynchronizerProvider(MessagesModule paramMessagesModule)
  {
  }

  public GlobalNotificationPrefsSynchronizer a()
  {
    return new GlobalNotificationPrefsSynchronizer((MeUserAuthDataStore)b(MeUserAuthDataStore.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaServiceOperation)b(OrcaServiceOperation.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.GlobalNotificationPrefsSynchronizerProvider
 * JD-Core Version:    0.6.0
 */