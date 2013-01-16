package com.facebook.katana.activity.media.crop;

import android.graphics.RectF;

class Corner extends Touchable
{
  public Corner(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public RectF a(float[][] paramArrayOfFloat)
  {
    int i = 2;
    float[][] arrayOfFloat = new float[i][];
    float[] arrayOfFloat1 = new float[i];
    float f1 = paramArrayOfFloat[0][this.a[0]];
    int j;
    int k;
    label74: float[] arrayOfFloat2;
    float f3;
    if (this.a[0] == 0)
    {
      j = 1;
      arrayOfFloat1[0] = (f1 - j * 60);
      float f2 = paramArrayOfFloat[0][this.a[0]];
      if (this.a[0] != 1)
        break label187;
      k = 1;
      arrayOfFloat1[1] = (f2 + k * 60);
      arrayOfFloat[0] = arrayOfFloat1;
      arrayOfFloat2 = new float[i];
      f3 = paramArrayOfFloat[1][this.a[1]];
      if (this.a[1] != 0)
        break label193;
    }
    label187: label193: for (int m = 1; ; m = i)
    {
      arrayOfFloat2[0] = (f3 - m * 60);
      float f4 = paramArrayOfFloat[1][this.a[1]];
      if (this.a[1] == 1)
        i = 1;
      arrayOfFloat2[1] = (f4 + i * 60);
      arrayOfFloat[1] = arrayOfFloat2;
      return b(arrayOfFloat);
      j = i;
      break;
      k = i;
      break label74;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.Corner
 * JD-Core Version:    0.6.0
 */