package com.google.zxing;

public abstract class LuminanceSource
{
  private final int a;
  private final int b;

  protected LuminanceSource(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public abstract byte[] a();

  public abstract byte[] a(int paramInt, byte[] paramArrayOfByte);

  public final int b()
  {
    return this.a;
  }

  public final int c()
  {
    return this.b;
  }

  public final String toString()
  {
    byte[] arrayOfByte1 = new byte[this.a];
    StringBuilder localStringBuilder = new StringBuilder(this.b * (1 + this.a));
    byte[] arrayOfByte2 = arrayOfByte1;
    for (int i = 0; i < this.b; i++)
    {
      arrayOfByte2 = a(i, arrayOfByte2);
      int j = 0;
      if (j < this.a)
      {
        int k = 0xFF & arrayOfByte2[j];
        char c;
        if (k < 64)
          c = '#';
        while (true)
        {
          localStringBuilder.append(c);
          j++;
          break;
          if (k < 128)
          {
            c = '+';
            continue;
          }
          if (k < 192)
          {
            c = '.';
            continue;
          }
          c = ' ';
        }
      }
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.LuminanceSource
 * JD-Core Version:    0.6.0
 */