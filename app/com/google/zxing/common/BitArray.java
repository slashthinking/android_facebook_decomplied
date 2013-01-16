package com.google.zxing.common;

public final class BitArray
{
  private int[] a = new int[1];
  private int b = 0;

  private void b(int paramInt)
  {
    if (paramInt > this.a.length << 5)
    {
      int[] arrayOfInt = c(paramInt);
      System.arraycopy(this.a, 0, arrayOfInt, 0, this.a.length);
      this.a = arrayOfInt;
    }
  }

  private static int[] c(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }

  public int a()
  {
    return this.b;
  }

  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32))
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    b(paramInt2 + this.b);
    if (paramInt2 > 0)
    {
      if ((0x1 & paramInt1 >> paramInt2 - 1) == 1);
      for (boolean bool = true; ; bool = false)
      {
        a(bool);
        paramInt2--;
        break;
      }
    }
  }

  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    int m;
    for (int j = paramInt1; i < paramInt3; j = m)
    {
      int k = 0;
      m = j;
      int n = 0;
      while (k < 8)
      {
        if (a(m))
          n |= 1 << 7 - k;
        m++;
        k++;
      }
      paramArrayOfByte[(paramInt2 + i)] = (byte)n;
      i++;
    }
  }

  public void a(BitArray paramBitArray)
  {
    int i = paramBitArray.b;
    b(i + this.b);
    for (int j = 0; j < i; j++)
      a(paramBitArray.a(j));
  }

  public void a(boolean paramBoolean)
  {
    b(1 + this.b);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.a;
      int i = this.b >> 5;
      arrayOfInt[i] |= 1 << (0x1F & this.b);
    }
    this.b = (1 + this.b);
  }

  public boolean a(int paramInt)
  {
    int i = 1;
    if ((this.a[(paramInt >> 5)] & i << (paramInt & 0x1F)) != 0);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public int b()
  {
    return 7 + this.b >> 3;
  }

  public void b(BitArray paramBitArray)
  {
    if (this.a.length != paramBitArray.a.length)
      throw new IllegalArgumentException("Sizes don't match");
    for (int i = 0; i < this.a.length; i++)
    {
      int[] arrayOfInt = this.a;
      arrayOfInt[i] ^= paramBitArray.a[i];
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b);
    int i = 0;
    if (i < this.b)
    {
      if ((i & 0x7) == 0)
        localStringBuilder.append(' ');
      if (a(i));
      for (char c = 'X'; ; c = '.')
      {
        localStringBuilder.append(c);
        i++;
        break;
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.BitArray
 * JD-Core Version:    0.6.0
 */