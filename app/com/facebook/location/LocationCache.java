package com.facebook.location;

import android.location.Location;
import com.facebook.orca.common.util.Clock;

public class LocationCache
{
  private volatile Location a;
  private final Clock b;

  public LocationCache(Clock paramClock)
  {
    this.b = paramClock;
  }

  public Location a()
  {
    return a(300000L);
  }

  public Location a(long paramLong)
  {
    Location localLocation1 = this.a;
    Location localLocation2 = null;
    if (localLocation1 == null);
    while (true)
    {
      return localLocation2;
      if (paramLong != -1L)
      {
        boolean bool = this.b.a() - this.a.getTime() < paramLong;
        localLocation2 = null;
        if (!bool)
          continue;
      }
      localLocation2 = this.a;
    }
  }

  public void a(Location paramLocation)
  {
    this.a = paramLocation;
  }

  public void b()
  {
    this.a = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.LocationCache
 * JD-Core Version:    0.6.0
 */