package com.google.common.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class CountingInputStream extends FilterInputStream
{
  private long a;
  private long b = -1L;

  public CountingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public long a()
  {
    return this.a;
  }

  public void mark(int paramInt)
  {
    this.in.mark(paramInt);
    this.b = this.a;
  }

  public int read()
  {
    int i = this.in.read();
    if (i != -1)
      this.a = (1L + this.a);
    return i;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1)
      this.a += i;
    return i;
  }

  public void reset()
  {
    if (!this.in.markSupported())
      throw new IOException("Mark not supported");
    if (this.b == -1L)
      throw new IOException("Mark not set");
    this.in.reset();
    this.a = this.b;
  }

  public long skip(long paramLong)
  {
    long l = this.in.skip(paramLong);
    this.a = (l + this.a);
    return l;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.io.CountingInputStream
 * JD-Core Version:    0.6.2
 */