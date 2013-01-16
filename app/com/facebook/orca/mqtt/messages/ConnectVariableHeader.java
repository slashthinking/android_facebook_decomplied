package com.facebook.orca.mqtt.messages;

public class ConnectVariableHeader
{
  private final int a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final int e;
  private final boolean f;
  private final boolean g;
  private final int h;

  ConnectVariableHeader(ConnectVariableHeaderBuilder paramConnectVariableHeaderBuilder)
  {
    this.a = paramConnectVariableHeaderBuilder.a();
    this.b = paramConnectVariableHeaderBuilder.b();
    this.c = paramConnectVariableHeaderBuilder.c();
    this.d = paramConnectVariableHeaderBuilder.e();
    this.e = paramConnectVariableHeaderBuilder.f();
    this.f = paramConnectVariableHeaderBuilder.d();
    this.g = paramConnectVariableHeaderBuilder.g();
    this.h = paramConnectVariableHeaderBuilder.h();
  }

  public int a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.f;
  }

  public boolean e()
  {
    return this.d;
  }

  public int f()
  {
    return this.e;
  }

  public boolean g()
  {
    return this.g;
  }

  public int h()
  {
    return this.h;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.ConnectVariableHeader
 * JD-Core Version:    0.6.0
 */