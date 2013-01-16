package org.acra.util;

class Base64$Decoder extends Base64.Coder
{
  private static final int[] DECODE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] DECODE_WEBSAFE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int EQUALS = -2;
  private static final int SKIP = -1;
  private final int[] alphabet;
  private int state;
  private int value;

  public Base64$Decoder(int paramInt, byte[] paramArrayOfByte)
  {
    this.output = paramArrayOfByte;
    if ((paramInt & 0x8) == 0);
    for (int[] arrayOfInt = DECODE; ; arrayOfInt = DECODE_WEBSAFE)
    {
      this.alphabet = arrayOfInt;
      this.state = 0;
      this.value = 0;
      return;
    }
  }

  public int maxOutputSize(int paramInt)
  {
    return 10 + paramInt * 3 / 4;
  }

  public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2;
    if (this.state == 6)
    {
      i2 = 0;
      return i2;
    }
    int i = paramInt2 + paramInt1;
    int j = this.state;
    int k = this.value;
    int m = 0;
    byte[] arrayOfByte = this.output;
    int[] arrayOfInt = this.alphabet;
    int n = paramInt1;
    label50: if (n < i)
      if (j == 0)
      {
        while (n + 4 <= i)
        {
          k = arrayOfInt[(0xFF & paramArrayOfByte[n])] << 18 | arrayOfInt[(0xFF & paramArrayOfByte[(n + 1)])] << 12 | arrayOfInt[(0xFF & paramArrayOfByte[(n + 2)])] << 6 | arrayOfInt[(0xFF & paramArrayOfByte[(n + 3)])];
          if (k < 0)
            break;
          arrayOfByte[(m + 2)] = (byte)k;
          arrayOfByte[(m + 1)] = (byte)(k >> 8);
          arrayOfByte[m] = (byte)(k >> 16);
          m += 3;
          n += 4;
        }
        if (n < i);
      }
    for (int i1 = k; ; i1 = k)
    {
      if (!paramBoolean)
      {
        this.state = j;
        this.value = i1;
        this.op = m;
        i2 = 1;
        break;
        int i5 = n + 1;
        int i6 = arrayOfInt[(0xFF & paramArrayOfByte[n])];
        switch (j)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        label284: label583: 
        do
        {
          do
          {
            int i7 = j;
            while (true)
            {
              j = i7;
              n = i5;
              break label50;
              if (i6 >= 0)
              {
                i7 = j + 1;
                k = i6;
                continue;
              }
              if (i6 == -1)
                break label284;
              this.state = 6;
              i2 = 0;
              break;
              if (i6 >= 0)
              {
                k = i6 | k << 6;
                i7 = j + 1;
                continue;
              }
              if (i6 == -1)
                break label284;
              this.state = 6;
              i2 = 0;
              break;
              if (i6 >= 0)
              {
                k = i6 | k << 6;
                i7 = j + 1;
                continue;
              }
              if (i6 == -2)
              {
                int i8 = m + 1;
                arrayOfByte[m] = (byte)(k >> 4);
                i7 = 4;
                m = i8;
                continue;
              }
              if (i6 == -1)
                break label284;
              this.state = 6;
              i2 = 0;
              break;
              if (i6 >= 0)
              {
                k = i6 | k << 6;
                arrayOfByte[(m + 2)] = (byte)k;
                arrayOfByte[(m + 1)] = (byte)(k >> 8);
                arrayOfByte[m] = (byte)(k >> 16);
                m += 3;
                i7 = 0;
                continue;
              }
              if (i6 == -2)
              {
                arrayOfByte[(m + 1)] = (byte)(k >> 2);
                arrayOfByte[m] = (byte)(k >> 10);
                m += 2;
                i7 = 5;
                continue;
              }
              if (i6 == -1)
                break label284;
              this.state = 6;
              i2 = 0;
              break;
              if (i6 != -2)
                break label583;
              i7 = j + 1;
            }
          }
          while (i6 == -1);
          this.state = 6;
          i2 = 0;
          break;
        }
        while (i6 == -1);
        this.state = 6;
        i2 = 0;
        break;
      }
      switch (j)
      {
      case 0:
      default:
      case 1:
      case 2:
      case 3:
        while (true)
        {
          this.state = j;
          this.op = m;
          i2 = 1;
          break;
          this.state = 6;
          i2 = 0;
          break;
          int i4 = m + 1;
          arrayOfByte[m] = (byte)(i1 >> 4);
          m = i4;
          continue;
          int i3 = m + 1;
          arrayOfByte[m] = (byte)(i1 >> 10);
          m = i3 + 1;
          arrayOfByte[i3] = (byte)(i1 >> 2);
        }
      case 4:
      }
      this.state = 6;
      i2 = 0;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.Base64.Decoder
 * JD-Core Version:    0.6.0
 */