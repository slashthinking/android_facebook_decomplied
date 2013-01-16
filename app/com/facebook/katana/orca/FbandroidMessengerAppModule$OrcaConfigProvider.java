package com.facebook.katana.orca;

import android.content.pm.PackageInfo;
import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidMessengerAppModule$OrcaConfigProvider extends AbstractProvider<OrcaConfig>
{
  private FbandroidMessengerAppModule$OrcaConfigProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public OrcaConfig a()
  {
    return new FbandroidProductionConfig(FbandroidMessengerAppModule.a(this.a), (PackageInfo)b(PackageInfo.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.OrcaConfigProvider
 * JD-Core Version:    0.6.0
 */