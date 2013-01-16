package com.facebook.apache.http.entity.mime;

import java.io.OutputStream;

class HttpMultipart$ByteCountingOutputStream extends OutputStream
{
  int a = 0;

  public void write(int paramInt)
  {
    this.a = (1 + this.a);
  }

  public void write(byte[] paramArrayOfByte)
  {
    this.a += paramArrayOfByte.length;
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = (paramInt2 + this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.HttpMultipart.ByteCountingOutputStream
 * JD-Core Version:    0.6.2
 */