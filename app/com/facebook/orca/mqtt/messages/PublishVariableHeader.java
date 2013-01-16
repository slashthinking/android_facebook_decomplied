package com.facebook.orca.mqtt.messages;

public class PublishVariableHeader
{
  private final String a;
  private final int b;

  public PublishVariableHeader(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.PublishVariableHeader
 * JD-Core Version:    0.6.0
 */