package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class Result
{
  private final String a;
  private final byte[] b;
  private ResultPoint[] c;
  private final BarcodeFormat d;
  private Map<ResultMetadataType, Object> e;
  private final long f;

  public Result(String paramString, byte[] paramArrayOfByte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat)
  {
    this(paramString, paramArrayOfByte, paramArrayOfResultPoint, paramBarcodeFormat, System.currentTimeMillis());
  }

  public Result(String paramString, byte[] paramArrayOfByte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat, long paramLong)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.c = paramArrayOfResultPoint;
    this.d = paramBarcodeFormat;
    this.e = null;
    this.f = paramLong;
  }

  public String a()
  {
    return this.a;
  }

  public void a(ResultMetadataType paramResultMetadataType, Object paramObject)
  {
    if (this.e == null)
      this.e = new EnumMap(ResultMetadataType.class);
    this.e.put(paramResultMetadataType, paramObject);
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.Result
 * JD-Core Version:    0.6.0
 */