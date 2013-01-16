package com.facebook.katana.activity.places;

import android.support.v4.app.DialogFragment;
import com.facebook.katana.util.LocationSources.LocationSourcesDialogFragment;

class SelectAtTagActivity$11
  implements Runnable
{
  public void run()
  {
    SelectAtTagActivity.a(this.a, null);
    if (!this.a.u());
    while (true)
    {
      return;
      SelectAtTagActivity.b(this.a, LocationSources.LocationSourcesDialogFragment.b(this.a));
      if (SelectAtTagActivity.u(this.a) != null)
        SelectAtTagActivity.u(this.a).a(this.a.g(), "location_sources_fragment");
      if (SelectAtTagActivity.n(this.a) != null)
        continue;
      SelectAtTagActivity.v(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.11
 * JD-Core Version:    0.6.0
 */