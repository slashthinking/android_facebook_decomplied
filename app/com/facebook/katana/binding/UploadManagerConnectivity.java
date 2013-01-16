package com.facebook.katana.binding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.katana.service.MediaUploadService;

public class UploadManagerConnectivity extends BroadcastReceiver
{
  public static boolean a(Context paramContext)
  {
    if (c(paramContext) != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean b(Context paramContext)
  {
    int i = 1;
    NetworkInfo localNetworkInfo = c(paramContext);
    if (localNetworkInfo != null)
      if (localNetworkInfo.getType() != i);
    while (true)
    {
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }

  public static NetworkInfo c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()));
    while (true)
    {
      return localNetworkInfo;
      localNetworkInfo = null;
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (a(paramContext))
    {
      Intent localIntent = new Intent(paramContext, MediaUploadService.class);
      localIntent.putExtra("type", 1);
      paramContext.startService(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.UploadManagerConnectivity
 * JD-Core Version:    0.6.0
 */