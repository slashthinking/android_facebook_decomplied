package com.facebook.maps;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import java.util.Locale;

public class MapsLocationUtils
{
  private final Resources a;

  public MapsLocationUtils(Resources paramResources)
  {
    this.a = paramResources;
  }

  private int a(double paramDouble)
  {
    double d = Math.pow(10.0D, Math.floor(Math.log10(paramDouble)));
    return (int)(d * Math.round(paramDouble / d));
  }

  public String a(Location paramLocation1, Location paramLocation2)
  {
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(paramLocation1.getLatitude(), paramLocation1.getLongitude(), paramLocation2.getLatitude(), paramLocation2.getLongitude(), arrayOfFloat);
    double d1 = arrayOfFloat[0];
    int j;
    String str;
    if (this.a.getConfiguration().locale.toString().equals("en_US"))
    {
      double d2 = d1 * 3.28084D;
      j = a(d2);
      if (j >= 1000)
      {
        Resources localResources4 = this.a;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Double.valueOf(d2 / 5280.0D);
        str = localResources4.getString(2131362212, arrayOfObject4);
      }
    }
    while (true)
    {
      return str;
      Resources localResources3 = this.a;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(j);
      str = localResources3.getString(2131362213, arrayOfObject3);
      continue;
      int i = a(d1);
      if (i >= 1000)
      {
        Resources localResources2 = this.a;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Double.valueOf(d1 / 1000.0D);
        str = localResources2.getString(2131362215, arrayOfObject2);
        continue;
      }
      Resources localResources1 = this.a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i);
      str = localResources1.getString(2131362214, arrayOfObject1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.MapsLocationUtils
 * JD-Core Version:    0.6.0
 */