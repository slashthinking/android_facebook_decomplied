package com.facebook.katana.service.vault;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.Log;

public class VaultConnectivityChangeReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.e("Network connectivity change detected");
    VaultHelpers.c(paramContext, 2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultConnectivityChangeReceiver
 * JD-Core Version:    0.6.0
 */