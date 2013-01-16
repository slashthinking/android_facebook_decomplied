package com.facebook.orca.push.mqtt;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.inject.AbstractProvider;

class MqttPushModule$MqttReceiverWakeLockHolderProvider extends AbstractProvider<MqttReceiverWakeLockHolder>
{
  private MqttPushModule$MqttReceiverWakeLockHolderProvider(MqttPushModule paramMqttPushModule)
  {
  }

  public MqttReceiverWakeLockHolder a()
  {
    return new MqttReceiverWakeLockHolder((OrcaWakeLockManager)b(OrcaWakeLockManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushModule.MqttReceiverWakeLockHolderProvider
 * JD-Core Version:    0.6.0
 */