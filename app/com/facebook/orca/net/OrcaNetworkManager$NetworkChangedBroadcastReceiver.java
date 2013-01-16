package com.facebook.orca.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.orca.app.ActivityBroadcaster;
import com.facebook.orca.debug.BLog;

class OrcaNetworkManager$NetworkChangedBroadcastReceiver extends BroadcastReceiver
{
  private OrcaNetworkManager$NetworkChangedBroadcastReceiver(OrcaNetworkManager paramOrcaNetworkManager)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ((NetworkInfo)paramIntent.getParcelableExtra("networkInfo"));
    ((NetworkInfo)paramIntent.getParcelableExtra("otherNetwork"));
    paramIntent.getBooleanExtra("isFailover", false);
    paramIntent.getBooleanExtra("noConnectivity", false);
    NetworkInfo localNetworkInfo = OrcaNetworkManager.a(this.a).getActiveNetworkInfo();
    boolean bool;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      bool = true;
      BLog.c(OrcaNetworkManager.d(), "Connectivity changed: connected=" + bool);
      if (System.currentTimeMillis() - OrcaNetworkManager.b(this.a) >= 30000L)
        break label115;
    }
    while (true)
    {
      return;
      bool = false;
      break;
      label115: OrcaNetworkManager.c(this.a).a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.net.OrcaNetworkManager.NetworkChangedBroadcastReceiver
 * JD-Core Version:    0.6.0
 */