package com.facebook.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class SystemBatteryStateManager$4 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = SystemBatteryStateManager.a(this.a).keySet().iterator();
    while (localIterator.hasNext())
      ((BatteryStateManager.BatteryChangeListener)localIterator.next()).d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.hardware.SystemBatteryStateManager.4
 * JD-Core Version:    0.6.0
 */