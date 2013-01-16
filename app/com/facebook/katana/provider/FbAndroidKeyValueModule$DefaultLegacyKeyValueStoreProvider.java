package com.facebook.katana.provider;

import android.content.ContentResolver;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbAndroidKeyValueModule$DefaultLegacyKeyValueStoreProvider extends AbstractProvider<LegacyKeyValueStore>
{
  private FbAndroidKeyValueModule$DefaultLegacyKeyValueStoreProvider(FbAndroidKeyValueModule paramFbAndroidKeyValueModule)
  {
  }

  public LegacyKeyValueStore a()
  {
    return new LegacyKeyValueStore((ContentResolver)b(ContentResolver.class, FromApplication.class), KeyValueProvider.b, KeyValueProvider.c, "_id", "key", "value", (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FbAndroidKeyValueModule.DefaultLegacyKeyValueStoreProvider
 * JD-Core Version:    0.6.0
 */