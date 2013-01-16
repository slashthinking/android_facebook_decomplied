package com.facebook.orca.mqtt;

 enum MqttClient$State
{
  static
  {
    CONNECTING = new State("CONNECTING", 1);
    CONNECTED = new State("CONNECTED", 2);
    DISCONNECTED = new State("DISCONNECTED", 3);
    State[] arrayOfState = new State[4];
    arrayOfState[0] = INIT;
    arrayOfState[1] = CONNECTING;
    arrayOfState[2] = CONNECTED;
    arrayOfState[3] = DISCONNECTED;
    $VALUES = arrayOfState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.MqttClient.State
 * JD-Core Version:    0.6.0
 */