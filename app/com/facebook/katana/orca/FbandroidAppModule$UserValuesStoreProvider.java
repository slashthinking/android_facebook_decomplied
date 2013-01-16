package com.facebook.katana.orca;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.annotations.UserValuesManagerBackend;
import com.facebook.katana.provider.KeyValueStore;
import com.facebook.katana.provider.LegacyKeyValueStore;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class FbandroidAppModule$UserValuesStoreProvider extends AbstractProvider<KeyValueStore>
{
  private FbandroidAppModule$UserValuesStoreProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public KeyValueStore a()
  {
    return new KeyValueStore((OrcaSharedPreferences)b(OrcaSharedPreferences.class), FbandroidPrefKeys.f, (LegacyKeyValueStore)b(LegacyKeyValueStore.class, UserValuesManagerBackend.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.UserValuesStoreProvider
 * JD-Core Version:    0.6.0
 */