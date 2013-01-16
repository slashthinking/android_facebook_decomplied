package com.facebook.orca.mqtt.messages;

public class FixedHeader
{
  private final int a;
  private final boolean b;
  private final int c;
  private final boolean d;
  private final int e;

  FixedHeader(FixedHeaderBuilder paramFixedHeaderBuilder)
  {
    this.a = paramFixedHeaderBuilder.a();
    this.b = paramFixedHeaderBuilder.b();
    this.c = paramFixedHeaderBuilder.c();
    this.d = paramFixedHeaderBuilder.d();
    this.e = paramFixedHeaderBuilder.e();
  }

  public static FixedHeaderBuilder newBuilder()
  {
    return new FixedHeaderBuilder();
  }

  public int a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.FixedHeader
 * JD-Core Version:    0.6.0
 */