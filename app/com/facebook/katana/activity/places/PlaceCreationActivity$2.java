package com.facebook.katana.activity.places;

import android.location.Location;
import com.facebook.katana.util.FBLocationManager.FBLocationListener;
import com.facebook.maps.MapFragment;
import com.facebook.widget.MapImage;

class PlaceCreationActivity$2
  implements FBLocationManager.FBLocationListener
{
  public void a(Location paramLocation)
  {
    PlaceCreationActivity.a(this.a, paramLocation);
    if (PlaceCreationActivity.o(this.a) != null)
      if (!PlaceCreationActivity.p(this.a))
      {
        PlaceCreationActivity.o(this.a).a(paramLocation);
        PlaceCreationActivity.o(this.a).a(17.0D);
        PlaceCreationActivity.b(this.a, PlaceCreationActivity.q(this.a));
      }
    label147: 
    while (true)
    {
      return;
      float f;
      if (PlaceCreationActivity.r(this.a) != null)
        f = PlaceCreationActivity.r(this.a).distanceTo(paramLocation);
      while (true)
      {
        if ((PlaceCreationActivity.r(this.a) != null) && (f < 10.0F))
          break label147;
        PlaceCreationActivity.s(this.a).setCenter(paramLocation);
        PlaceCreationActivity.c(this.a, paramLocation);
        PlaceCreationActivity.b(this.a, PlaceCreationActivity.q(this.a));
        break;
        f = 0.0F;
      }
    }
  }

  public void k()
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.PlaceCreationActivity.2
 * JD-Core Version:    0.6.0
 */