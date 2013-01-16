package com.facebook.orca.location;

public class GeolocationInfo
{
  private final double a;
  private final double b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;

  public GeolocationInfo()
  {
    this.a = 0.0D;
    this.b = 0.0D;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
  }

  public GeolocationInfo(Coordinates paramCoordinates, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramCoordinates.b();
    this.b = paramCoordinates.c();
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
  }

  public double a()
  {
    return this.a;
  }

  public double b()
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

  public String f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.GeolocationInfo
 * JD-Core Version:    0.6.0
 */