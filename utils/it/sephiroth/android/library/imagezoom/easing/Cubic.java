package it.sephiroth.android.library.imagezoom.easing;

public class Cubic
  implements Easing
{
  public double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d = paramDouble1 / paramDouble4 - 1.0D;
    return paramDouble2 + paramDouble3 * (1.0D + d * (d * d));
  }

  public double b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d1 = paramDouble1 / (paramDouble4 / 2.0D);
    if (d1 < 1.0D);
    double d2;
    double d3;
    for (double d4 = paramDouble2 + d1 * (d1 * (d1 * (paramDouble3 / 2.0D))); ; d4 = paramDouble2 + d2 * (2.0D + d3 * (d3 * d3)))
    {
      return d4;
      d2 = paramDouble3 / 2.0D;
      d3 = d1 - 2.0D;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.easing.Cubic
 * JD-Core Version:    0.6.2
 */