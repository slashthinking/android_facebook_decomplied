package com.facebook.katana.features.places;

import android.content.Context;
import android.location.Location;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.method.FqlGetGeolocations;

public class Geolocations
{
  public static final Class<?> a = Geolocations.class;

  public static String a(Context paramContext, Location paramLocation)
  {
    return b(paramContext, paramLocation);
  }

  protected static String b(Context paramContext, Location paramLocation)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new FqlGetGeolocations(paramContext, null, localAppSession.b().sessionKey, null, paramLocation), 1001, 1020, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.places.Geolocations
 * JD-Core Version:    0.6.0
 */