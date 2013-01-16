package com.facebook.katana.orca;

import com.facebook.katana.gating.Fb4aFeatureGating;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$IsNewPageIdentityEnabledProvider extends AbstractProvider<Boolean>
{
  private FbandroidAppModule$IsNewPageIdentityEnabledProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public Boolean a()
  {
    return Boolean.valueOf(((Fb4aFeatureGating)b(Fb4aFeatureGating.class)).d());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.IsNewPageIdentityEnabledProvider
 * JD-Core Version:    0.6.0
 */