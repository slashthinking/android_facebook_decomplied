package com.facebook.orca.common.util;

public class Hex
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] b = new char[256];
  private static final char[] c = new char[256];
  private static final byte[] d;

  static
  {
    for (int i = 0; i < 256; i++)
    {
      b[i] = a[(0xF & i >> 4)];
      c[i] = a[(i & 0xF)];
    }
    d = new byte[103];
    for (int j = 0; j <= 70; j++)
      d[j] = -1;
    int m;
    for (int k = 0; ; k = (byte)(k + 1))
    {
      m = 0;
      if (k >= 10)
        break;
      d[(k + 48)] = k;
    }
    while (m < 6)
    {
      d[(m + 65)] = (byte)(m + 10);
      d[(m + 97)] = (byte)(m + 10);
      m = (byte)(m + 1);
    }
  }

  public static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    int i = 0;
    int j = 0;
    while (true)
    {
      int k;
      if (i < paramArrayOfByte.length)
      {
        k = 0xFF & paramArrayOfByte[i];
        if ((k != 0) || (!paramBoolean));
      }
      else
      {
        return new String(arrayOfChar, 0, j);
      }
      int m = j + 1;
      arrayOfChar[j] = b[k];
      j = m + 1;
      arrayOfChar[m] = c[k];
      i++;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.Hex
 * JD-Core Version:    0.6.0
 */