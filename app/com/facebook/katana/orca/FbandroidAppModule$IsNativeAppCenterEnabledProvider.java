package com.facebook.katana.orca;

import com.facebook.katana.gating.Fb4aFeatureGating;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$IsNativeAppCenterEnabledProvider extends AbstractProvider<Boolean>
{
  private FbandroidAppModule$IsNativeAppCenterEnabledProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public Boolean a()
  {
    return Boolean.valueOf(((Fb4aFeatureGating)b(Fb4aFeatureGating.class)).c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.IsNativeAppCenterEnabledProvider
 * JD-Core Version:    0.6.0
 */