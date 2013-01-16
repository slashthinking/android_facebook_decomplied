package com.facebook.orca.push.mqtt;

import com.facebook.orca.config.MqttConfig;
import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.inject.AbstractProvider;

class OrcaMqttPushModule$OrcaMqttConfigProvider extends AbstractProvider<MqttConfig>
{
  private OrcaMqttPushModule$OrcaMqttConfigProvider(OrcaMqttPushModule paramOrcaMqttPushModule)
  {
  }

  public MqttConfig a()
  {
    return ((OrcaConfig)b(OrcaConfig.class)).g();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.OrcaMqttPushModule.OrcaMqttConfigProvider
 * JD-Core Version:    0.6.0
 */