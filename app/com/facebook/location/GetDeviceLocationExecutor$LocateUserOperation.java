package com.facebook.location;

import android.location.Location;
import android.location.LocationManager;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceProgressCallback;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class GetDeviceLocationExecutor$LocateUserOperation extends AbstractFuture<Location>
{
  private final GetDeviceLocationParams b;
  private final GetDeviceLocationExecutor.LocateUserOperation.MyLocationListener c;
  private final ImmutableList<String> d;
  private OrcaServiceProgressCallback e;
  private Location f;
  private Location g;
  private boolean h;
  private boolean i;

  GetDeviceLocationExecutor$LocateUserOperation(GetDeviceLocationExecutor paramGetDeviceLocationExecutor, GetDeviceLocationParams paramGetDeviceLocationParams, OrcaServiceProgressCallback paramOrcaServiceProgressCallback)
  {
    this.b = paramGetDeviceLocationParams;
    this.c = new GetDeviceLocationExecutor.LocateUserOperation.MyLocationListener(this, null);
    this.e = paramOrcaServiceProgressCallback;
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramGetDeviceLocationParams.j.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!GetDeviceLocationExecutor.a(paramGetDeviceLocationExecutor).isProviderEnabled(str))
        continue;
      localBuilder.b(str);
    }
    this.d = localBuilder.b();
    Location localLocation = c();
    if (localLocation != null)
      a(localLocation);
    if (this.i);
    while (true)
    {
      return;
      if (this.d.isEmpty())
      {
        BLog.d(GetDeviceLocationExecutor.a(), "None of the desired location providers are supported.");
        d(null);
        continue;
      }
      GetDeviceLocationExecutor.b(paramGetDeviceLocationExecutor).execute(new GetDeviceLocationExecutor.LocateUserOperation.1(this, paramGetDeviceLocationExecutor));
      GetDeviceLocationExecutor.b(paramGetDeviceLocationExecutor).schedule(new GetDeviceLocationExecutor.LocateUserOperation.2(this, paramGetDeviceLocationExecutor), paramGetDeviceLocationParams.a, TimeUnit.MILLISECONDS);
    }
  }

  private void a(Location paramLocation)
  {
    if (this.a.a(paramLocation, this.g, this.b))
    {
      Class localClass = GetDeviceLocationExecutor.a();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = GetDeviceLocationExecutor.a(this.a, paramLocation);
      BLog.b(localClass, "Got better location: %s", arrayOfObject);
      this.g = paramLocation;
      GetDeviceLocationExecutor.c(this.a).a(paramLocation);
      b(paramLocation);
    }
  }

  private void a(String paramString)
  {
    if (this.i);
    while (true)
    {
      return;
      GetDeviceLocationExecutor.a(this.a).requestLocationUpdates(paramString, this.b.d, this.b.e, this.c);
      this.h = true;
    }
  }

  private void b(Location paramLocation)
  {
    if (e(paramLocation))
      c(paramLocation);
    if (h(paramLocation))
      d(paramLocation);
  }

  private Location c()
  {
    if (this.b.k)
    {
      localObject1 = null;
      return localObject1;
    }
    List localList = GetDeviceLocationExecutor.a(this.a).getProviders(true);
    Location localLocation = GetDeviceLocationExecutor.c(this.a).a(-1L);
    Iterator localIterator = localList.iterator();
    Object localObject1 = localLocation;
    label52: Object localObject2;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject2 = GetDeviceLocationExecutor.a(this.a).getLastKnownLocation(str);
      if (!this.a.a((Location)localObject2, localObject1, this.b))
        break label111;
    }
    while (true)
    {
      localObject1 = localObject2;
      break label52;
      break;
      label111: localObject2 = localObject1;
    }
  }

  private void c(Location paramLocation)
  {
    Preconditions.checkNotNull(paramLocation);
    if (this.e == null);
    while (true)
    {
      return;
      this.f = paramLocation;
      this.e.a(OperationResult.a(paramLocation));
    }
  }

  private void d()
  {
    BLog.b(GetDeviceLocationExecutor.a(), "Unregistering location updates");
    GetDeviceLocationExecutor.a(this.a).removeUpdates(this.c);
    this.h = false;
  }

  private void d(Location paramLocation)
  {
    if (this.h)
      d();
    this.i = true;
    a_(paramLocation);
  }

  private void e()
  {
    d(this.g);
  }

  private boolean e(Location paramLocation)
  {
    if ((f(paramLocation)) && (g(paramLocation)));
    for (int j = 1; ; j = 0)
      return j;
  }

  private boolean f(Location paramLocation)
  {
    int j = 0;
    if (paramLocation == null);
    while (true)
    {
      return j;
      if (this.b.b != -1L)
      {
        boolean bool2 = GetDeviceLocationExecutor.b(this.a, paramLocation) < this.b.b;
        j = 0;
        if (bool2)
          continue;
      }
      if ((this.b.c != -1.0F) && (paramLocation.hasAccuracy()))
      {
        boolean bool1 = paramLocation.getAccuracy() < this.b.c;
        j = 0;
        if (bool1)
          continue;
      }
      j = 1;
    }
  }

  private boolean g(Location paramLocation)
  {
    if ((this.f == null) || ((paramLocation.distanceTo(this.f) >= this.b.e) && (paramLocation.getTime() - this.f.getTime() >= this.b.d)));
    for (int j = 1; ; j = 0)
      return j;
  }

  private boolean h(Location paramLocation)
  {
    int j = 0;
    if (paramLocation == null);
    while (true)
    {
      return j;
      if (this.b.f != -1L)
      {
        boolean bool3 = GetDeviceLocationExecutor.b(this.a, paramLocation) < this.b.f;
        j = 0;
        if (bool3)
          continue;
      }
      if (this.b.g != -1.0F)
      {
        boolean bool1 = paramLocation.hasAccuracy();
        j = 0;
        if (!bool1)
          continue;
        boolean bool2 = paramLocation.getAccuracy() < this.b.g;
        j = 0;
        if (bool2)
          continue;
      }
      j = 1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.GetDeviceLocationExecutor.LocateUserOperation
 * JD-Core Version:    0.6.0
 */