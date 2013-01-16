package com.facebook.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.facebook.orca.debug.BLog;

class GetDeviceLocationExecutor$LocateUserOperation$MyLocationListener
  implements LocationListener
{
  private GetDeviceLocationExecutor$LocateUserOperation$MyLocationListener(GetDeviceLocationExecutor.LocateUserOperation paramLocateUserOperation)
  {
  }

  public void onLocationChanged(Location paramLocation)
  {
    Class localClass = GetDeviceLocationExecutor.a();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = GetDeviceLocationExecutor.a(this.a.a, paramLocation);
    BLog.b(localClass, "onLocationChanged: %s", arrayOfObject);
    GetDeviceLocationExecutor.LocateUserOperation.a(this.a, paramLocation);
  }

  public void onProviderDisabled(String paramString)
  {
    BLog.b(GetDeviceLocationExecutor.a(), "onProviderDisabled: " + paramString);
  }

  public void onProviderEnabled(String paramString)
  {
    BLog.b(GetDeviceLocationExecutor.a(), "onProviderEnabled: " + paramString);
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    BLog.b(GetDeviceLocationExecutor.a(), "onStatusChanged: " + paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.GetDeviceLocationExecutor.LocateUserOperation.MyLocationListener
 * JD-Core Version:    0.6.0
 */