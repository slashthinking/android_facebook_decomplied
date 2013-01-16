package com.facebook.orca.presence;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.push.mqtt.PushStateEvent;

class PresenceManager$1 extends SafeLocalBroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    if ("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      PushStateEvent localPushStateEvent = PushStateEvent.fromValue(paramIntent.getIntExtra("event", -1));
      switch (PresenceManager.9.a[localPushStateEvent.ordinal()])
      {
      default:
      case 1:
      }
    }
    while (true)
    {
      return;
      this.a.e();
      continue;
      if (!"com.facebook.orca.ACTION_FRIEND_SYNC_PROGRESS".equals(paramIntent.getAction()))
        continue;
      PresenceManager.a(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.presence.PresenceManager.1
 * JD-Core Version:    0.6.0
 */