package com.facebook.orca.location;

public class CoordinatesBuilder
{
  private Double a;
  private Double b;
  private Double c;
  private Float d;
  private Float e;
  private Float f;
  private Float g;

  public CoordinatesBuilder a(Double paramDouble)
  {
    this.a = paramDouble;
    return this;
  }

  public CoordinatesBuilder a(Float paramFloat)
  {
    this.d = paramFloat;
    return this;
  }

  public Double a()
  {
    return this.a;
  }

  public CoordinatesBuilder b(Double paramDouble)
  {
    this.b = paramDouble;
    return this;
  }

  public CoordinatesBuilder b(Float paramFloat)
  {
    this.e = paramFloat;
    return this;
  }

  public Double b()
  {
    return this.b;
  }

  public CoordinatesBuilder c(Double paramDouble)
  {
    this.c = paramDouble;
    return this;
  }

  public CoordinatesBuilder c(Float paramFloat)
  {
    this.f = paramFloat;
    return this;
  }

  public Double c()
  {
    return this.c;
  }

  public CoordinatesBuilder d(Float paramFloat)
  {
    this.g = paramFloat;
    return this;
  }

  public Float d()
  {
    return this.d;
  }

  public Float e()
  {
    return this.e;
  }

  public Float f()
  {
    return this.f;
  }

  public Float g()
  {
    return this.g;
  }

  public Coordinates h()
  {
    return new Coordinates(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.CoordinatesBuilder
 * JD-Core Version:    0.6.0
 */