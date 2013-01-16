package com.facebook.orca.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.orca.debug.BLog;

class SafeLocalBroadcastReceiver$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!SafeLocalBroadcastReceiver.a(this.a))
      BLog.e(SafeLocalBroadcastReceiver.c(), "Called onReceive after it was unregistered.");
    while (true)
    {
      return;
      this.a.a(paramContext, paramIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.SafeLocalBroadcastReceiver.1
 * JD-Core Version:    0.6.0
 */