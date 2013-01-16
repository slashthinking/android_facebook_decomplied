package com.facebook.orca.push.mqtt;

class MqttConnectionManager$CallbackHandler$3
  implements Runnable
{
  public void run()
  {
    if (MqttConnectionManager.a(this.a.a) == MqttConnectionManager.CallbackHandler.a(this.a))
      this.a.a.f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttConnectionManager.CallbackHandler.3
 * JD-Core Version:    0.6.0
 */