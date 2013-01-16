package com.facebook.katana.orca;

import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.katana.settings.AppLoggedOutSettingsManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class FbandroidAppModule$AppLoggedOutSettingsManagerProvider extends AbstractProvider<AppLoggedOutSettingsManager>
{
  private FbandroidAppModule$AppLoggedOutSettingsManagerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public AppLoggedOutSettingsManager a()
  {
    return new AppLoggedOutSettingsManager((UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class), (SingleMethodRunner)b(SingleMethodRunner.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.AppLoggedOutSettingsManagerProvider
 * JD-Core Version:    0.6.0
 */