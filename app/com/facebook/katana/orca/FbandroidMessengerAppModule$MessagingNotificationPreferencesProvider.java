package com.facebook.katana.orca;

import android.preference.PreferenceManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.notify.MessagingNotificationPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class FbandroidMessengerAppModule$MessagingNotificationPreferencesProvider extends AbstractProvider<MessagingNotificationPreferences>
{
  private FbandroidMessengerAppModule$MessagingNotificationPreferencesProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public MessagingNotificationPreferences a()
  {
    return new FbAndroidMessagingNotificationPreferences(PreferenceManager.getDefaultSharedPreferences(FbandroidMessengerAppModule.a(this.a)), (OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.MessagingNotificationPreferencesProvider
 * JD-Core Version:    0.6.0
 */