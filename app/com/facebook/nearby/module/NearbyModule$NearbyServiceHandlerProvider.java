package com.facebook.nearby.module;

import com.facebook.nearby.protocol.FetchNearbyPlacesMethod;
import com.facebook.nearby.protocol.SearchNearbyPlacesMethod;
import com.facebook.nearby.server.NearbyServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class NearbyModule$NearbyServiceHandlerProvider extends AbstractProvider<NearbyServiceHandler>
{
  private NearbyModule$NearbyServiceHandlerProvider(NearbyModule paramNearbyModule)
  {
  }

  public NearbyServiceHandler a()
  {
    return new NearbyServiceHandler(a(SingleMethodRunner.class), (FetchNearbyPlacesMethod)b(FetchNearbyPlacesMethod.class), (SearchNearbyPlacesMethod)b(SearchNearbyPlacesMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.module.NearbyModule.NearbyServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */