package com.facebook.nearby.module;

import android.content.res.Resources;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.nearby.protocol.SearchNearbyPlacesMethod;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class NearbyModule$SearchNearbyPlacesMethodProvider extends AbstractProvider<SearchNearbyPlacesMethod>
{
  private NearbyModule$SearchNearbyPlacesMethodProvider(NearbyModule paramNearbyModule)
  {
  }

  public SearchNearbyPlacesMethod a()
  {
    return new SearchNearbyPlacesMethod((Clock)b(Clock.class), (Resources)b(Resources.class), (ObjectMapper)b(ObjectMapper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.module.NearbyModule.SearchNearbyPlacesMethodProvider
 * JD-Core Version:    0.6.0
 */