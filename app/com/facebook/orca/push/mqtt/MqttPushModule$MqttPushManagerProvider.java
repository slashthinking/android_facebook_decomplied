package com.facebook.orca.push.mqtt;

import com.facebook.orca.inject.AbstractProvider;

class MqttPushModule$MqttPushManagerProvider extends AbstractProvider<MqttPushManager>
{
  private MqttPushModule$MqttPushManagerProvider(MqttPushModule paramMqttPushModule)
  {
  }

  public MqttPushManager a()
  {
    return new MqttPushManager((MqttPushServiceManager)b(MqttPushServiceManager.class), (MqttConnectionManager)b(MqttConnectionManager.class), d(IProvideSubscribeTopics.class, MqttTopicList.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushModule.MqttPushManagerProvider
 * JD-Core Version:    0.6.0
 */