package com.facebook.orca.push.mqtt;

 enum MqttPushService$ConnectionState
{
  static
  {
    CONNECTED = new ConnectionState("CONNECTED", 1);
    DISCONNECTED = new ConnectionState("DISCONNECTED", 2);
    ConnectionState[] arrayOfConnectionState = new ConnectionState[3];
    arrayOfConnectionState[0] = CONNECTING;
    arrayOfConnectionState[1] = CONNECTED;
    arrayOfConnectionState[2] = DISCONNECTED;
    $VALUES = arrayOfConnectionState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushService.ConnectionState
 * JD-Core Version:    0.6.0
 */