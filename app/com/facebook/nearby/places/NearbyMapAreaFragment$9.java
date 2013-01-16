package com.facebook.nearby.places;

import android.location.Location;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.maps.Locations;
import com.facebook.nearby.model.NearbyPlaceEdge;
import com.google.common.base.Function;

class NearbyMapAreaFragment$9
  implements Function<NearbyPlaceEdge, Location>
{
  public Location a(NearbyPlaceEdge paramNearbyPlaceEdge)
  {
    return Locations.a(paramNearbyPlaceEdge.place.location.latitude, paramNearbyPlaceEdge.place.location.longitude);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment.9
 * JD-Core Version:    0.6.0
 */