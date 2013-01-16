package com.facebook.orca.location;

import android.location.Location;
import com.facebook.location.LocationCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class GeocodingForMessageLocationExecutor
{
  private final LocationCache a;
  private final GeocodingExecutor b;

  public GeocodingForMessageLocationExecutor(LocationCache paramLocationCache, GeocodingExecutor paramGeocodingExecutor)
  {
    this.a = paramLocationCache;
    this.b = paramGeocodingExecutor;
  }

  private ListenableFuture<GeolocationInfo> a()
  {
    Location localLocation = this.a.a();
    if (localLocation == null);
    GeocodingParameters localGeocodingParameters;
    for (ListenableFuture localListenableFuture = Futures.a(null); ; localListenableFuture = this.b.a(localGeocodingParameters))
    {
      return localListenableFuture;
      localGeocodingParameters = new GeocodingParameters(Coordinates.a(localLocation), true);
    }
  }

  private ListenableFuture<GeolocationInfo> b(Coordinates paramCoordinates)
  {
    GeocodingParameters localGeocodingParameters = new GeocodingParameters(paramCoordinates, false);
    return this.b.a(localGeocodingParameters);
  }

  public ListenableFuture<GeocodingForMessageLocationResult> a(Coordinates paramCoordinates)
  {
    return Futures.a(Futures.a(new ListenableFuture[] { a(), b(paramCoordinates) }), new GeocodingForMessageLocationExecutor.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.GeocodingForMessageLocationExecutor
 * JD-Core Version:    0.6.0
 */