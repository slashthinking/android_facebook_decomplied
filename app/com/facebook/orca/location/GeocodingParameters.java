package com.facebook.orca.location;

public class GeocodingParameters
{
  private final Coordinates a;
  private final boolean b;

  public GeocodingParameters(Coordinates paramCoordinates, boolean paramBoolean)
  {
    this.a = paramCoordinates;
    this.b = paramBoolean;
  }

  public Coordinates a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.GeocodingParameters
 * JD-Core Version:    0.6.0
 */