package com.facebook.orca.location;

public class GeocodingForMessageLocationResult
{
  GeolocationInfo a;
  GeolocationInfo b;

  public GeocodingForMessageLocationResult(GeolocationInfo paramGeolocationInfo1, GeolocationInfo paramGeolocationInfo2)
  {
    this.a = paramGeolocationInfo1;
    this.b = paramGeolocationInfo2;
  }

  public GeolocationInfo a()
  {
    return this.a;
  }

  public GeolocationInfo b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.GeocodingForMessageLocationResult
 * JD-Core Version:    0.6.0
 */