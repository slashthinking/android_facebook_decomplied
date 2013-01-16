package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser
{
  private final BitMatrix a;
  private Version b;
  private FormatInformation c;

  BitMatrixParser(BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.d();
    if ((i < 21) || ((i & 0x3) != 1))
      throw FormatException.a();
    this.a = paramBitMatrix;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a(paramInt1, paramInt2));
    for (int i = 0x1 | paramInt3 << 1; ; i = paramInt3 << 1)
      return i;
  }

  FormatInformation a()
  {
    int i = 0;
    if (this.c != null);
    for (FormatInformation localFormatInformation = this.c; ; localFormatInformation = this.c)
    {
      return localFormatInformation;
      int j = 0;
      int k = 0;
      while (j < 6)
      {
        k = a(j, 8, k);
        j++;
      }
      int m = a(8, 7, a(8, 8, a(7, 8, k)));
      for (int n = 5; n >= 0; n--)
        m = a(8, n, m);
      int i1 = this.a.d();
      int i2 = i1 - 7;
      for (int i3 = i1 - 1; i3 >= i2; i3--)
        i = a(8, i3, i);
      for (int i4 = i1 - 8; i4 < i1; i4++)
        i = a(i4, 8, i);
      this.c = FormatInformation.b(m, i);
      if (this.c == null)
        break;
    }
    throw FormatException.a();
  }

  Version b()
  {
    Version localVersion;
    if (this.b != null)
      localVersion = this.b;
    while (true)
    {
      return localVersion;
      int i = this.a.d();
      int j = i - 17 >> 2;
      if (j <= 6)
      {
        localVersion = Version.b(j);
        continue;
      }
      int k = i - 11;
      int m = 5;
      int n = 0;
      while (m >= 0)
      {
        for (int i4 = i - 9; i4 >= k; i4--)
          n = a(i4, m, n);
        m--;
      }
      localVersion = Version.c(n);
      if ((localVersion != null) && (localVersion.d() == i))
      {
        this.b = localVersion;
        continue;
      }
      int i1 = 0;
      for (int i2 = 5; i2 >= 0; i2--)
        for (int i3 = i - 9; i3 >= k; i3--)
          i1 = a(i2, i3, i1);
      localVersion = Version.c(i1);
      if ((localVersion == null) || (localVersion.d() != i))
        break;
      this.b = localVersion;
    }
    throw FormatException.a();
  }

  byte[] c()
  {
    FormatInformation localFormatInformation = a();
    Version localVersion = b();
    DataMask localDataMask = DataMask.a(localFormatInformation.b());
    int i = this.a.d();
    localDataMask.a(this.a, i);
    BitMatrix localBitMatrix = localVersion.e();
    byte[] arrayOfByte = new byte[localVersion.c()];
    int j = i - 1;
    int k = 0;
    int m = 0;
    int n = 0;
    int i3;
    for (int i1 = 1; j > 0; i1 = i3)
    {
      if (j == 6)
        j--;
      for (int i2 = 0; i2 < i; i2++)
      {
        if (i1 != 0);
        for (int i4 = i - 1 - i2; ; i4 = i2)
          for (int i5 = 0; i5 < 2; i5++)
          {
            if (localBitMatrix.a(j - i5, i4))
              continue;
            k++;
            m <<= 1;
            if (this.a.a(j - i5, i4))
              m |= 1;
            if (k != 8)
              continue;
            int i6 = n + 1;
            arrayOfByte[n] = (byte)m;
            m = 0;
            n = i6;
            k = 0;
          }
      }
      i3 = i1 ^ 0x1;
      j -= 2;
    }
    if (n != localVersion.c())
      throw FormatException.a();
    return arrayOfByte;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.BitMatrixParser
 * JD-Core Version:    0.6.0
 */