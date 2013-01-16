package com.facebook.orca.mqtt.messages;

public class MqttMessage
{
  private final FixedHeader a;
  private final Object b;
  private final Object c;

  public MqttMessage(FixedHeader paramFixedHeader, Object paramObject1, Object paramObject2)
  {
    this.a = paramFixedHeader;
    this.b = paramObject1;
    this.c = paramObject2;
  }

  public Object b()
  {
    return this.b;
  }

  public Object d()
  {
    return this.c;
  }

  public int e()
  {
    return this.a.a();
  }

  public FixedHeader f()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.MqttMessage
 * JD-Core Version:    0.6.0
 */