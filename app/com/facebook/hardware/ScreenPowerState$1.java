package com.facebook.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ScreenPowerState$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ScreenPowerState.a(this.a, Boolean.valueOf(true));
    Iterator localIterator = ScreenPowerState.a(this.a).keySet().iterator();
    while (localIterator.hasNext())
      ((ScreenPowerState.PowerChangeListener)localIterator.next()).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.hardware.ScreenPowerState.1
 * JD-Core Version:    0.6.0
 */