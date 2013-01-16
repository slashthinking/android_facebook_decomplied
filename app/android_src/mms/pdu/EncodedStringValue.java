package android_src.mms.pdu;

import com.facebook.orca.debug.BLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class EncodedStringValue
  implements Cloneable
{
  private int a;
  private byte[] b;

  public EncodedStringValue(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("EncodedStringValue: Text-string is null.");
    this.a = paramInt;
    this.b = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.b, 0, paramArrayOfByte.length);
  }

  public EncodedStringValue(String paramString)
  {
    try
    {
      this.b = paramString.getBytes("utf-8");
      this.a = 106;
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        BLog.d("EncodedStringValue", "Default encoding must be supported.", localUnsupportedEncodingException);
    }
  }

  public EncodedStringValue(byte[] paramArrayOfByte)
  {
    this(106, paramArrayOfByte);
  }

  public static EncodedStringValue a(EncodedStringValue paramEncodedStringValue)
  {
    if (paramEncodedStringValue == null);
    for (EncodedStringValue localEncodedStringValue = null; ; localEncodedStringValue = new EncodedStringValue(paramEncodedStringValue.a, paramEncodedStringValue.b))
      return localEncodedStringValue;
  }

  public static EncodedStringValue[] a(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    if (i > 0)
    {
      arrayOfEncodedStringValue = new EncodedStringValue[i];
      for (int j = 0; j < i; j++)
        arrayOfEncodedStringValue[j] = new EncodedStringValue(paramArrayOfString[j]);
    }
    EncodedStringValue[] arrayOfEncodedStringValue = null;
    return arrayOfEncodedStringValue;
  }

  public int a()
  {
    return this.a;
  }

  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("EncodedStringValue: Text-string is null.");
    this.b = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.b, 0, paramArrayOfByte.length);
  }

  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("Text-string is null.");
    if (this.b == null)
    {
      this.b = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.b, 0, paramArrayOfByte.length);
    }
    while (true)
    {
      return;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        localByteArrayOutputStream.write(this.b);
        localByteArrayOutputStream.write(paramArrayOfByte);
        this.b = localByteArrayOutputStream.toByteArray();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    throw new NullPointerException("appendTextString: failed when write a new Text-string");
  }

  public byte[] b()
  {
    byte[] arrayOfByte = new byte[this.b.length];
    System.arraycopy(this.b, 0, arrayOfByte, 0, this.b.length);
    return arrayOfByte;
  }

  public String c()
  {
    String str1;
    if (this.a == 0)
      str1 = new String(this.b);
    while (true)
    {
      return str1;
      try
      {
        String str2 = CharacterSets.a(this.a);
        str1 = new String(this.b, str2);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        try
        {
          str1 = new String(this.b, "iso-8859-1");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          str1 = new String(this.b);
        }
      }
    }
  }

  public Object clone()
  {
    super.clone();
    int i = this.b.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.b, 0, arrayOfByte, 0, i);
    try
    {
      EncodedStringValue localEncodedStringValue = new EncodedStringValue(this.a, arrayOfByte);
      return localEncodedStringValue;
    }
    catch (Exception localException)
    {
      BLog.e("EncodedStringValue", "failed to clone an EncodedStringValue: " + this);
      localException.printStackTrace();
    }
    throw new CloneNotSupportedException(localException.getMessage());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.EncodedStringValue
 * JD-Core Version:    0.6.0
 */