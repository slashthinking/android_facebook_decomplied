package com.facebook.orca.protocol.base;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class CountingOutputStreamWithProgress extends FilterOutputStream
{
  private final CountingOutputStreamWithProgress.ProgressListener a;
  private long b;

  public CountingOutputStreamWithProgress(OutputStream paramOutputStream, CountingOutputStreamWithProgress.ProgressListener paramProgressListener)
  {
    super(paramOutputStream);
    this.a = paramProgressListener;
    this.b = 0L;
  }

  public void write(int paramInt)
  {
    this.out.write(paramInt);
    this.b = (1L + this.b);
    this.a.a(this.b);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.b += paramInt2;
    this.a.a(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.CountingOutputStreamWithProgress
 * JD-Core Version:    0.6.2
 */