package com.facebook.katana.orca;

import com.facebook.katana.gating.Fb4aFeatureGating;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class FbandroidAppModule$FeatureGatingProvider extends AbstractProvider<Fb4aFeatureGating>
{
  private FbandroidAppModule$FeatureGatingProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public Fb4aFeatureGating a()
  {
    return new Fb4aFeatureGating(FbandroidAppModule.a(this.a), (OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.FeatureGatingProvider
 * JD-Core Version:    0.6.0
 */