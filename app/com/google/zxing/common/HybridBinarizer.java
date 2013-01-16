package com.google.zxing.common;

import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer
{
  private BitMatrix a;

  public HybridBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2);
    while (true)
    {
      return paramInt2;
      if (paramInt1 > paramInt3)
      {
        paramInt2 = paramInt3;
        continue;
      }
      paramInt2 = paramInt1;
    }
  }

  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitMatrix paramBitMatrix)
  {
    int i = paramInt1 + paramInt2 * paramInt4;
    int j = 0;
    while (j < 8)
    {
      for (int k = 0; k < 8; k++)
      {
        if ((0xFF & paramArrayOfByte[(i + k)]) > paramInt3)
          continue;
        paramBitMatrix.b(paramInt1 + k, paramInt2 + j);
      }
      j++;
      i += paramInt4;
    }
  }

  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[][] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = 0;
    int j;
    int k;
    if (i < paramInt2)
    {
      j = i << 3;
      k = paramInt4 - 8;
      if (j <= k)
        break label186;
    }
    while (true)
    {
      int m = 0;
      label32: int n;
      int i1;
      if (m < paramInt1)
      {
        n = m << 3;
        i1 = paramInt3 - 8;
        if (n <= i1)
          break label179;
      }
      while (true)
      {
        int i2 = a(m, 2, paramInt1 - 3);
        int i3 = a(i, 2, paramInt2 - 3);
        int i4 = 0;
        for (int i5 = -2; i5 <= 2; i5++)
        {
          int[] arrayOfInt = paramArrayOfInt[(i3 + i5)];
          i4 += arrayOfInt[(i2 - 2)] + arrayOfInt[(i2 - 1)] + arrayOfInt[i2] + arrayOfInt[(i2 + 1)] + arrayOfInt[(i2 + 2)];
        }
        a(paramArrayOfByte, i1, k, i4 / 25, paramInt3, paramBitMatrix);
        m++;
        break label32;
        i++;
        break;
        return;
        label179: i1 = n;
      }
      label186: k = j;
    }
  }

  private static int[][] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = { paramInt2, paramInt1 };
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt);
    int i = 0;
    int j;
    int k;
    if (i < paramInt2)
    {
      j = i << 3;
      k = paramInt4 - 8;
      if (j <= k)
        break label436;
    }
    while (true)
    {
      int m = 0;
      label58: int n;
      int i1;
      if (m < paramInt1)
      {
        n = m << 3;
        i1 = paramInt3 - 8;
        if (n <= i1)
          break label429;
      }
      while (true)
      {
        int i2 = 0;
        int i3 = 255;
        int i4 = 0;
        int i5 = 0;
        int i6 = i1 + k * paramInt3;
        label106: int i9;
        label116: int i17;
        int i18;
        if (i5 < 8)
        {
          i9 = 0;
          if (i9 < 8)
          {
            i17 = 0xFF & paramArrayOfByte[(i6 + i9)];
            i18 = i2 + i17;
            if (i17 >= i3)
              break label422;
          }
        }
        label408: label422: for (int i19 = i17; ; i19 = i3)
        {
          if (i17 > i4);
          while (true)
          {
            i9++;
            i3 = i19;
            i4 = i17;
            i2 = i18;
            break label116;
            if (i4 - i3 > 24)
            {
              int i14 = i5 + 1;
              i10 = i6 + paramInt3;
              i11 = i14;
              int i15;
              for (i12 = i2; i11 < 8; i12 = i15)
              {
                i15 = i12;
                for (int i16 = 0; i16 < 8; i16++)
                  i15 += (0xFF & paramArrayOfByte[(i10 + i16)]);
                i11++;
                i10 += paramInt3;
              }
            }
            int i10 = i6;
            int i11 = i5;
            int i12 = i2;
            int i13 = i11 + 1;
            i6 = i10 + paramInt3;
            i2 = i12;
            i5 = i13;
            break label106;
            int i7 = i2 >> 6;
            int i8;
            if (i4 - i3 <= 24)
            {
              i8 = i3 >> 1;
              if ((i <= 0) || (m <= 0))
                break label408;
              i7 = arrayOfInt1[(i - 1)][m] + 2 * arrayOfInt1[i][(m - 1)] + arrayOfInt1[(i - 1)][(m - 1)] >> 2;
              if (i3 >= i7)
                break label408;
            }
            while (true)
            {
              arrayOfInt1[i][m] = i7;
              m++;
              break label58;
              i++;
              break;
              return arrayOfInt1;
              i7 = i8;
            }
            i17 = i4;
          }
        }
        label429: i1 = n;
      }
      label436: k = j;
    }
  }

  public BitMatrix b()
  {
    BitMatrix localBitMatrix1;
    if (this.a != null)
    {
      localBitMatrix1 = this.a;
      return localBitMatrix1;
    }
    LuminanceSource localLuminanceSource = a();
    int i = localLuminanceSource.b();
    int j = localLuminanceSource.c();
    BitMatrix localBitMatrix2;
    if ((i >= 40) && (j >= 40))
    {
      byte[] arrayOfByte = localLuminanceSource.a();
      int k = i >> 3;
      if ((i & 0x7) != 0)
        k++;
      int m = j >> 3;
      if ((j & 0x7) != 0)
        m++;
      int[][] arrayOfInt = a(arrayOfByte, k, m, i, j);
      localBitMatrix2 = new BitMatrix(i, j);
      a(arrayOfByte, k, m, i, j, arrayOfInt, localBitMatrix2);
    }
    for (this.a = localBitMatrix2; ; this.a = super.b())
    {
      localBitMatrix1 = this.a;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.HybridBinarizer
 * JD-Core Version:    0.6.0
 */