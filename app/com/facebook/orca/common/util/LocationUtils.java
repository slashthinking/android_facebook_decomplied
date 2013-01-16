package com.facebook.orca.common.util;

import android.location.Location;
import android.net.Uri;
import com.facebook.orca.debug.BLog;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationUtils
{
  private static final Class<?> a = LocationUtils.class;

  public static Uri a(String paramString, double paramDouble1, double paramDouble2)
  {
    return Uri.parse("geo:0,0?q=" + URLEncoder.encode(paramString) + "@" + paramDouble1 + "," + paramDouble2);
  }

  public static String a(Location paramLocation)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("latitude", paramLocation.getLatitude());
      localJSONObject.put("longitude", paramLocation.getLongitude());
      if (paramLocation.hasAccuracy())
        localJSONObject.put("accuracy", paramLocation.getAccuracy());
      if (paramLocation.hasAltitude())
        localJSONObject.put("altitude", paramLocation.getAltitude());
      if (paramLocation.hasBearing())
        localJSONObject.put("heading", paramLocation.getBearing());
      if (paramLocation.hasSpeed())
        localJSONObject.put("speed", paramLocation.getSpeed());
      String str2 = localJSONObject.toString();
      str1 = str2;
      return str1;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        BLog.e(a, "JSONException when ENCODING data: " + localJSONException.getMessage());
        String str1 = "";
      }
    }
  }

  public static boolean a()
  {
    try
    {
      Class localClass = Class.forName("com.google.android.maps.MapActivity");
      i = 0;
      if (localClass != null)
        i = 1;
      return i;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        int i = 0;
    }
  }

  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(paramDouble1, paramDouble2, paramDouble3, paramDouble4, arrayOfFloat);
    if (arrayOfFloat[0] < 500.0F);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.LocationUtils
 * JD-Core Version:    0.6.0
 */