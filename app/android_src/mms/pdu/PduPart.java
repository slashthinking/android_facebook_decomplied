package android_src.mms.pdu;

import android.net.Uri;
import java.util.Map;

public class PduPart
{
  static final byte[] a = "from-data".getBytes();
  static final byte[] b = "attachment".getBytes();
  static final byte[] c = "inline".getBytes();
  private Map<Integer, Object> d = null;
  private Uri e = null;
  private byte[] f = null;

  public void a(int paramInt)
  {
    this.d.put(Integer.valueOf(129), Integer.valueOf(paramInt));
  }

  public void a(Uri paramUri)
  {
    this.e = paramUri;
  }

  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null);
    while (true)
    {
      return;
      this.f = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.f, 0, paramArrayOfByte.length);
    }
  }

  public byte[] a()
  {
    byte[] arrayOfByte;
    if (this.f == null)
      arrayOfByte = null;
    while (true)
    {
      return arrayOfByte;
      arrayOfByte = new byte[this.f.length];
      System.arraycopy(this.f, 0, arrayOfByte, 0, this.f.length);
    }
  }

  public Uri b()
  {
    return this.e;
  }

  public void b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      throw new IllegalArgumentException("Content-Id may not be null or empty.");
    if ((paramArrayOfByte.length > 1) && ((char)paramArrayOfByte[0] == '<') && ((char)paramArrayOfByte[(-1 + paramArrayOfByte.length)] == '>'))
      this.d.put(Integer.valueOf(192), paramArrayOfByte);
    while (true)
    {
      return;
      byte[] arrayOfByte = new byte[2 + paramArrayOfByte.length];
      arrayOfByte[0] = 60;
      arrayOfByte[(-1 + arrayOfByte.length)] = 62;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 1, paramArrayOfByte.length);
      this.d.put(Integer.valueOf(192), arrayOfByte);
    }
  }

  public void c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("null content-location");
    this.d.put(Integer.valueOf(142), paramArrayOfByte);
  }

  public byte[] c()
  {
    return (byte[])(byte[])this.d.get(Integer.valueOf(192));
  }

  public int d()
  {
    Integer localInteger = (Integer)this.d.get(Integer.valueOf(129));
    if (localInteger == null);
    for (int i = 0; ; i = localInteger.intValue())
      return i;
  }

  public void d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("null content-disposition");
    this.d.put(Integer.valueOf(197), paramArrayOfByte);
  }

  public void e(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("null content-type");
    this.d.put(Integer.valueOf(145), paramArrayOfByte);
  }

  public byte[] e()
  {
    return (byte[])(byte[])this.d.get(Integer.valueOf(142));
  }

  public void f(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("null content-transfer-encoding");
    this.d.put(Integer.valueOf(200), paramArrayOfByte);
  }

  public byte[] f()
  {
    return (byte[])(byte[])this.d.get(Integer.valueOf(197));
  }

  public void g(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("null content-id");
    this.d.put(Integer.valueOf(151), paramArrayOfByte);
  }

  public byte[] g()
  {
    return (byte[])(byte[])this.d.get(Integer.valueOf(145));
  }

  public void h(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("null content-id");
    this.d.put(Integer.valueOf(152), paramArrayOfByte);
  }

  public byte[] h()
  {
    return (byte[])(byte[])this.d.get(Integer.valueOf(200));
  }

  public byte[] i()
  {
    return (byte[])(byte[])this.d.get(Integer.valueOf(151));
  }

  public byte[] j()
  {
    return (byte[])(byte[])this.d.get(Integer.valueOf(152));
  }

  public String k()
  {
    byte[] arrayOfByte1 = (byte[])(byte[])this.d.get(Integer.valueOf(151));
    if (arrayOfByte1 == null)
    {
      arrayOfByte1 = (byte[])(byte[])this.d.get(Integer.valueOf(152));
      if (arrayOfByte1 != null);
    }
    for (byte[] arrayOfByte2 = (byte[])(byte[])this.d.get(Integer.valueOf(142)); ; arrayOfByte2 = arrayOfByte1)
    {
      byte[] arrayOfByte3;
      if (arrayOfByte2 == null)
        arrayOfByte3 = (byte[])(byte[])this.d.get(Integer.valueOf(192));
      for (String str = "cid:" + new String(arrayOfByte3); ; str = new String(arrayOfByte2))
        return str;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.PduPart
 * JD-Core Version:    0.6.0
 */