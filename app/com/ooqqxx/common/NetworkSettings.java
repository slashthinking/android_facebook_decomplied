package com.ooqqxx.common;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class NetworkSettings
{
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");

  public static boolean isPreferredAPNCmwap(ContentResolver paramContentResolver)
  {
    Cursor localCursor = paramContentResolver.query(PREFERRED_APN_URI, null, null, null, null);
    String str1;
    String str2;
    String str3;
    String str4;
    int i;
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      str1 = localCursor.getString(localCursor.getColumnIndex("proxy"));
      str2 = localCursor.getString(localCursor.getColumnIndex("apn"));
      str3 = localCursor.getString(localCursor.getColumnIndex("port"));
      str4 = localCursor.getString(localCursor.getColumnIndex("current"));
      localCursor.close();
      if ((str1 == null) || (str2 == null) || (str3 == null) || (str4 == null) || (str1.equals("")) || (str3.equals("")))
        i = 0;
    }
    while (true)
    {
      return i;
      if (((str1.equals("10.0.0.172")) || (str1.equals("010.000.000.172"))) && (str3.equals("80")) && (str2.toLowerCase().equals("cmwap")) && (str4.equals("1")))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public static boolean isPreferredAPNCmwap(Context paramContext)
  {
    return isPreferredAPNCmwap(paramContext.getContentResolver());
  }

  public static boolean isWifiOn(Context paramContext)
  {
    WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    WifiInfo localWifiInfo = localWifiManager.getConnectionInfo();
    if (localWifiInfo == null);
    for (int i = 0; ; i = localWifiInfo.getIpAddress())
    {
      boolean bool = localWifiManager.isWifiEnabled();
      int j = 0;
      if (bool)
      {
        j = 0;
        if (i != 0)
          j = 1;
      }
      return j;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.ooqqxx.common.NetworkSettings
 * JD-Core Version:    0.6.0
 */