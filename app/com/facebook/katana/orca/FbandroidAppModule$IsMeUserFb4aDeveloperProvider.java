package com.facebook.katana.orca;

import com.facebook.common.util.TriState;
import com.facebook.katana.model.FacebookAffiliation;
import javax.inject.Inject;
import javax.inject.Provider;

class FbandroidAppModule$IsMeUserFb4aDeveloperProvider
  implements Provider<TriState>
{
  @Inject
  public FbandroidAppModule$IsMeUserFb4aDeveloperProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public TriState a()
  {
    if (FacebookAffiliation.d(FbandroidAppModule.a(this.a)));
    for (TriState localTriState = TriState.YES; ; localTriState = TriState.NO)
      return localTriState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.IsMeUserFb4aDeveloperProvider
 * JD-Core Version:    0.6.0
 */