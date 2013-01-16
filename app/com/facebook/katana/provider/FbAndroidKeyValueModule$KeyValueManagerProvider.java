package com.facebook.katana.provider;

import com.facebook.katana.annotations.KeyValueManagerBackend;
import com.facebook.orca.inject.AbstractProvider;

class FbAndroidKeyValueModule$KeyValueManagerProvider extends AbstractProvider<KeyValueManager>
{
  private FbAndroidKeyValueModule$KeyValueManagerProvider(FbAndroidKeyValueModule paramFbAndroidKeyValueModule)
  {
  }

  public KeyValueManager a()
  {
    return new KeyValueManager((KeyValueStore)b(KeyValueStore.class, KeyValueManagerBackend.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FbAndroidKeyValueModule.KeyValueManagerProvider
 * JD-Core Version:    0.6.0
 */