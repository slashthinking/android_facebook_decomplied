package com.facebook.katana.activity.media.crop;

import android.graphics.RectF;

abstract class Touchable
{
  protected int[] a = new int[2];

  public Touchable(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }

  public RectF a(float[][] paramArrayOfFloat)
  {
    return a(paramArrayOfFloat);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.a[0] = paramInt1;
    this.a[1] = paramInt2;
  }

  public boolean a(float paramFloat1, float paramFloat2, float[][] paramArrayOfFloat)
  {
    return a(paramArrayOfFloat).contains(paramFloat1, paramFloat2);
  }

  public RectF b(float[][] paramArrayOfFloat)
  {
    return new RectF(paramArrayOfFloat[0][0], paramArrayOfFloat[1][0], paramArrayOfFloat[0][1], paramArrayOfFloat[1][1]);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.Touchable
 * JD-Core Version:    0.6.0
 */