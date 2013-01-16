package com.facebook.katana.orca;

import android.content.pm.PackageInfo;
import android.telephony.TelephonyManager;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.config.OrcaProductionConfig;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidMessengerAppModule$OrcaProductionConfigProvider extends AbstractProvider<OrcaProductionConfig>
{
  private FbandroidMessengerAppModule$OrcaProductionConfigProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public OrcaProductionConfig a()
  {
    return new OrcaProductionConfig((PackageInfo)b(PackageInfo.class), (TelephonyManager)b(TelephonyManager.class, FromApplication.class), (UserActivityManager)b(UserActivityManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.OrcaProductionConfigProvider
 * JD-Core Version:    0.6.0
 */