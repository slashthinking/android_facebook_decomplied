package com.facebook.nearby.places;

import android.location.Location;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

class MapZoomHelper
{
  int a(double paramDouble1, double paramDouble2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramDouble1 > 0.0D)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramDouble2 <= 0.0D)
        break label66;
    }
    int i;
    while (true)
    {
      Preconditions.checkArgument(bool1);
      if (paramDouble1 <= paramDouble2)
        break label93;
      i = 0;
      while (paramDouble1 / 2.0D > paramDouble2)
      {
        i++;
        paramDouble1 /= 2.0D;
      }
      bool2 = false;
      break;
      label66: bool1 = false;
    }
    while (true)
    {
      if (paramDouble1 < paramDouble2)
      {
        i--;
        paramDouble1 *= 2.0D;
        continue;
      }
      return i;
      label93: i = 0;
    }
  }

  public int a(Location paramLocation, List<Location> paramList, MapZoomHelper.LocationDelta paramLocationDelta)
  {
    MapZoomHelper.LocationDelta localLocationDelta = a(paramLocation, paramList);
    if ((localLocationDelta.a == 0.0D) || (localLocationDelta.b == 0.0D));
    double d1;
    double d2;
    for (int i = 0; ; i = Math.min(a(paramLocationDelta.a, d1), a(paramLocationDelta.b, d2)))
    {
      return i;
      d1 = 2.0D * localLocationDelta.a;
      d2 = 2.0D * localLocationDelta.b;
    }
  }

  MapZoomHelper.LocationDelta a(Location paramLocation, List<Location> paramList)
  {
    Iterator localIterator = paramList.iterator();
    double d1 = 0.0D;
    double d2 = 0.0D;
    while (localIterator.hasNext())
    {
      Location localLocation = (Location)localIterator.next();
      double d3 = Math.abs(paramLocation.getLatitude() - localLocation.getLatitude());
      double d4 = Math.abs(paramLocation.getLongitude() - localLocation.getLongitude());
      d1 = Math.max(d1, d3);
      d2 = Math.max(d2, d4);
    }
    return new MapZoomHelper.LocationDelta(d1, d2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.MapZoomHelper
 * JD-Core Version:    0.6.0
 */