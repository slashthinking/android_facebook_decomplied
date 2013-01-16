package com.facebook.katana.service.vault;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.Log;

public class VaultPowerConnectionReceiver extends BroadcastReceiver
{
  private static Class<?> a = VaultPowerConnectionReceiver.class;

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.e(a, "Got power plugged in intent");
    VaultHelpers.c(paramContext, 9);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultPowerConnectionReceiver
 * JD-Core Version:    0.6.0
 */