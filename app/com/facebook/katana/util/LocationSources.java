package com.facebook.katana.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import com.facebook.debug.Assert;
import com.facebook.orca.common.util.IntentUtil;

public class LocationSources
{
  public static LocationSources.MessageType a(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    int j;
    label32: LocationSources.MessageType localMessageType;
    if ((f(paramContext)) && (!c(paramContext)))
    {
      j = i;
      if ((!d(paramContext)) || (b(paramContext)))
        break label69;
      if ((j == 0) || (i == 0))
        break label74;
      localMessageType = LocationSources.MessageType.BOTH;
      label45: if ((!paramBoolean) || (!a(paramContext, localMessageType)))
        break label104;
      localMessageType = null;
    }
    while (true)
    {
      return localMessageType;
      j = 0;
      break;
      label69: i = 0;
      break label32;
      label74: if (j != 0)
      {
        localMessageType = LocationSources.MessageType.NETWORK;
        break label45;
      }
      if (i != 0)
      {
        localMessageType = LocationSources.MessageType.GPS;
        break label45;
      }
      localMessageType = null;
      continue;
      label104: if (g(paramContext) != null)
        continue;
      localMessageType = null;
    }
  }

  public static boolean a(Context paramContext)
  {
    if ((b(paramContext)) || (c(paramContext)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private static boolean a(Context paramContext, LocationSources.MessageType paramMessageType)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramMessageType.dontAskPrefKey, false);
  }

  private static void b(Context paramContext, LocationSources.MessageType paramMessageType, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putBoolean(paramMessageType.dontAskPrefKey, paramBoolean);
    localEditor.commit();
  }

  public static boolean b(Context paramContext)
  {
    return FBLocationManager.c(paramContext);
  }

  public static boolean c(Context paramContext)
  {
    return FBLocationManager.d(paramContext);
  }

  public static boolean d(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
  }

  public static void e(Context paramContext)
  {
    String str = g(paramContext);
    Assert.a(str);
    paramContext.startActivity(new Intent(str));
  }

  public static boolean f(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.location.network");
  }

  private static String g(Context paramContext)
  {
    String str;
    if (IntentUtil.a(paramContext, "android.settings.LOCATION_SOURCE_SETTINGS"))
      str = "android.settings.LOCATION_SOURCE_SETTINGS";
    while (true)
    {
      return str;
      boolean bool = IntentUtil.a(paramContext, "android.settings.SETTINGS");
      str = null;
      if (!bool)
        continue;
      str = "android.settings.SETTINGS";
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.LocationSources
 * JD-Core Version:    0.6.0
 */