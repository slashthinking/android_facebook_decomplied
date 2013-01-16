package com.facebook.nearby.module;

import android.content.res.Resources;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.nearby.protocol.FetchNearbyPlacesMethod;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class NearbyModule$FetchNearbyPlacesMethodProvider extends AbstractProvider<FetchNearbyPlacesMethod>
{
  private NearbyModule$FetchNearbyPlacesMethodProvider(NearbyModule paramNearbyModule)
  {
  }

  public FetchNearbyPlacesMethod a()
  {
    return new FetchNearbyPlacesMethod((FbErrorReporter)b(FbErrorReporter.class), (Clock)b(Clock.class), (GraphQLHelper)b(GraphQLHelper.class), (Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.module.NearbyModule.FetchNearbyPlacesMethodProvider
 * JD-Core Version:    0.6.0
 */