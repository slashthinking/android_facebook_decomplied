package com.facebook.katana.activity.places;

import android.location.Location;
import com.facebook.katana.util.FBLocationManager.FBLocationListener;
import com.facebook.maps.MapFragment;
import com.facebook.widget.MapImage;

class SelectAtTagActivity$2
  implements FBLocationManager.FBLocationListener
{
  public void a(Location paramLocation)
  {
    SelectAtTagActivity.b(this.a, paramLocation);
    if (SelectAtTagActivity.c(this.a, paramLocation))
      SelectAtTagActivity.k(this.a);
    SelectAtTagActivity.a(this.a, paramLocation, SelectAtTagActivity.l(this.a));
    SelectAtTagActivity.b(this.a, false);
    if (SelectAtTagActivity.m(this.a) == null)
      SelectAtTagActivity.o(this.a).setCenter(SelectAtTagActivity.n(this.a));
    while (true)
    {
      return;
      SelectAtTagActivity.m(this.a).a(SelectAtTagActivity.n(this.a));
    }
  }

  public void k()
  {
    SelectAtTagActivity.a(this.a, null, SelectAtTagActivity.l(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.2
 * JD-Core Version:    0.6.0
 */