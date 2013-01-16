package com.facebook.location;

import com.facebook.orca.debug.BLog;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

class GetDeviceLocationExecutor$LocateUserOperation$1
  implements Runnable
{
  public void run()
  {
    BLog.b(GetDeviceLocationExecutor.a(), "Registering location updates");
    Iterator localIterator = GetDeviceLocationExecutor.LocateUserOperation.a(this.b).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GetDeviceLocationExecutor.LocateUserOperation.a(this.b, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.GetDeviceLocationExecutor.LocateUserOperation.1
 * JD-Core Version:    0.6.0
 */