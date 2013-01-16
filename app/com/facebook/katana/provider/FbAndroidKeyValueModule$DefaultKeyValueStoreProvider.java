package com.facebook.katana.provider;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.annotations.KeyValueManagerBackend;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class FbAndroidKeyValueModule$DefaultKeyValueStoreProvider extends AbstractProvider<KeyValueStore>
{
  private FbAndroidKeyValueModule$DefaultKeyValueStoreProvider(FbAndroidKeyValueModule paramFbAndroidKeyValueModule)
  {
  }

  public KeyValueStore a()
  {
    return new KeyValueStore((OrcaSharedPreferences)b(OrcaSharedPreferences.class), FbandroidPrefKeys.e, (LegacyKeyValueStore)b(LegacyKeyValueStore.class, KeyValueManagerBackend.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FbAndroidKeyValueModule.DefaultKeyValueStoreProvider
 * JD-Core Version:    0.6.0
 */