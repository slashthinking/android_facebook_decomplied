package com.facebook.orca.net;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.orca.app.ActivityBroadcaster;
import com.facebook.orca.app.INeedInit;

public class OrcaNetworkManager
  implements INeedInit
{
  private static final Class<?> a = OrcaNetworkManager.class;
  private final Context b;
  private final ConnectivityManager c;
  private final ActivityBroadcaster d;
  private OrcaNetworkManager.NetworkChangedBroadcastReceiver e;
  private long f;

  public OrcaNetworkManager(Context paramContext, ActivityBroadcaster paramActivityBroadcaster)
  {
    this.b = paramContext;
    this.c = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.d = paramActivityBroadcaster;
  }

  public boolean b()
  {
    NetworkInfo localNetworkInfo = this.c.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public NetworkInfo c()
  {
    if (b());
    for (NetworkInfo localNetworkInfo = this.c.getActiveNetworkInfo(); ; localNetworkInfo = null)
      return localNetworkInfo;
  }

  public void i_()
  {
    this.e = new OrcaNetworkManager.NetworkChangedBroadcastReceiver(this, null);
    this.b.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.f = System.currentTimeMillis();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.net.OrcaNetworkManager
 * JD-Core Version:    0.6.0
 */