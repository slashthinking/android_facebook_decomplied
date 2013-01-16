package com.facebook.orca.mqtt;

public enum MqttQOSLevel
{
  private final int value;

  static
  {
    FIRE_AND_FORGET = new MqttQOSLevel("FIRE_AND_FORGET", 1, 0);
    ACKNOWLEDGED_DELIVERY = new MqttQOSLevel("ACKNOWLEDGED_DELIVERY", 2, 1);
    ASSURED_DELIVERY = new MqttQOSLevel("ASSURED_DELIVERY", 3, 2);
    MqttQOSLevel[] arrayOfMqttQOSLevel = new MqttQOSLevel[4];
    arrayOfMqttQOSLevel[0] = UNKNOWN;
    arrayOfMqttQOSLevel[1] = FIRE_AND_FORGET;
    arrayOfMqttQOSLevel[2] = ACKNOWLEDGED_DELIVERY;
    arrayOfMqttQOSLevel[3] = ASSURED_DELIVERY;
    $VALUES = arrayOfMqttQOSLevel;
  }

  private MqttQOSLevel(int paramInt)
  {
    this.value = paramInt;
  }

  public static MqttQOSLevel fromInt(int paramInt)
  {
    MqttQOSLevel localMqttQOSLevel;
    switch (paramInt)
    {
    default:
      localMqttQOSLevel = UNKNOWN;
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return localMqttQOSLevel;
      localMqttQOSLevel = FIRE_AND_FORGET;
      continue;
      localMqttQOSLevel = ACKNOWLEDGED_DELIVERY;
      continue;
      localMqttQOSLevel = ASSURED_DELIVERY;
    }
  }

  public int getValue()
  {
    return this.value;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.MqttQOSLevel
 * JD-Core Version:    0.6.0
 */