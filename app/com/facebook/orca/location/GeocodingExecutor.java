package com.facebook.orca.location;

import android.location.Address;
import android.location.Geocoder;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class GeocodingExecutor
{
  private static final Class<?> a = GeocodingExecutor.class;
  private final Geocoder b;
  private final GeocodingCache c;
  private final AndroidThreadUtil d;

  public GeocodingExecutor(Geocoder paramGeocoder, GeocodingCache paramGeocodingCache, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.b = paramGeocoder;
    this.c = paramGeocodingCache;
    this.d = paramAndroidThreadUtil;
  }

  private Address a(List<Address> paramList)
  {
    Address localAddress;
    if (paramList.isEmpty())
      localAddress = null;
    while (true)
    {
      return localAddress;
      Iterator localIterator = paramList.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          localAddress = (Address)localIterator.next();
          if (StringUtil.a(localAddress.getSubLocality()))
            continue;
          break;
        }
      localAddress = (Address)paramList.get(0);
    }
  }

  private GeolocationInfo b(GeocodingParameters paramGeocodingParameters)
  {
    Coordinates localCoordinates = paramGeocodingParameters.a();
    try
    {
      List localList = this.b.getFromLocation(localCoordinates.b(), localCoordinates.c(), 4);
      localObject = localList;
      Address localAddress = a((List)localObject);
      localGeolocationInfo = null;
      if (localAddress != null)
        localGeolocationInfo = new GeolocationInfo(paramGeocodingParameters.a(), localAddress.getSubLocality(), localAddress.getLocality(), localAddress.getAdminArea(), localAddress.getCountryCode(), localAddress.getCountryName());
      if (paramGeocodingParameters.b())
      {
        this.c.b(paramGeocodingParameters.a(), localGeolocationInfo);
        BLog.b(a, "Geocoding complete: " + localAddress);
        return localGeolocationInfo;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        GeolocationInfo localGeolocationInfo;
        BLog.b(a, "Failed to geocode", localIOException);
        Object localObject = ImmutableList.d();
        continue;
        this.c.a(paramGeocodingParameters.a(), localGeolocationInfo);
      }
    }
  }

  public ListenableFuture<GeolocationInfo> a(GeocodingParameters paramGeocodingParameters)
  {
    GeolocationInfo localGeolocationInfo;
    if (paramGeocodingParameters.b())
    {
      localGeolocationInfo = this.c.b(paramGeocodingParameters.a());
      if (localGeolocationInfo != null)
        break label59;
    }
    label59: for (ListenableFuture localListenableFuture = this.d.a(new GeocodingExecutor.1(this, paramGeocodingParameters)); ; localListenableFuture = Futures.a(localGeolocationInfo))
    {
      return localListenableFuture;
      localGeolocationInfo = this.c.a(paramGeocodingParameters.a());
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.GeocodingExecutor
 * JD-Core Version:    0.6.0
 */