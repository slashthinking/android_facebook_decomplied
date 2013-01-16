package com.facebook.katana.orca;

import android.content.ContentResolver;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.provider.LegacyKeyValueStore;
import com.facebook.katana.provider.UserValuesProvider;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$UserValuesLegacyKeyValueStoreProvider extends AbstractProvider<LegacyKeyValueStore>
{
  private FbandroidAppModule$UserValuesLegacyKeyValueStoreProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public LegacyKeyValueStore a()
  {
    return new LegacyKeyValueStore((ContentResolver)b(ContentResolver.class, FromApplication.class), UserValuesProvider.b, UserValuesProvider.c, "_id", "name", "value", (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.UserValuesLegacyKeyValueStoreProvider
 * JD-Core Version:    0.6.0
 */