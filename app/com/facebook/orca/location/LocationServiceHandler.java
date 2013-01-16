package com.facebook.orca.location;

import android.os.Bundle;
import com.facebook.location.GetDeviceLocationExecutor;
import com.facebook.location.GetDeviceLocationParams;
import com.facebook.orca.server.FutureOperationResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.google.common.util.concurrent.Futures;

public class LocationServiceHandler
  implements OrcaServiceHandler
{
  private final GetDeviceLocationExecutor a;

  public LocationServiceHandler(GetDeviceLocationExecutor paramGetDeviceLocationExecutor)
  {
    this.a = paramGetDeviceLocationExecutor;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    GetDeviceLocationParams localGetDeviceLocationParams = (GetDeviceLocationParams)paramOperationParams.b().getParcelable("getDeviceLocationParams");
    return new FutureOperationResult(Futures.a(this.a.a(localGetDeviceLocationParams, paramOperationParams.c()), new LocationServiceHandler.1(this)));
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    paramOperationParams.b();
    if ("get_device_location".equals(str))
      return b(paramOperationParams);
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.LocationServiceHandler
 * JD-Core Version:    0.6.0
 */