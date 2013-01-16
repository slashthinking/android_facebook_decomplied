package com.facebook.katana.orca;

import com.facebook.content.SecureContextHelper;
import com.facebook.katana.activity.FB4ASplashScreenActivity;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.app.AppInitializationActivityHelper;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$AppInitializationActivityHelperProvider extends AbstractProvider<AppInitializationActivityHelper>
{
  private FbandroidAppModule$AppInitializationActivityHelperProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public AppInitializationActivityHelper a()
  {
    return new AppInitializationActivityHelper((AppInitLock)b(AppInitLock.class), (SecureContextHelper)b(SecureContextHelper.class), FB4ASplashScreenActivity.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.AppInitializationActivityHelperProvider
 * JD-Core Version:    0.6.0
 */