package com.facebook.orca.location;

public class LatitudeLongitude
{
  private final double a;
  private final double b;

  private LatitudeLongitude(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }

  public static LatitudeLongitude a(Coordinates paramCoordinates)
  {
    return new LatitudeLongitude(paramCoordinates.b(), paramCoordinates.c());
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      LatitudeLongitude localLatitudeLongitude = (LatitudeLongitude)paramObject;
      if (Double.compare(localLatitudeLongitude.a, this.a) != 0)
      {
        i = 0;
        continue;
      }
      if (Double.compare(localLatitudeLongitude.b, this.b) == 0)
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    long l1 = 0L;
    long l2;
    if (this.a != 0.0D)
      l2 = Double.doubleToLongBits(this.a);
    while (true)
    {
      int i = (int)(l2 ^ l2 >>> 32);
      if (this.b != 0.0D)
        l1 = Double.doubleToLongBits(this.b);
      return i * 31 + (int)(l1 ^ l1 >>> 32);
      l2 = l1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.LatitudeLongitude
 * JD-Core Version:    0.6.0
 */