package com.facebook.orca.entity.mime;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class OutputStreamWithProgressListener extends FilterOutputStream
{
  private final ContentSerializationListener a;
  private long b = 0L;

  OutputStreamWithProgressListener(OutputStream paramOutputStream, ContentSerializationListener paramContentSerializationListener)
  {
    super(paramOutputStream);
    this.a = paramContentSerializationListener;
  }

  private void a(int paramInt)
  {
    this.b += paramInt;
    if (this.a != null)
      this.a.a(this.b);
  }

  public void write(int paramInt)
  {
    this.out.write(paramInt);
    a(1);
  }

  public void write(byte[] paramArrayOfByte)
  {
    this.out.write(paramArrayOfByte);
    a(paramArrayOfByte.length);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    a(paramInt2);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.entity.mime.OutputStreamWithProgressListener
 * JD-Core Version:    0.6.2
 */