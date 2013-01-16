package com.facebook.katana.orca;

import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$MapApiKeyProvider extends AbstractProvider<String>
{
  private FbandroidAppModule$MapApiKeyProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public String a()
  {
    return ((OrcaAppType)b(OrcaAppType.class)).e();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.MapApiKeyProvider
 * JD-Core Version:    0.6.0
 */