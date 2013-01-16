package com.facebook.nearby.places;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.maps.MapFragment;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.protocol.SearchArea;

class NearbyMapAreaFragment$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    NearbyMapAreaFragment.f(this.a).e(NearbyMapAreaFragment.e(this.a));
    NearbyMapAreaFragment.g(this.a).a(new SearchArea(NearbyMapAreaFragment.c(this.a).a(), NearbyMapAreaFragment.i(this.a)));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment.5
 * JD-Core Version:    0.6.0
 */