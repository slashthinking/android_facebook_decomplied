package com.facebook.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;

public class SystemBatteryStateManager
  implements BatteryStateManager
{
  private final Context a;
  private final Map<BatteryStateManager.BatteryChangeListener, Boolean> b = Maps.c();
  private final BroadcastReceiver c;
  private final BroadcastReceiver d;
  private final BroadcastReceiver e;
  private final BroadcastReceiver f;

  public SystemBatteryStateManager(Context paramContext)
  {
    this.a = ((Context)Preconditions.checkNotNull(paramContext));
    this.c = new SystemBatteryStateManager.1(this);
    this.d = new SystemBatteryStateManager.2(this);
    this.e = new SystemBatteryStateManager.3(this);
    this.f = new SystemBatteryStateManager.4(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.hardware.SystemBatteryStateManager
 * JD-Core Version:    0.6.0
 */