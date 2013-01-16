package com.facebook.location;

import android.location.LocationManager;
import com.facebook.orca.annotations.ForLightweightTaskHandlerThread;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import java.util.concurrent.ScheduledExecutorService;

class LocationModule$GetDeviceLocationExecutorProvider extends AbstractProvider<GetDeviceLocationExecutor>
{
  private LocationModule$GetDeviceLocationExecutorProvider(LocationModule paramLocationModule)
  {
  }

  public GetDeviceLocationExecutor a()
  {
    return new GetDeviceLocationExecutor((LocationManager)b(LocationManager.class, FromApplication.class), (LocationCache)b(LocationCache.class), (ScheduledExecutorService)b(ScheduledExecutorService.class, ForLightweightTaskHandlerThread.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.LocationModule.GetDeviceLocationExecutorProvider
 * JD-Core Version:    0.6.0
 */