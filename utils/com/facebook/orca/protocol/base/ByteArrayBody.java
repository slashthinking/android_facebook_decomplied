package com.facebook.orca.protocol.base;

import java.io.OutputStream;

public class ByteArrayBody extends ContentBody
{
  private byte[] a;

  public ByteArrayBody(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    super(paramString1, paramArrayOfByte.length, paramString2);
    this.a = paramArrayOfByte;
  }

  public void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("Output stream may not be null");
    paramOutputStream.write(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ByteArrayBody
 * JD-Core Version:    0.6.2
 */