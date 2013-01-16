package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix
{
  private final byte[][] a;
  private final int b;
  private final int c;

  public ByteMatrix(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = { paramInt2, paramInt1 };
    this.a = ((byte[][])Array.newInstance(Byte.TYPE, arrayOfInt));
    this.b = paramInt1;
    this.c = paramInt2;
  }

  public byte a(int paramInt1, int paramInt2)
  {
    return this.a[paramInt2][paramInt1];
  }

  public int a()
  {
    return this.c;
  }

  public void a(byte paramByte)
  {
    for (int i = 0; i < this.c; i++)
      for (int j = 0; j < this.b; j++)
        this.a[i][j] = paramByte;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a[paramInt2][paramInt1] = (byte)paramInt3;
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.a[paramInt2];
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      arrayOfByte[paramInt1] = (byte)i;
      return;
    }
  }

  public int b()
  {
    return this.b;
  }

  public byte[][] c()
  {
    return this.a;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(2 + 2 * this.b * this.c);
    for (int i = 0; i < this.c; i++)
    {
      int j = 0;
      if (j < this.b)
      {
        switch (this.a[i][j])
        {
        default:
          localStringBuilder.append("  ");
        case 0:
        case 1:
        }
        while (true)
        {
          j++;
          break;
          localStringBuilder.append(" 0");
          continue;
          localStringBuilder.append(" 1");
        }
      }
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.ByteMatrix
 * JD-Core Version:    0.6.0
 */