package com.facebook.orca.push.mqtt;

import java.util.Map;

class MqttConnectionManager$CallbackHandler$1
  implements Runnable
{
  public void run()
  {
    if (MqttConnectionManager.a(this.a.a) == MqttConnectionManager.CallbackHandler.a(this.a))
    {
      this.a.a.d();
      MqttConnectionManager.a(this.a.a, MqttConnectionManager.b(this.a.a).values());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttConnectionManager.CallbackHandler.1
 * JD-Core Version:    0.6.0
 */