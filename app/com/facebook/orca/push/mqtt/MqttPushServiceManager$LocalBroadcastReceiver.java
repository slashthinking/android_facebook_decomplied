package com.facebook.orca.push.mqtt;

import com.facebook.content.SecureBroadcastReceiver;

public class MqttPushServiceManager$LocalBroadcastReceiver extends SecureBroadcastReceiver
{
  public MqttPushServiceManager$LocalBroadcastReceiver()
  {
    super("com.facebook.orca.push.mqtt.ACTION_ALARM", new MqttPushServiceManager.LocalAction());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushServiceManager.LocalBroadcastReceiver
 * JD-Core Version:    0.6.0
 */