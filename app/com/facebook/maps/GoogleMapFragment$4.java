package com.facebook.maps;

import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.List;

class GoogleMapFragment$4
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = GoogleMapFragment.b(this.a).iterator();
    while (localIterator.hasNext())
      ((SettableFuture)localIterator.next()).a_(GoogleMapFragment.a(this.a).getLastFix());
    GoogleMapFragment.a(this.a, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.GoogleMapFragment.4
 * JD-Core Version:    0.6.0
 */