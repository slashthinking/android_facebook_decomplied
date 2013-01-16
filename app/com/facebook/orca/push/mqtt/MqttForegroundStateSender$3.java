package com.facebook.orca.push.mqtt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.google.common.base.Objects;

class MqttForegroundStateSender$3 extends SafeLocalBroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    if (Objects.equal("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE", paramIntent.getAction()))
      this.a.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttForegroundStateSender.3
 * JD-Core Version:    0.6.0
 */