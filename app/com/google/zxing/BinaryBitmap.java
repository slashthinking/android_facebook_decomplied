package com.google.zxing;

import com.google.zxing.common.BitMatrix;

public final class BinaryBitmap
{
  private final Binarizer a;
  private BitMatrix b;

  public BinaryBitmap(Binarizer paramBinarizer)
  {
    if (paramBinarizer == null)
      throw new IllegalArgumentException("Binarizer must be non-null.");
    this.a = paramBinarizer;
  }

  public BitMatrix a()
  {
    if (this.b == null)
      this.b = this.a.b();
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.BinaryBitmap
 * JD-Core Version:    0.6.0
 */