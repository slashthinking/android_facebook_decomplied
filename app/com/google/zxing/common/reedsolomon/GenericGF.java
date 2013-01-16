package com.google.zxing.common.reedsolomon;

public final class GenericGF
{
  public static final GenericGF a = new GenericGF(4201, 4096);
  public static final GenericGF b = new GenericGF(1033, 1024);
  public static final GenericGF c = new GenericGF(67, 64);
  public static final GenericGF d = new GenericGF(19, 16);
  public static final GenericGF e = new GenericGF(285, 256);
  public static final GenericGF f = new GenericGF(301, 256);
  public static final GenericGF g = f;
  public static final GenericGF h = c;
  private int[] i;
  private int[] j;
  private GenericGFPoly k;
  private GenericGFPoly l;
  private final int m;
  private final int n;
  private boolean o = false;

  public GenericGF(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.m = paramInt2;
    if (paramInt2 <= 0)
      d();
  }

  static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }

  private void d()
  {
    this.i = new int[this.m];
    this.j = new int[this.m];
    int i1 = 0;
    int i2 = 1;
    while (i1 < this.m)
    {
      this.i[i1] = i2;
      i2 <<= 1;
      if (i2 >= this.m)
        i2 = (i2 ^ this.n) & -1 + this.m;
      i1++;
    }
    for (int i3 = 0; i3 < -1 + this.m; i3++)
      this.j[this.i[i3]] = i3;
    this.k = new GenericGFPoly(this, new int[] { 0 });
    this.l = new GenericGFPoly(this, new int[] { 1 });
    this.o = true;
  }

  private void e()
  {
    if (!this.o)
      d();
  }

  int a(int paramInt)
  {
    e();
    return this.i[paramInt];
  }

  GenericGFPoly a()
  {
    e();
    return this.k;
  }

  GenericGFPoly a(int paramInt1, int paramInt2)
  {
    e();
    if (paramInt1 < 0)
      throw new IllegalArgumentException();
    if (paramInt2 == 0);
    int[] arrayOfInt;
    for (GenericGFPoly localGenericGFPoly = this.k; ; localGenericGFPoly = new GenericGFPoly(this, arrayOfInt))
    {
      return localGenericGFPoly;
      arrayOfInt = new int[paramInt1 + 1];
      arrayOfInt[0] = paramInt2;
    }
  }

  int b(int paramInt)
  {
    e();
    if (paramInt == 0)
      throw new IllegalArgumentException();
    return this.j[paramInt];
  }

  GenericGFPoly b()
  {
    e();
    return this.l;
  }

  public int c()
  {
    return this.m;
  }

  int c(int paramInt)
  {
    e();
    if (paramInt == 0)
      throw new ArithmeticException();
    return this.i[(-1 + (this.m - this.j[paramInt]))];
  }

  int c(int paramInt1, int paramInt2)
  {
    e();
    if ((paramInt1 == 0) || (paramInt2 == 0));
    for (int i1 = 0; ; i1 = this.i[((this.j[paramInt1] + this.j[paramInt2]) % (-1 + this.m))])
      return i1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGF
 * JD-Core Version:    0.6.0
 */