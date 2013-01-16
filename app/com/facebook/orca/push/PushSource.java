package com.facebook.orca.push;

public enum PushSource
{
  static
  {
    C2DM_OVER_MQTT = new PushSource("C2DM_OVER_MQTT", 2);
    SMS = new PushSource("SMS", 3);
    MMS = new PushSource("MMS", 4);
    PushSource[] arrayOfPushSource = new PushSource[5];
    arrayOfPushSource[0] = C2DM;
    arrayOfPushSource[1] = MQTT;
    arrayOfPushSource[2] = C2DM_OVER_MQTT;
    arrayOfPushSource[3] = SMS;
    arrayOfPushSource[4] = MMS;
    $VALUES = arrayOfPushSource;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.PushSource
 * JD-Core Version:    0.6.0
 */