package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.push.mqtt.PushStateEvent;

class TitleBar$1 extends SafeLocalBroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    if ("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      PushStateEvent localPushStateEvent = PushStateEvent.fromValue(paramIntent.getIntExtra("event", -1));
      switch (TitleBar.5.a[localPushStateEvent.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
    }
    while (true)
    {
      return;
      this.a.invalidate();
      continue;
      if ((!"com.facebook.orca.ACTION_MQTT_CONFIG_CHANGED".equals(paramIntent.getAction())) && (!"com.facebook.orca.login.OrcaAuthStateMachineMonitor.LOGIN_COMPLETE".equals(paramIntent.getAction())) && (!"com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE".equals(paramIntent.getAction())))
        continue;
      TitleBar.a(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBar.1
 * JD-Core Version:    0.6.0
 */