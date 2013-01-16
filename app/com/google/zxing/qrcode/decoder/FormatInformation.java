package com.google.zxing.qrcode.decoder;

final class FormatInformation
{
  private static final int[][] a = { { 21522, 0 }, { 20773, 1 }, { 24188, 2 }, { 23371, 3 }, { 17913, 4 }, { 16590, 5 }, { 20375, 6 }, { 19104, 7 }, { 30660, 8 }, { 29427, 9 }, { 32170, 10 }, { 30877, 11 }, { 26159, 12 }, { 25368, 13 }, { 27713, 14 }, { 26998, 15 }, { 5769, 16 }, { 5054, 17 }, { 7399, 18 }, { 6608, 19 }, { 1890, 20 }, { 597, 21 }, { 3340, 22 }, { 2107, 23 }, { 13663, 24 }, { 12392, 25 }, { 16177, 26 }, { 14854, 27 }, { 9396, 28 }, { 8579, 29 }, { 11994, 30 }, { 11245, 31 } };
  private static final int[] b = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
  private final ErrorCorrectionLevel c;
  private final byte d;

  private FormatInformation(int paramInt)
  {
    this.c = ErrorCorrectionLevel.forBits(0x3 & paramInt >> 3);
    this.d = (byte)(paramInt & 0x7);
  }

  static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 ^ paramInt2;
    return b[(i & 0xF)] + b[(0xF & i >>> 4)] + b[(0xF & i >>> 8)] + b[(0xF & i >>> 12)] + b[(0xF & i >>> 16)] + b[(0xF & i >>> 20)] + b[(0xF & i >>> 24)] + b[(0xF & i >>> 28)];
  }

  static FormatInformation b(int paramInt1, int paramInt2)
  {
    FormatInformation localFormatInformation = c(paramInt1, paramInt2);
    if (localFormatInformation != null);
    while (true)
    {
      return localFormatInformation;
      localFormatInformation = c(paramInt1 ^ 0x5412, paramInt2 ^ 0x5412);
    }
  }

  private static FormatInformation c(int paramInt1, int paramInt2)
  {
    int i = 2147483647;
    int[][] arrayOfInt = a;
    int j = arrayOfInt.length;
    int k = 0;
    int m = 0;
    int[] arrayOfInt1;
    int n;
    FormatInformation localFormatInformation;
    label61: int i1;
    if (k < j)
    {
      arrayOfInt1 = arrayOfInt[k];
      n = arrayOfInt1[0];
      if ((n == paramInt1) || (n == paramInt2))
      {
        localFormatInformation = new FormatInformation(arrayOfInt1[1]);
        return localFormatInformation;
      }
      i1 = a(paramInt1, n);
      if (i1 >= i)
        break label159;
    }
    for (int i2 = arrayOfInt1[1]; ; i2 = m)
    {
      int i3;
      if (paramInt1 != paramInt2)
      {
        i3 = a(paramInt2, n);
        if (i3 < i1)
          i2 = arrayOfInt1[1];
      }
      while (true)
      {
        k++;
        int i4 = i2;
        i = i3;
        m = i4;
        break;
        if (i <= 3)
        {
          localFormatInformation = new FormatInformation(m);
          break label61;
        }
        localFormatInformation = null;
        break label61;
        i3 = i1;
      }
      label159: i1 = i;
    }
  }

  ErrorCorrectionLevel a()
  {
    return this.c;
  }

  byte b()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = paramObject instanceof FormatInformation;
    int i = 0;
    if (!bool);
    while (true)
    {
      return i;
      FormatInformation localFormatInformation = (FormatInformation)paramObject;
      ErrorCorrectionLevel localErrorCorrectionLevel1 = this.c;
      ErrorCorrectionLevel localErrorCorrectionLevel2 = localFormatInformation.c;
      i = 0;
      if (localErrorCorrectionLevel1 != localErrorCorrectionLevel2)
        continue;
      int j = this.d;
      int k = localFormatInformation.d;
      i = 0;
      if (j != k)
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    return this.c.ordinal() << 3 | this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.FormatInformation
 * JD-Core Version:    0.6.0
 */