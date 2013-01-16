package com.facebook.katana.orca;

import com.facebook.katana.activity.ActivityAuthHelper;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$ActivityAuthHelperProvider extends AbstractProvider<ActivityAuthHelper>
{
  private FbandroidAppModule$ActivityAuthHelperProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public ActivityAuthHelper a()
  {
    return new ActivityAuthHelper((MeUserAuthDataStore)b(MeUserAuthDataStore.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.ActivityAuthHelperProvider
 * JD-Core Version:    0.6.0
 */