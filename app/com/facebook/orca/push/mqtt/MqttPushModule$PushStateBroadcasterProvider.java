package com.facebook.orca.push.mqtt;

import com.facebook.orca.inject.AbstractProvider;

class MqttPushModule$PushStateBroadcasterProvider extends AbstractProvider<PushStateBroadcaster>
{
  private MqttPushModule$PushStateBroadcasterProvider(MqttPushModule paramMqttPushModule)
  {
  }

  public PushStateBroadcaster a()
  {
    return new PushStateBroadcaster(MqttPushModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushModule.PushStateBroadcasterProvider
 * JD-Core Version:    0.6.0
 */