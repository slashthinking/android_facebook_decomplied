package com.facebook.nearby.places;

import android.location.Location;
import com.facebook.maps.MapFragment;
import com.google.common.util.concurrent.FutureCallback;

class NearbyMapAreaFragment$1
  implements FutureCallback<Location>
{
  public void a(Location paramLocation)
  {
    NearbyMapAreaFragment.a(this.a);
    if (NearbyMapAreaFragment.b(this.a) == null)
      NearbyMapAreaFragment.c(this.a).b(paramLocation);
  }

  public void a(Throwable paramThrowable)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment.1
 * JD-Core Version:    0.6.0
 */