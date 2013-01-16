package com.facebook.nearby.places;

import android.graphics.drawable.Drawable;
import com.facebook.maps.MapFragment.MapOverlayElement;
import com.facebook.orca.debug.BLog;
import com.google.common.util.concurrent.FutureCallback;

class NearbyMapAreaFragment$12
  implements FutureCallback<Drawable>
{
  public void a(Drawable paramDrawable)
  {
    this.a.a(paramDrawable);
  }

  public void a(Throwable paramThrowable)
  {
    BLog.d(NearbyMapAreaFragment.L(), "Failed creating pin from " + this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment.12
 * JD-Core Version:    0.6.0
 */