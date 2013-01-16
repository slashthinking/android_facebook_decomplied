package com.facebook.katana.orca;

import com.facebook.katana.annotations.UserValuesManagerBackend;
import com.facebook.katana.provider.KeyValueStore;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$UserValuesManagerProvider extends AbstractProvider<UserValuesManager>
{
  private FbandroidAppModule$UserValuesManagerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public UserValuesManager a()
  {
    return new UserValuesManager((KeyValueStore)b(KeyValueStore.class, UserValuesManagerBackend.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.UserValuesManagerProvider
 * JD-Core Version:    0.6.0
 */