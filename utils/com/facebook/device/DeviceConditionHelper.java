package com.facebook.device;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DeviceConditionHelper
{
  Context a;

  public DeviceConditionHelper(Context paramContext)
  {
    this.a = paramContext;
  }

  public boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean a(int paramInt)
  {
    Intent localIntent = this.a.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool = false;
    if (localIntent == null);
    while (true)
    {
      return bool;
      int i = localIntent.getIntExtra("plugged", -1);
      if ((i == 1) || (i == 2))
      {
        bool = true;
      }
      else
      {
        int j = localIntent.getIntExtra("scale", -1);
        int k = localIntent.getIntExtra("level", -1);
        bool = false;
        if (j > 0)
        {
          bool = false;
          if (k >= 0)
          {
            int m = k * 100 / j;
            bool = false;
            if (m >= paramInt)
              bool = true;
          }
        }
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.device.DeviceConditionHelper
 * JD-Core Version:    0.6.2
 */