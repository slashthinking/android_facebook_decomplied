package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class AlignmentPattern extends ResultPoint
{
  private final float a;

  AlignmentPattern(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
  }

  boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool1 = Math.abs(paramFloat2 - b()) < paramFloat1;
    int i = 0;
    if (!bool1)
    {
      boolean bool2 = Math.abs(paramFloat3 - a()) < paramFloat1;
      i = 0;
      if (!bool2)
      {
        float f = Math.abs(paramFloat1 - this.a);
        if (f > 1.0F)
        {
          boolean bool3 = f < this.a;
          i = 0;
          if (bool3);
        }
        else
        {
          i = 1;
        }
      }
    }
    return i;
  }

  AlignmentPattern b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new AlignmentPattern((paramFloat2 + a()) / 2.0F, (paramFloat1 + b()) / 2.0F, (paramFloat3 + this.a) / 2.0F);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.AlignmentPattern
 * JD-Core Version:    0.6.0
 */