package com.facebook.orca.push.mqtt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.app.INeedInit;

public class MqttBroadcastReceiver extends BroadcastReceiver
  implements INeedInit
{
  private final Context a;

  public MqttBroadcastReceiver(Context paramContext)
  {
    this.a = paramContext;
  }

  public void i_()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.facebook.orca.push.mqtt.PUBLISH");
    LocalBroadcastManager.a(this.a).a(this, localIntentFilter);
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.facebook.orca.push.mqtt.PUBLISH"))
      MqttReceiver.a(paramContext, paramIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttBroadcastReceiver
 * JD-Core Version:    0.6.0
 */