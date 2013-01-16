package com.facebook.katana.orca;

import com.facebook.katana.gating.Fb4aFeatureGating;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$IsNativeNewsfeedSpamReportingEnabledProvider extends AbstractProvider<Boolean>
{
  private FbandroidAppModule$IsNativeNewsfeedSpamReportingEnabledProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public Boolean a()
  {
    return Boolean.valueOf(((Fb4aFeatureGating)b(Fb4aFeatureGating.class)).b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.IsNativeNewsfeedSpamReportingEnabledProvider
 * JD-Core Version:    0.6.0
 */