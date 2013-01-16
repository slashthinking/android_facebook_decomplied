package com.facebook.maps;

import android.location.Location;
import com.google.android.maps.GeoPoint;

public class Locations
{
  private static double a = 1000000.0D;

  public static Location a(double paramDouble1, double paramDouble2)
  {
    Location localLocation = new Location("");
    localLocation.setLatitude(paramDouble1);
    localLocation.setLongitude(paramDouble2);
    return localLocation;
  }

  static Location a(GeoPoint paramGeoPoint)
  {
    return a(paramGeoPoint.getLatitudeE6() / a, paramGeoPoint.getLongitudeE6() / a);
  }

  static GeoPoint a(Location paramLocation)
  {
    return new GeoPoint((int)(paramLocation.getLatitude() * a), (int)(paramLocation.getLongitude() * a));
  }

  public static boolean a(Location paramLocation1, Location paramLocation2)
  {
    if ((paramLocation1.getLatitude() == paramLocation2.getLatitude()) && (paramLocation1.getLongitude() == paramLocation2.getLongitude()));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.Locations
 * JD-Core Version:    0.6.0
 */