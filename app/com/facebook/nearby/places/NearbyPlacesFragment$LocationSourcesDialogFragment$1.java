package com.facebook.nearby.places;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.nearby.analytics.NearbyAnalytics;

class NearbyPlacesFragment$LocationSourcesDialogFragment$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    NearbyPlacesFragment.LocationSourcesDialogFragment.a(this.a).c().c();
    NearbyPlacesFragment.a(this.a.p(), NearbyPlacesFragment.LocationSourcesDialogFragment.b(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesFragment.LocationSourcesDialogFragment.1
 * JD-Core Version:    0.6.0
 */