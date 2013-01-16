package com.facebook.orca.push.mqtt;

import com.facebook.analytics.AnalyticCounters;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.mqtt.MqttClient;
import com.facebook.orca.net.OrcaNetworkManager;

class MqttPushModule$MqttConnectionManagerProvider extends AbstractProvider<MqttConnectionManager>
{
  private MqttPushModule$MqttConnectionManagerProvider(MqttPushModule paramMqttPushModule)
  {
  }

  public MqttConnectionManager a()
  {
    return new MqttConnectionManager((OrcaNetworkManager)b(OrcaNetworkManager.class), (AnalyticCounters)b(AnalyticCounters.class), a(MqttClient.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushModule.MqttConnectionManagerProvider
 * JD-Core Version:    0.6.0
 */