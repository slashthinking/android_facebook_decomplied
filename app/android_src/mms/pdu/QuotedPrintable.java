package android_src.mms.pdu;

import java.io.ByteArrayOutputStream;

public class QuotedPrintable
{
  private static byte a = 61;

  public static final byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if (paramArrayOfByte == null)
      arrayOfByte = null;
    while (true)
    {
      return arrayOfByte;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (int i = 0; ; i++)
        if (i < paramArrayOfByte.length)
        {
          int j = paramArrayOfByte[i];
          if (j == a)
          {
            int k = i + 1;
            try
            {
              if (('\r' == (char)paramArrayOfByte[k]) && ('\n' == (char)paramArrayOfByte[(i + 2)]))
              {
                i += 2;
                continue;
              }
              int m = i + 1;
              int n = Character.digit((char)paramArrayOfByte[m], 16);
              i = m + 1;
              int i1 = Character.digit((char)paramArrayOfByte[i], 16);
              if ((n == -1) || (i1 == -1))
                break label162;
              localByteArrayOutputStream.write((char)(i1 + (n << 4)));
            }
            catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
            {
              arrayOfByte = null;
            }
            break;
          }
          else
          {
            localByteArrayOutputStream.write(j);
          }
        }
        else
        {
          arrayOfByte = localByteArrayOutputStream.toByteArray();
          break;
        }
      label162: arrayOfByte = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.QuotedPrintable
 * JD-Core Version:    0.6.0
 */