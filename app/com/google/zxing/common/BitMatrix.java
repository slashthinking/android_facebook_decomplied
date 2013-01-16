package com.google.zxing.common;

public final class BitMatrix
{
  private final int a;
  private final int b;
  private final int c;
  private final int[] d;

  public BitMatrix(int paramInt)
  {
    this(paramInt, paramInt);
  }

  public BitMatrix(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1))
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = (paramInt1 + 31 >> 5);
    this.d = new int[paramInt2 * this.c];
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0))
      throw new IllegalArgumentException("Left and top must be nonnegative");
    if ((paramInt4 < 1) || (paramInt3 < 1))
      throw new IllegalArgumentException("Height and width must be at least 1");
    int i = paramInt1 + paramInt3;
    int j = paramInt2 + paramInt4;
    if ((j > this.b) || (i > this.a))
      throw new IllegalArgumentException("The region must fit inside the matrix");
    while (true)
    {
      paramInt2++;
      if (paramInt2 >= j)
        break;
      int k = paramInt2 * this.c;
      for (int m = paramInt1; m < i; m++)
      {
        int[] arrayOfInt = this.d;
        int n = k + (m >> 5);
        arrayOfInt[n] |= 1 << (m & 0x1F);
      }
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    if ((0x1 & this.d[i] >>> (paramInt1 & 0x1F)) != 0);
    for (int j = 1; ; j = 0)
      return j;
  }

  public int[] a()
  {
    for (int i = 0; (i < this.d.length) && (this.d[i] == 0); i++);
    if (i == this.d.length);
    int j;
    int k;
    int n;
    for (int[] arrayOfInt = null; ; arrayOfInt = new int[] { k + n, j })
    {
      return arrayOfInt;
      j = i / this.c;
      k = i % this.c << 5;
      int m = this.d[i];
      for (n = 0; m << 31 - n == 0; n++);
    }
  }

  public void b(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    int[] arrayOfInt = this.d;
    arrayOfInt[i] |= 1 << (paramInt1 & 0x1F);
  }

  public int[] b()
  {
    for (int i = -1 + this.d.length; (i >= 0) && (this.d[i] == 0); i--);
    if (i < 0);
    int j;
    int k;
    int n;
    for (int[] arrayOfInt = null; ; arrayOfInt = new int[] { k + n, j })
    {
      return arrayOfInt;
      j = i / this.c;
      k = i % this.c << 5;
      int m = this.d[i];
      for (n = 31; m >>> n == 0; n--);
    }
  }

  public int c()
  {
    return this.a;
  }

  public void c(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    int[] arrayOfInt = this.d;
    arrayOfInt[i] ^= 1 << (paramInt1 & 0x1F);
  }

  public int d()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = paramObject instanceof BitMatrix;
    int i = 0;
    if (!bool);
    while (true)
    {
      return i;
      BitMatrix localBitMatrix = (BitMatrix)paramObject;
      int j = this.a;
      int k = localBitMatrix.a;
      i = 0;
      if (j != k)
        continue;
      int m = this.b;
      int n = localBitMatrix.b;
      i = 0;
      if (m != n)
        continue;
      int i1 = this.c;
      int i2 = localBitMatrix.c;
      i = 0;
      if (i1 != i2)
        continue;
      int i3 = this.d.length;
      int i4 = localBitMatrix.d.length;
      i = 0;
      if (i3 != i4)
        continue;
      for (int i5 = 0; ; i5++)
      {
        if (i5 >= this.d.length)
          break label156;
        int i6 = this.d[i5];
        int i7 = localBitMatrix.d[i5];
        i = 0;
        if (i6 != i7)
          break;
      }
      label156: i = 1;
    }
  }

  public int hashCode()
  {
    int i = 31 * (31 * (31 * this.a + this.a) + this.b) + this.c;
    int[] arrayOfInt = this.d;
    int j = arrayOfInt.length;
    for (int k = 0; k < j; k++)
      i = arrayOfInt[k] + i * 31;
    return i;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * (1 + this.a));
    for (int i = 0; i < this.b; i++)
    {
      int j = 0;
      if (j < this.a)
      {
        if (a(j, i));
        for (String str = "X "; ; str = "  ")
        {
          localStringBuilder.append(str);
          j++;
          break;
        }
      }
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.BitMatrix
 * JD-Core Version:    0.6.0
 */