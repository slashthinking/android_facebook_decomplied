package com.facebook.nearby.places;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.model.NearbyPlaceEdge;
import com.facebook.nearby.ui.SplitHideableListView;

class NearbyPlacesFragment$1
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    NearbyPlaceEdge localNearbyPlaceEdge = (NearbyPlaceEdge)NearbyPlacesFragment.a(this.a).getItemAtPosition(paramInt);
    if (localNearbyPlaceEdge.socialContext != null);
    for (boolean bool = true; ; bool = false)
    {
      NearbyPlacesFragment.c(this.a).a(localNearbyPlaceEdge.place.id, bool, NearbyPlacesFragment.b(this.a));
      this.a.a(localNearbyPlaceEdge);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesFragment.1
 * JD-Core Version:    0.6.0
 */