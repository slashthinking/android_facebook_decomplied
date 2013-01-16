package com.facebook.location;

import android.content.Context;
import android.location.LocationManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;

public class LocationSourcesUtil
{
  private static final Set<String> a = ImmutableSet.a("network", "gps");
  private static final List<String> b = ImmutableList.a("android.settings.LOCATION_SOURCE_SETTINGS", "android.settings.SETTINGS");
  private final Context c;
  private final LocationManager d;

  public LocationSourcesUtil(Context paramContext, LocationManager paramLocationManager)
  {
    this.c = paramContext;
    this.d = paramLocationManager;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.LocationSourcesUtil
 * JD-Core Version:    0.6.0
 */