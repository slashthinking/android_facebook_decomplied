package com.facebook.orca.threads;

public enum Message$ChannelSource
{
  static
  {
    C2DM = new ChannelSource("C2DM", 2);
    MQTT = new ChannelSource("MQTT", 3);
    MMS = new ChannelSource("MMS", 4);
    SEND = new ChannelSource("SEND", 5);
    SMS = new ChannelSource("SMS", 6);
    ChannelSource[] arrayOfChannelSource = new ChannelSource[7];
    arrayOfChannelSource[0] = API;
    arrayOfChannelSource[1] = CALL_LOG;
    arrayOfChannelSource[2] = C2DM;
    arrayOfChannelSource[3] = MQTT;
    arrayOfChannelSource[4] = MMS;
    arrayOfChannelSource[5] = SEND;
    arrayOfChannelSource[6] = SMS;
    $VALUES = arrayOfChannelSource;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.Message.ChannelSource
 * JD-Core Version:    0.6.0
 */