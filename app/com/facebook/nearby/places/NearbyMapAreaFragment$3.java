package com.facebook.nearby.places;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.model.NearbyPlaceEdge;

class NearbyMapAreaFragment$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    NearbyPlaceEdge localNearbyPlaceEdge = NearbyMapAreaFragment.d(this.a).getDisplayedPlaceEdge();
    NearbyMapAreaFragment.f(this.a).b(localNearbyPlaceEdge.place.id, NearbyMapAreaFragment.e(this.a));
    NearbyMapAreaFragment.g(this.a).a(localNearbyPlaceEdge);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment.3
 * JD-Core Version:    0.6.0
 */