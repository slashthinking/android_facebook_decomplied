package com.facebook.orca.push;

public enum PushType
{
  static
  {
    PushType[] arrayOfPushType = new PushType[2];
    arrayOfPushType[0] = C2DM;
    arrayOfPushType[1] = MQTT;
    $VALUES = arrayOfPushType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.PushType
 * JD-Core Version:    0.6.0
 */