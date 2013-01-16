package com.facebook.orca.mqtt.messages;

public class ConnAckVariableHeader
{
  private final byte a;

  public ConnAckVariableHeader(byte paramByte)
  {
    this.a = paramByte;
  }

  public byte a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.ConnAckVariableHeader
 * JD-Core Version:    0.6.0
 */