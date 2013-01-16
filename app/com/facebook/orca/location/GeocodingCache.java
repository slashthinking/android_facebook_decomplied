package com.facebook.orca.location;

import com.facebook.orca.common.util.LocationUtils;
import com.google.common.collect.MapMaker;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class GeocodingCache
{
  private static final GeolocationInfo a = new GeolocationInfo();
  private final ConcurrentMap<LatitudeLongitude, GeolocationInfo> b = new MapMaker().b(900L, TimeUnit.SECONDS).b(100).n();
  private final ConcurrentMap<LatitudeLongitude, GeolocationInfo> c = new MapMaker().b(1800L, TimeUnit.SECONDS).b(3).n();
  private final ConcurrentMap<Coordinates, String> d = new MapMaker().a(600L, TimeUnit.SECONDS).b(5).n();

  private GeolocationInfo a(GeolocationInfo paramGeolocationInfo)
  {
    if (paramGeolocationInfo == a)
      paramGeolocationInfo = null;
    return paramGeolocationInfo;
  }

  private GeolocationInfo a(ConcurrentMap<LatitudeLongitude, GeolocationInfo> paramConcurrentMap, Coordinates paramCoordinates)
  {
    GeolocationInfo localGeolocationInfo1 = (GeolocationInfo)paramConcurrentMap.get(LatitudeLongitude.a(paramCoordinates));
    GeolocationInfo localGeolocationInfo2;
    if (localGeolocationInfo1 != null)
      localGeolocationInfo2 = a(localGeolocationInfo1);
    while (true)
    {
      return localGeolocationInfo2;
      Iterator localIterator = paramConcurrentMap.values().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          localGeolocationInfo2 = (GeolocationInfo)localIterator.next();
          if ((localGeolocationInfo2 == a) || (!LocationUtils.a(paramCoordinates.b(), paramCoordinates.c(), localGeolocationInfo2.a(), localGeolocationInfo2.b())))
            continue;
          break;
        }
      localGeolocationInfo2 = null;
    }
  }

  private GeolocationInfo b(GeolocationInfo paramGeolocationInfo)
  {
    if (paramGeolocationInfo == null)
      paramGeolocationInfo = a;
    return paramGeolocationInfo;
  }

  public GeolocationInfo a(Coordinates paramCoordinates)
  {
    return a(this.b, paramCoordinates);
  }

  public void a()
  {
    this.b.clear();
    this.c.clear();
    this.d.clear();
  }

  public void a(Coordinates paramCoordinates, GeolocationInfo paramGeolocationInfo)
  {
    this.b.put(LatitudeLongitude.a(paramCoordinates), b(paramGeolocationInfo));
  }

  public void a(Coordinates paramCoordinates, String paramString)
  {
    this.d.put(paramCoordinates, paramString);
  }

  public GeolocationInfo b(Coordinates paramCoordinates)
  {
    return a(this.c, paramCoordinates);
  }

  public void b(Coordinates paramCoordinates, GeolocationInfo paramGeolocationInfo)
  {
    this.c.put(LatitudeLongitude.a(paramCoordinates), b(paramGeolocationInfo));
  }

  public String c(Coordinates paramCoordinates)
  {
    Iterator localIterator = this.d.keySet().iterator();
    Coordinates localCoordinates;
    do
    {
      if (!localIterator.hasNext())
        break;
      localCoordinates = (Coordinates)localIterator.next();
    }
    while (!LocationUtils.a(paramCoordinates.b(), paramCoordinates.c(), localCoordinates.b(), localCoordinates.c()));
    for (String str = (String)this.d.get(localCoordinates); ; str = null)
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.GeocodingCache
 * JD-Core Version:    0.6.0
 */