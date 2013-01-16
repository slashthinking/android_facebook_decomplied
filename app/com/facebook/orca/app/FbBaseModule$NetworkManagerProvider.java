package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.net.OrcaNetworkManager;

class FbBaseModule$NetworkManagerProvider extends AbstractProvider<OrcaNetworkManager>
{
  private FbBaseModule$NetworkManagerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public OrcaNetworkManager a()
  {
    return new OrcaNetworkManager(FbBaseModule.b(this.a), (ActivityBroadcaster)b(ActivityBroadcaster.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.NetworkManagerProvider
 * JD-Core Version:    0.6.0
 */