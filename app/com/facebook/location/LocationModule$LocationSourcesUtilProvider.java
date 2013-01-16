package com.facebook.location;

import android.content.Context;
import android.location.LocationManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class LocationModule$LocationSourcesUtilProvider extends AbstractProvider<LocationSourcesUtil>
{
  private LocationModule$LocationSourcesUtilProvider(LocationModule paramLocationModule)
  {
  }

  public LocationSourcesUtil a()
  {
    return new LocationSourcesUtil((Context)b(Context.class, FromApplication.class), (LocationManager)b(LocationManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.LocationModule.LocationSourcesUtilProvider
 * JD-Core Version:    0.6.0
 */