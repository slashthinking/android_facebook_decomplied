package com.facebook.orca.mqtt.messages;

public class ConnectPayload
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;

  public ConnectPayload(ConnectPayloadBuilder paramConnectPayloadBuilder)
  {
    this.a = paramConnectPayloadBuilder.a();
    this.b = paramConnectPayloadBuilder.b();
    this.c = paramConnectPayloadBuilder.c();
    this.d = paramConnectPayloadBuilder.d();
    this.e = paramConnectPayloadBuilder.e();
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.ConnectPayload
 * JD-Core Version:    0.6.0
 */