package com.facebook.katana.orca;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$FbandroidAuthDataStoreProvider extends AbstractProvider<FbandroidAuthDataStore>
{
  private FbandroidAppModule$FbandroidAuthDataStoreProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public FbandroidAuthDataStore a()
  {
    return new FbandroidAuthDataStore(FbandroidAppModule.a(this.a), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.FbandroidAuthDataStoreProvider
 * JD-Core Version:    0.6.0
 */