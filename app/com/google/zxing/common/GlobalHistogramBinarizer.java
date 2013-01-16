package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

public class GlobalHistogramBinarizer extends Binarizer
{
  private static final byte[] a = new byte[0];
  private byte[] b = a;
  private final int[] c = new int[32];

  public GlobalHistogramBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }

  private static int a(int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (k < j)
    {
      if (paramArrayOfInt[k] > m)
      {
        m = paramArrayOfInt[k];
        n = k;
      }
      if (paramArrayOfInt[k] > i1)
        i1 = paramArrayOfInt[k];
      k++;
    }
    int i2 = 0;
    int i3 = 0;
    int i12;
    if (i < j)
    {
      int i11 = i - n;
      i12 = i11 * (i11 * paramArrayOfInt[i]);
      if (i12 <= i2)
        break label236;
    }
    for (int i13 = i; ; i13 = i3)
    {
      i++;
      i3 = i13;
      i2 = i12;
      break;
      int i4;
      if (n > i3)
      {
        i4 = i3;
        i3 = n;
      }
      while (true)
      {
        if (i3 - i4 <= j >> 4)
          throw NotFoundException.a();
        int i5 = i3 - 1;
        int i6 = -1;
        int i7 = i3 - 1;
        int i9;
        if (i7 > i4)
        {
          int i8 = i7 - i4;
          i9 = i8 * i8 * (i3 - i7) * (i1 - paramArrayOfInt[i7]);
          if (i9 <= i6)
            break label218;
        }
        for (int i10 = i7; ; i10 = i5)
        {
          i7--;
          i5 = i10;
          i6 = i9;
          break;
          return i5 << 3;
          label218: i9 = i6;
        }
        i4 = n;
      }
      label236: i12 = i2;
    }
  }

  private void a(int paramInt)
  {
    if (this.b.length < paramInt)
      this.b = new byte[paramInt];
    for (int i = 0; i < 32; i++)
      this.c[i] = 0;
  }

  public BitMatrix b()
  {
    LuminanceSource localLuminanceSource = a();
    int i = localLuminanceSource.b();
    int j = localLuminanceSource.c();
    BitMatrix localBitMatrix = new BitMatrix(i, j);
    a(i);
    int[] arrayOfInt = this.c;
    for (int k = 1; k < 5; k++)
    {
      byte[] arrayOfByte2 = localLuminanceSource.a(j * k / 5, this.b);
      int i3 = (i << 2) / 5;
      for (int i4 = i / 5; i4 < i3; i4++)
      {
        int i5 = (0xFF & arrayOfByte2[i4]) >> 3;
        arrayOfInt[i5] = (1 + arrayOfInt[i5]);
      }
    }
    int m = a(arrayOfInt);
    byte[] arrayOfByte1 = localLuminanceSource.a();
    for (int n = 0; n < j; n++)
    {
      int i1 = n * i;
      for (int i2 = 0; i2 < i; i2++)
      {
        if ((0xFF & arrayOfByte1[(i1 + i2)]) >= m)
          continue;
        localBitMatrix.b(i2, n);
      }
    }
    return localBitMatrix;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.GlobalHistogramBinarizer
 * JD-Core Version:    0.6.0
 */