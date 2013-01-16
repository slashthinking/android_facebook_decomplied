package com.facebook.orca.mqtt;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class MqttParameters
{
  private final String a;
  private final int b;
  private final boolean c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final short h;
  private final ObjectNode i;

  public MqttParameters(String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort, ObjectNode paramObjectNode)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramBoolean;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.h = paramShort;
    this.i = paramObjectNode;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public boolean d()
  {
    return true;
  }

  public short e()
  {
    return this.h;
  }

  public String f()
  {
    return this.d;
  }

  public String g()
  {
    return this.e;
  }

  public String h()
  {
    return this.f;
  }

  public String i()
  {
    return this.g;
  }

  public ObjectNode j()
  {
    return this.i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.MqttParameters
 * JD-Core Version:    0.6.0
 */