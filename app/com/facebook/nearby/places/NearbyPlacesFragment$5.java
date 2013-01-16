package com.facebook.nearby.places;

import android.location.Location;
import com.facebook.nearby.protocol.SearchArea;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;

class NearbyPlacesFragment$5
  implements FutureCallback<Location>
{
  public void a(Location paramLocation)
  {
    NearbyPlacesFragment.l(this.a).c();
    SearchArea localSearchArea;
    if (NearbyPlacesFragment.m(this.a) == null)
      if (NearbyPlacesFragment.n(this.a) == null)
      {
        localSearchArea = new SearchArea(paramLocation);
        NearbyPlacesFragment.l(this.a).a(ImmutableList.d(), paramLocation);
        NearbyPlacesFragment.k(this.a).a(ImmutableList.d(), localSearchArea, NearbyPlacesFragment.b(this.a));
        this.a.a(localSearchArea);
      }
    while (true)
    {
      return;
      localSearchArea = NearbyPlacesFragment.k(this.a).c();
      break;
      NearbyPlacesFragment.l(this.a).a(NearbyPlacesFragment.m(this.a), paramLocation);
    }
  }

  public void a(Throwable paramThrowable)
  {
    NearbyPlacesFragment.o(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesFragment.5
 * JD-Core Version:    0.6.0
 */