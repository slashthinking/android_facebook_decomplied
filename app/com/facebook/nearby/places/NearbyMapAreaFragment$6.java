package com.facebook.nearby.places;

import android.location.Location;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.maps.MapFragment;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.util.concurrent.ListenableFuture;

class NearbyMapAreaFragment$6
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    NearbyMapAreaFragment.f(this.a).d(NearbyMapAreaFragment.e(this.a));
    Location localLocation = NearbyMapAreaFragment.c(this.a).b();
    if (localLocation == null);
    while (true)
    {
      return;
      ListenableFuture localListenableFuture = NearbyMapAreaFragment.c(this.a).b(localLocation);
      NearbyMapAreaFragment.j(this.a).a(localListenableFuture, new NearbyMapAreaFragment.6.1(this));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment.6
 * JD-Core Version:    0.6.0
 */