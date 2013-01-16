package com.google.common.io;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class CountingOutputStream extends FilterOutputStream
{
  private long a;

  public CountingOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public long a()
  {
    return this.a;
  }

  public void write(int paramInt)
  {
    this.out.write(paramInt);
    this.a = (1L + this.a);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.a += paramInt2;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.io.CountingOutputStream
 * JD-Core Version:    0.6.2
 */