package com.facebook.orca.mqtt;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class MqttSsl
{
  public SocketFactory a()
  {
    return SSLSocketFactory.getDefault();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.MqttSsl
 * JD-Core Version:    0.6.0
 */