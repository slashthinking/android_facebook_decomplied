package com.facebook.orca.appconfig;

public class AppConfigBuilder
{
  private String a;
  private String b;
  private String c;
  private int d;
  private int e;

  public AppConfigBuilder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  public AppConfigBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public AppConfigBuilder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public AppConfigBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public AppConfigBuilder c(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public String c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public AppConfig f()
  {
    return new AppConfig(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.appconfig.AppConfigBuilder
 * JD-Core Version:    0.6.0
 */