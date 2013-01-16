package com.facebook.orca.mqtt;

public enum ConnectionFailureReason
{
  static
  {
    MQTT_ERROR = new ConnectionFailureReason("MQTT_ERROR", 1);
    ConnectionFailureReason[] arrayOfConnectionFailureReason = new ConnectionFailureReason[2];
    arrayOfConnectionFailureReason[0] = NETWORK_ERROR;
    arrayOfConnectionFailureReason[1] = MQTT_ERROR;
    $VALUES = arrayOfConnectionFailureReason;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.ConnectionFailureReason
 * JD-Core Version:    0.6.0
 */