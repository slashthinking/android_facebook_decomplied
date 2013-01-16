package com.google.zxing.common;

import java.util.List;

public final class DecoderResult
{
  private final byte[] a;
  private final String b;
  private final List<byte[]> c;
  private final String d;

  public DecoderResult(byte[] paramArrayOfByte, String paramString1, List<byte[]> paramList, String paramString2)
  {
    this.a = paramArrayOfByte;
    this.b = paramString1;
    this.c = paramList;
    this.d = paramString2;
  }

  public byte[] a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public List<byte[]> c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.DecoderResult
 * JD-Core Version:    0.6.0
 */