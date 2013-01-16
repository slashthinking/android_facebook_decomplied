package android_src.mms.pdu;

public class Base64
{
  private static byte[] a = new byte['ÿ'];

  static
  {
    for (int i = 0; i < 255; i++)
      a[i] = -1;
    for (int j = 90; j >= 65; j--)
      a[j] = (byte)(j - 65);
    for (int k = 122; k >= 97; k--)
      a[k] = (byte)(26 + (k - 97));
    for (int m = 57; m >= 48; m--)
      a[m] = (byte)(52 + (m - 48));
    a[43] = 62;
    a[47] = 63;
  }

  private static boolean a(byte paramByte)
  {
    int i = 1;
    if (paramByte == 61);
    while (true)
    {
      return i;
      if (a[paramByte] != -1)
        continue;
      i = 0;
    }
  }

  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte1 = b(paramArrayOfByte);
    if (arrayOfByte1.length == 0);
    int j;
    int k;
    for (byte[] arrayOfByte2 = new byte[0]; ; arrayOfByte2 = new byte[0])
    {
      return arrayOfByte2;
      j = arrayOfByte1.length / 4;
      k = arrayOfByte1.length;
      do
      {
        if (arrayOfByte1[(k - 1)] != 61)
          break;
        k--;
      }
      while (k != 0);
    }
    arrayOfByte2 = new byte[k - j];
    int m = 0;
    label65: int i1;
    int i2;
    int i3;
    int i4;
    if (i < j)
    {
      int n = i * 4;
      i1 = arrayOfByte1[(n + 2)];
      i2 = arrayOfByte1[(n + 3)];
      i3 = a[arrayOfByte1[n]];
      i4 = a[arrayOfByte1[(n + 1)]];
      if ((i1 == 61) || (i2 == 61))
        break label204;
      int i6 = a[i1];
      int i7 = a[i2];
      arrayOfByte2[m] = (byte)(i3 << 2 | i4 >> 4);
      arrayOfByte2[(m + 1)] = (byte)((i4 & 0xF) << 4 | 0xF & i6 >> 2);
      arrayOfByte2[(m + 2)] = (byte)(i7 | i6 << 6);
    }
    while (true)
    {
      m += 3;
      i++;
      break label65;
      break;
      label204: if (i1 == 61)
      {
        arrayOfByte2[m] = (byte)(i3 << 2 | i4 >> 4);
        continue;
      }
      if (i2 != 61)
        continue;
      int i5 = a[i1];
      arrayOfByte2[m] = (byte)(i3 << 2 | i4 >> 4);
      arrayOfByte2[(m + 1)] = (byte)((i4 & 0xF) << 4 | 0xF & i5 >> 2);
    }
  }

  static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      if (a(paramArrayOfByte[i]))
      {
        int k = j + 1;
        arrayOfByte1[j] = paramArrayOfByte[i];
        j = k;
      }
      i++;
    }
    byte[] arrayOfByte2 = new byte[j];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
    return arrayOfByte2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.Base64
 * JD-Core Version:    0.6.0
 */