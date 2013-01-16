package com.google.zxing.qrcode.decoder;

final class DataBlock
{
  private final int a;
  private final byte[] b;

  private DataBlock(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
  }

  static DataBlock[] a(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    if (paramArrayOfByte.length != paramVersion.c())
      throw new IllegalArgumentException();
    Version.ECBlocks localECBlocks = paramVersion.a(paramErrorCorrectionLevel);
    Version.ECB[] arrayOfECB = localECBlocks.d();
    int i = arrayOfECB.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfECB[j].a();
      j++;
    }
    DataBlock[] arrayOfDataBlock = new DataBlock[k];
    int m = arrayOfECB.length;
    int n = 0;
    int i18;
    for (int i1 = 0; n < m; i1 = i18)
    {
      Version.ECB localECB = arrayOfECB[n];
      i18 = i1;
      int i19 = 0;
      while (i19 < localECB.a())
      {
        int i20 = localECB.b();
        int i21 = i20 + localECBlocks.a();
        int i22 = i18 + 1;
        arrayOfDataBlock[i18] = new DataBlock(i20, new byte[i21]);
        i19++;
        i18 = i22;
      }
      n++;
    }
    int i2 = arrayOfDataBlock[0].b.length;
    int i3 = -1 + arrayOfDataBlock.length;
    int i4;
    int i5;
    int i6;
    if ((i3 < 0) || (arrayOfDataBlock[i3].b.length == i2))
    {
      i4 = i3 + 1;
      i5 = i2 - localECBlocks.a();
      i6 = 0;
    }
    int i15;
    for (int i7 = 0; ; i7 = i15)
    {
      if (i6 >= i5)
        break label304;
      i15 = i7;
      int i16 = 0;
      while (true)
        if (i16 < i1)
        {
          byte[] arrayOfByte3 = arrayOfDataBlock[i16].b;
          int i17 = i15 + 1;
          arrayOfByte3[i6] = paramArrayOfByte[i15];
          i16++;
          i15 = i17;
          continue;
          i3--;
          break;
        }
      i6++;
    }
    label304: int i8 = i4;
    while (i8 < i1)
    {
      byte[] arrayOfByte2 = arrayOfDataBlock[i8].b;
      int i14 = i7 + 1;
      arrayOfByte2[i5] = paramArrayOfByte[i7];
      i8++;
      i7 = i14;
    }
    int i9 = arrayOfDataBlock[0].b.length;
    while (i5 < i9)
    {
      int i10 = 0;
      int i11 = i7;
      if (i10 < i1)
      {
        if (i10 < i4);
        for (int i12 = i5; ; i12 = i5 + 1)
        {
          byte[] arrayOfByte1 = arrayOfDataBlock[i10].b;
          int i13 = i11 + 1;
          arrayOfByte1[i12] = paramArrayOfByte[i11];
          i10++;
          i11 = i13;
          break;
        }
      }
      i5++;
      i7 = i11;
    }
    return arrayOfDataBlock;
  }

  int a()
  {
    return this.a;
  }

  byte[] b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.DataBlock
 * JD-Core Version:    0.6.0
 */