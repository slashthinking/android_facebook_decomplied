package com.facebook.maps;

import com.facebook.orca.common.util.LocationUtils;
import com.google.common.base.Preconditions;

public class MapFragmentFactory
{
  private final String a;

  public MapFragmentFactory(String paramString)
  {
    this.a = ((String)Preconditions.checkNotNull(paramString, "must provide a google map api key"));
  }

  public MapFragment a(boolean paramBoolean)
  {
    if (!LocationUtils.a())
      throw new RuntimeException("map library not present");
    return GoogleMapFragment.a(this.a, paramBoolean);
  }

  public boolean a()
  {
    return LocationUtils.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.MapFragmentFactory
 * JD-Core Version:    0.6.0
 */