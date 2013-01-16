package com.facebook.katana.orca;

import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidMessengerAppModule$IntendedAudienceProvider extends AbstractProvider<IntendedAudience>
{
  public IntendedAudience a()
  {
    return ((OrcaAppType)b(OrcaAppType.class)).h();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.IntendedAudienceProvider
 * JD-Core Version:    0.6.0
 */