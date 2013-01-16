package com.facebook.nearby.module;

import com.facebook.nearby.server.NearbyServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class NearbyModule$OrcaServiceHandlerForNearbyQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private NearbyModule$OrcaServiceHandlerForNearbyQueueProvider(NearbyModule paramNearbyModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(NearbyServiceHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.module.NearbyModule.OrcaServiceHandlerForNearbyQueueProvider
 * JD-Core Version:    0.6.0
 */