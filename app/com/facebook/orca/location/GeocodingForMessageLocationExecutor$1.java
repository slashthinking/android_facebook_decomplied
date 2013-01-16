package com.facebook.orca.location;

import com.google.common.base.Function;
import java.util.List;

class GeocodingForMessageLocationExecutor$1
  implements Function<List<GeolocationInfo>, GeocodingForMessageLocationResult>
{
  public GeocodingForMessageLocationResult a(List<GeolocationInfo> paramList)
  {
    return new GeocodingForMessageLocationResult((GeolocationInfo)paramList.get(1), (GeolocationInfo)paramList.get(0));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.GeocodingForMessageLocationExecutor.1
 * JD-Core Version:    0.6.0
 */