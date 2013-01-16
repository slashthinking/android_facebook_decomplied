package com.facebook.location;

import android.location.Location;
import android.location.LocationManager;
import com.facebook.orca.annotations.ForLightweightTaskHandlerThread;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.OrcaServiceProgressCallback;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

public class GetDeviceLocationExecutor
{
  private static final Class<?> a = GetDeviceLocationExecutor.class;
  private final LocationManager b;
  private final LocationCache c;
  private final ScheduledExecutorService d;
  private final Clock e;

  public GetDeviceLocationExecutor(LocationManager paramLocationManager, LocationCache paramLocationCache, @ForLightweightTaskHandlerThread ScheduledExecutorService paramScheduledExecutorService, Clock paramClock)
  {
    this.b = paramLocationManager;
    this.c = paramLocationCache;
    this.d = paramScheduledExecutorService;
    this.e = paramClock;
  }

  private String a(Location paramLocation)
  {
    if (paramLocation == null);
    for (String str = null; ; str = Objects.toStringHelper(paramLocation).add("accuracy", paramLocation.getAccuracy() + " m").add("age", b(paramLocation) / 1000L + " ms").toString())
      return str;
  }

  private boolean a(String paramString1, String paramString2)
  {
    return Objects.equal(paramString1, paramString2);
  }

  private long b(Location paramLocation)
  {
    return this.e.a() - paramLocation.getTime();
  }

  public ListenableFuture<Location> a(GetDeviceLocationParams paramGetDeviceLocationParams, OrcaServiceProgressCallback paramOrcaServiceProgressCallback)
  {
    Class localClass = a;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Long.valueOf(paramGetDeviceLocationParams.f);
    arrayOfObject[1] = Float.valueOf(paramGetDeviceLocationParams.g);
    arrayOfObject[2] = Long.valueOf(paramGetDeviceLocationParams.a);
    BLog.b(localClass, "Getting location. Target age: %d ms, Target accuracy: %f m, Timeout: %d ms", arrayOfObject);
    return new GetDeviceLocationExecutor.LocateUserOperation(this, paramGetDeviceLocationParams, paramOrcaServiceProgressCallback);
  }

  boolean a(Location paramLocation1, Location paramLocation2, GetDeviceLocationParams paramGetDeviceLocationParams)
  {
    int i = 1;
    if (paramLocation1 == null)
      i = 0;
    label42: label57: int m;
    label90: label96: label100: 
    while (true)
    {
      return i;
      if (paramLocation2 == null)
        continue;
      long l = paramLocation1.getTime() - paramLocation2.getTime();
      int j;
      int k;
      if (l > paramGetDeviceLocationParams.h)
      {
        j = i;
        if (l >= -paramGetDeviceLocationParams.h)
          break label90;
        k = i;
        if (l <= 0L)
          break label96;
      }
      for (m = i; ; m = 0)
      {
        if (j != 0)
          break label100;
        if (k == 0)
          break label102;
        i = 0;
        break;
        j = 0;
        break label42;
        k = 0;
        break label57;
      }
    }
    label102: float f = paramLocation1.getAccuracy() - paramLocation2.getAccuracy();
    int n;
    label124: int i1;
    if (f > 0.0F)
    {
      n = i;
      if (f >= 0.0F)
        break label205;
      i1 = i;
      label135: if (f <= paramGetDeviceLocationParams.i)
        break label211;
    }
    label205: label211: for (int i2 = i; ; i2 = 0)
    {
      boolean bool = a(paramLocation1.getProvider(), paramLocation2.getProvider());
      if ((i1 != 0) || ((m != 0) && (n == 0)) || ((m != 0) && (i2 == 0) && (bool)))
        break;
      i = 0;
      break;
      n = 0;
      break label124;
      i1 = 0;
      break label135;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.GetDeviceLocationExecutor
 * JD-Core Version:    0.6.0
 */