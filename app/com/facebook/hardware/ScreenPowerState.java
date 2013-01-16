package com.facebook.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;

public class ScreenPowerState
{
  private final Context a;
  private final PowerManager b;
  private final Map<ScreenPowerState.PowerChangeListener, Boolean> c = Maps.c();
  private final BroadcastReceiver d;
  private final BroadcastReceiver e;
  private Boolean f;

  public ScreenPowerState(Context paramContext, PowerManager paramPowerManager)
  {
    this.a = ((Context)Preconditions.checkNotNull(paramContext));
    this.b = ((PowerManager)Preconditions.checkNotNull(paramPowerManager));
    this.d = new ScreenPowerState.1(this);
    this.e = new ScreenPowerState.2(this);
  }

  private void a(Context paramContext, String paramString, BroadcastReceiver paramBroadcastReceiver)
  {
    IntentFilter localIntentFilter = new IntentFilter(paramString);
    localIntentFilter.setPriority(999);
    paramContext.registerReceiver(paramBroadcastReceiver, localIntentFilter);
  }

  public void a(ScreenPowerState.PowerChangeListener paramPowerChangeListener)
  {
    monitorenter;
    try
    {
      if (this.c.isEmpty())
      {
        a(this.a, "android.intent.action.SCREEN_ON", this.d);
        a(this.a, "android.intent.action.SCREEN_OFF", this.e);
      }
      this.c.put(paramPowerChangeListener, Boolean.TRUE);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean a()
  {
    if (this.f != null);
    for (boolean bool = this.f.booleanValue(); ; bool = this.b.isScreenOn())
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.hardware.ScreenPowerState
 * JD-Core Version:    0.6.0
 */