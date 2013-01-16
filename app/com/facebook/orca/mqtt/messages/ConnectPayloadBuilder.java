package com.facebook.orca.mqtt.messages;

public class ConnectPayloadBuilder
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;

  public ConnectPayloadBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public ConnectPayloadBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public ConnectPayloadBuilder c(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public String c()
  {
    return this.c;
  }

  public ConnectPayloadBuilder d(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public String d()
  {
    return this.d;
  }

  public ConnectPayloadBuilder e(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public String e()
  {
    return this.e;
  }

  public ConnectPayload f()
  {
    return new ConnectPayload(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.ConnectPayloadBuilder
 * JD-Core Version:    0.6.0
 */