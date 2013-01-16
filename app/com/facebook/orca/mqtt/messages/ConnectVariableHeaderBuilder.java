package com.facebook.orca.mqtt.messages;

public class ConnectVariableHeaderBuilder
{
  private int a;
  private boolean b;
  private boolean c;
  private boolean d;
  private int e;
  private boolean f;
  private boolean g;
  private int h;

  public int a()
  {
    return this.a;
  }

  public ConnectVariableHeaderBuilder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }

  public ConnectVariableHeaderBuilder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public ConnectVariableHeaderBuilder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public ConnectVariableHeaderBuilder b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }

  public boolean b()
  {
    return this.b;
  }

  public ConnectVariableHeaderBuilder c(int paramInt)
  {
    this.h = paramInt;
    return this;
  }

  public ConnectVariableHeaderBuilder c(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }

  public boolean c()
  {
    return this.c;
  }

  public ConnectVariableHeaderBuilder d(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }

  public boolean d()
  {
    return this.f;
  }

  public ConnectVariableHeaderBuilder e(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
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

  public ConnectVariableHeader i()
  {
    return new ConnectVariableHeader(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.ConnectVariableHeaderBuilder
 * JD-Core Version:    0.6.0
 */