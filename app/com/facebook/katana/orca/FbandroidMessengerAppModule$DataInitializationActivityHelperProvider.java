package com.facebook.katana.orca;

import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.app.MessagesDataInitializationActivityHelper;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidMessengerAppModule$DataInitializationActivityHelperProvider extends AbstractProvider<MessagesDataInitializationActivityHelper>
{
  private FbandroidMessengerAppModule$DataInitializationActivityHelperProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public MessagesDataInitializationActivityHelper a()
  {
    return new MessagesDataInitializationActivityHelper((AppInitLock)b(AppInitLock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.DataInitializationActivityHelperProvider
 * JD-Core Version:    0.6.0
 */