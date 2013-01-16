package com.facebook.timeline.util;

import android.graphics.Matrix;

public class PhotoUtil
{
  public static Matrix a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2)
  {
    float f3;
    float f4;
    float f2;
    if (paramInt3 / paramInt4 > paramInt1 / paramInt2)
    {
      float f5 = paramInt2 / paramInt4;
      float f6 = Math.min(Math.max((float)(paramDouble1 * (f5 * paramInt3) - 0.5F * paramInt1), 0.0F), f5 * paramInt3 - paramInt1);
      f3 = f5;
      f4 = f6;
      f2 = 0.0F;
    }
    while (true)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      localMatrix.postScale(f3, f3, 0.0F, 0.0F);
      localMatrix.postTranslate(-f4, -f2);
      return localMatrix;
      float f1 = paramInt1 / paramInt3;
      f2 = Math.min(Math.max((float)(paramDouble2 * (f1 * paramInt4) - 0.5F * paramInt2), 0.0F), f1 * paramInt4 - paramInt2);
      f3 = f1;
      f4 = 0.0F;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.util.PhotoUtil
 * JD-Core Version:    0.6.0
 */