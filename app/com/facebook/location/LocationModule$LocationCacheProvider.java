package com.facebook.location;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class LocationModule$LocationCacheProvider extends AbstractProvider<LocationCache>
{
  private LocationModule$LocationCacheProvider(LocationModule paramLocationModule)
  {
  }

  public LocationCache a()
  {
    return new LocationCache((Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.LocationModule.LocationCacheProvider
 * JD-Core Version:    0.6.0
 */