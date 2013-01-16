package com.facebook.orca.mqtt.messages;

public class FixedHeaderBuilder
{
  private int a;
  private boolean b;
  private int c;
  private boolean d;
  private int e = -1;

  public int a()
  {
    return this.a;
  }

  public FixedHeaderBuilder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }

  public FixedHeaderBuilder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public FixedHeaderBuilder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }

  public FixedHeaderBuilder b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }

  public boolean b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public FixedHeaderBuilder c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public boolean d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public FixedHeader f()
  {
    return new FixedHeader(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.FixedHeaderBuilder
 * JD-Core Version:    0.6.0
 */