package com.facebook.orca.push.mqtt;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.common.WakeLockHolder;

public class MqttReceiverWakeLockHolder extends WakeLockHolder
{
  public MqttReceiverWakeLockHolder(OrcaWakeLockManager paramOrcaWakeLockManager)
  {
    super(paramOrcaWakeLockManager, "MQTT");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttReceiverWakeLockHolder
 * JD-Core Version:    0.6.0
 */