package com.facebook.katana.util;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import java.util.Iterator;
import java.util.Set;

public class FBLocationManager$LocationDispatcher
  implements LocationListener
{
  protected boolean a = false;
  protected boolean b;
  protected Location c;

  public void a()
  {
    if ((!BuildConstants.a()) || (!this.a));
    try
    {
      FBLocationManager.c.requestLocationUpdates("network", 500L, 0.0F, this);
      FBLocationManager.c.requestLocationUpdates("gps", 500L, 0.0F, this);
      this.a = true;
      this.b = true;
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      try
      {
        Location localLocation1 = FBLocationManager.c.getLastKnownLocation("gps");
        if (FBLocationManager.a(localLocation1))
        {
          this.c = localLocation1;
          while (true)
          {
            return;
            localIllegalArgumentException1 = localIllegalArgumentException1;
            Log.b("LOCATION", "Caught IllegalArgumentException while requesting location updates.");
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        while (true)
        {
          Log.b("LOCATION", "Caught IllegalArgumentException while checking last network location.");
          continue;
          Location localLocation2 = FBLocationManager.c.getLastKnownLocation("network");
          if (!FBLocationManager.a(localLocation2))
            continue;
          this.c = localLocation2;
        }
      }
    }
  }

  public void b()
  {
    FBLocationManager.c.removeUpdates(this);
    this.a = false;
    this.b = false;
  }

  public void onLocationChanged(Location paramLocation)
  {
    if (!FBLocationManager.a(paramLocation, this.c));
    while (true)
    {
      return;
      this.c = paramLocation;
      if ((this.b) && (paramLocation.hasAccuracy()) && (paramLocation.getAccuracy() < 33.0F))
      {
        Assert.b(this.a);
        FBLocationManager.c.removeUpdates(this);
        FBLocationManager.c.requestLocationUpdates("network", 60000L, 0.0F, this);
        FBLocationManager.c.requestLocationUpdates("gps", 60000L, 0.0F, this);
        this.b = false;
      }
      Iterator localIterator = FBLocationManager.a.a().iterator();
      while (localIterator.hasNext())
        ((FBLocationManager.FBLocationListener)localIterator.next()).a(paramLocation);
      if (FBLocationManager.d == null)
        continue;
      FBLocationManager.b().removeCallbacks(FBLocationManager.d);
      FBLocationManager.d = null;
    }
  }

  public void onProviderDisabled(String paramString)
  {
  }

  public void onProviderEnabled(String paramString)
  {
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.FBLocationManager.LocationDispatcher
 * JD-Core Version:    0.6.0
 */