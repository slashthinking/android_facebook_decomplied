package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

final class MatrixUtil
{
  private static final int[][] a = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  private static final int[][] b = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
  private static final int[][] c = { { -1, -1, -1, -1, -1, -1, -1 }, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, { 6, 22, 38, -1, -1, -1, -1 }, { 6, 24, 42, -1, -1, -1, -1 }, { 6, 26, 46, -1, -1, -1, -1 }, { 6, 28, 50, -1, -1, -1, -1 }, { 6, 30, 54, -1, -1, -1, -1 }, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, { 6, 26, 50, 74, -1, -1, -1 }, { 6, 30, 54, 78, -1, -1, -1 }, { 6, 30, 56, 82, -1, -1, -1 }, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, { 6, 30, 58, 86, 114, -1, -1 }, { 6, 34, 62, 90, 118, -1, -1 }, { 6, 26, 50, 74, 98, 122, -1 }, { 6, 30, 54, 78, 102, 126, -1 }, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, { 6, 34, 60, 86, 112, 138, -1 }, { 6, 30, 58, 86, 114, 142, -1 }, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, { 6, 30, 58, 86, 114, 142, 170 } };
  private static final int[][] d = { { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 7 }, { 8, 8 }, { 7, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 } };

  static int a(int paramInt)
  {
    for (int i = 0; paramInt != 0; i++)
      paramInt >>>= 1;
    return i;
  }

  static int a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt2);
    int j = paramInt1 << i - 1;
    while (a(j) >= i)
      j ^= paramInt2 << a(j) - i;
    return j;
  }

  private static void a(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    for (int i = 0; i < 8; i++)
    {
      if (!b(paramByteMatrix.a(paramInt1 + i, paramInt2)))
        throw new WriterException();
      paramByteMatrix.a(paramInt1 + i, paramInt2, 0);
    }
  }

  static void a(BitArray paramBitArray, int paramInt, ByteMatrix paramByteMatrix)
  {
    int i = -1 + paramByteMatrix.b();
    int j = -1 + paramByteMatrix.a();
    int k = -1;
    int m = 0;
    int n;
    int i1;
    int i2;
    if (i > 0)
    {
      if (i != 6)
        break label270;
      int i7 = i - 1;
      n = j;
      i1 = i7;
      i2 = m;
    }
    while (true)
    {
      if ((n >= 0) && (n < paramByteMatrix.a()))
      {
        int i4 = 0;
        while (i4 < 2)
        {
          int i5 = i1 - i4;
          if (!b(paramByteMatrix.a(i5, n)))
          {
            i4++;
            continue;
          }
          int i6;
          if (i2 < paramBitArray.a())
          {
            boolean bool2 = paramBitArray.a(i2);
            i6 = i2 + 1;
            bool1 = bool2;
            label125: if ((paramInt != -1) && (MaskUtil.a(paramInt, i5, n)))
              if (bool1)
                break label176;
          }
          label176: for (boolean bool1 = true; ; bool1 = false)
          {
            paramByteMatrix.a(i5, n, bool1);
            i2 = i6;
            break;
            i6 = i2;
            bool1 = false;
            break label125;
          }
        }
        n += k;
        continue;
      }
      k = -k;
      int i3 = n + k;
      i = i1 - 2;
      m = i2;
      j = i3;
      break;
      if (m != paramBitArray.a())
        throw new WriterException("Not all bits consumed: " + m + '/' + paramBitArray.a());
      return;
      label270: n = j;
      i1 = i;
      i2 = m;
    }
  }

  static void a(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, int paramInt, ByteMatrix paramByteMatrix)
  {
    a(paramByteMatrix);
    a(paramVersion, paramByteMatrix);
    a(paramErrorCorrectionLevel, paramInt, paramByteMatrix);
    b(paramVersion, paramByteMatrix);
    a(paramBitArray, paramInt, paramByteMatrix);
  }

  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, BitArray paramBitArray)
  {
    if (!QRCode.b(paramInt))
      throw new WriterException("Invalid mask pattern");
    int i = paramInt | paramErrorCorrectionLevel.getBits() << 3;
    paramBitArray.a(i, 5);
    paramBitArray.a(a(i, 1335), 10);
    BitArray localBitArray = new BitArray();
    localBitArray.a(21522, 15);
    paramBitArray.b(localBitArray);
    if (paramBitArray.a() != 15)
      throw new WriterException("should not happen but we got: " + paramBitArray.a());
  }

  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ByteMatrix paramByteMatrix)
  {
    BitArray localBitArray = new BitArray();
    a(paramErrorCorrectionLevel, paramInt, localBitArray);
    int i = 0;
    if (i < localBitArray.a())
    {
      boolean bool = localBitArray.a(-1 + localBitArray.a() - i);
      paramByteMatrix.a(d[i][0], d[i][1], bool);
      if (i < 8)
        paramByteMatrix.a(-1 + (paramByteMatrix.b() - i), 8, bool);
      while (true)
      {
        i++;
        break;
        paramByteMatrix.a(8, -7 + paramByteMatrix.a() + (i - 8), bool);
      }
    }
  }

  static void a(Version paramVersion, BitArray paramBitArray)
  {
    paramBitArray.a(paramVersion.a(), 6);
    paramBitArray.a(a(paramVersion.a(), 7973), 12);
    if (paramBitArray.a() != 18)
      throw new WriterException("should not happen but we got: " + paramBitArray.a());
  }

  static void a(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    d(paramByteMatrix);
    c(paramByteMatrix);
    c(paramVersion, paramByteMatrix);
    b(paramByteMatrix);
  }

  static void a(ByteMatrix paramByteMatrix)
  {
    paramByteMatrix.a(-1);
  }

  private static void b(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    for (int i = 0; i < 7; i++)
    {
      if (!b(paramByteMatrix.a(paramInt1, paramInt2 + i)))
        throw new WriterException();
      paramByteMatrix.a(paramInt1, paramInt2 + i, 0);
    }
  }

  static void b(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    if (paramVersion.a() < 7);
    while (true)
    {
      return;
      BitArray localBitArray = new BitArray();
      a(paramVersion, localBitArray);
      int i = 17;
      int j = 0;
      while (j < 6)
      {
        int k = i;
        for (int m = 0; m < 3; m++)
        {
          boolean bool = localBitArray.a(k);
          k--;
          paramByteMatrix.a(j, m + (-11 + paramByteMatrix.a()), bool);
          paramByteMatrix.a(m + (-11 + paramByteMatrix.a()), j, bool);
        }
        j++;
        i = k;
      }
    }
  }

  private static void b(ByteMatrix paramByteMatrix)
  {
    for (int i = 8; i < -8 + paramByteMatrix.b(); i++)
    {
      int j = (i + 1) % 2;
      if (b(paramByteMatrix.a(i, 6)))
        paramByteMatrix.a(i, 6, j);
      if (!b(paramByteMatrix.a(6, i)))
        continue;
      paramByteMatrix.a(6, i, j);
    }
  }

  private static boolean b(int paramInt)
  {
    if (paramInt == -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  private static void c(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 5; j++)
        paramByteMatrix.a(paramInt1 + j, paramInt2 + i, b[i][j]);
  }

  private static void c(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    if (paramVersion.a() < 2);
    while (true)
    {
      return;
      int i = -1 + paramVersion.a();
      int[] arrayOfInt = c[i];
      int j = c[i].length;
      for (int k = 0; k < j; k++)
      {
        int m = 0;
        if (m >= j)
          continue;
        int n = arrayOfInt[k];
        int i1 = arrayOfInt[m];
        if ((i1 == -1) || (n == -1));
        while (true)
        {
          m++;
          break;
          if (!b(paramByteMatrix.a(i1, n)))
            continue;
          c(i1 - 2, n - 2, paramByteMatrix);
        }
      }
    }
  }

  private static void c(ByteMatrix paramByteMatrix)
  {
    if (paramByteMatrix.a(8, -8 + paramByteMatrix.a()) == 0)
      throw new WriterException();
    paramByteMatrix.a(8, -8 + paramByteMatrix.a(), 1);
  }

  private static void d(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    for (int i = 0; i < 7; i++)
      for (int j = 0; j < 7; j++)
        paramByteMatrix.a(paramInt1 + j, paramInt2 + i, a[i][j]);
  }

  private static void d(ByteMatrix paramByteMatrix)
  {
    int i = a[0].length;
    d(0, 0, paramByteMatrix);
    d(paramByteMatrix.b() - i, 0, paramByteMatrix);
    d(0, paramByteMatrix.b() - i, paramByteMatrix);
    a(0, 7, paramByteMatrix);
    a(paramByteMatrix.b() - 8, 7, paramByteMatrix);
    a(0, paramByteMatrix.b() - 8, paramByteMatrix);
    b(7, 0, paramByteMatrix);
    b(-1 + (paramByteMatrix.a() - 7), 0, paramByteMatrix);
    b(7, paramByteMatrix.a() - 7, paramByteMatrix);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.MatrixUtil
 * JD-Core Version:    0.6.0
 */