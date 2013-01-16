package com.google.zxing;

import com.google.zxing.common.BitMatrix;

public abstract class Binarizer
{
  private final LuminanceSource a;

  protected Binarizer(LuminanceSource paramLuminanceSource)
  {
    this.a = paramLuminanceSource;
  }

  public final LuminanceSource a()
  {
    return this.a;
  }

  public abstract BitMatrix b();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.Binarizer
 * JD-Core Version:    0.6.0
 */