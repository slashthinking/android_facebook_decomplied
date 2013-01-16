package com.facebook.katana.activity.media.crop;

import [F;
import android.graphics.RectF;

class Edge extends Touchable
{
  public Edge(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public RectF a(float[][] paramArrayOfFloat)
  {
    float[][] arrayOfFloat = new float[2][];
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = (paramArrayOfFloat[0][0] - 60.0F);
    arrayOfFloat1[1] = (60.0F + paramArrayOfFloat[0][1]);
    arrayOfFloat[0] = arrayOfFloat1;
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = (paramArrayOfFloat[1][0] - 60.0F);
    arrayOfFloat2[1] = (60.0F + paramArrayOfFloat[1][1]);
    arrayOfFloat[1] = arrayOfFloat2;
    if (this.a[0] == -1)
    {
      [F local[F2 = arrayOfFloat[1];
      int j = 1 - this.a[1];
      float f2;
      if (this.a[1] == 0)
        f2 = 60.0F + paramArrayOfFloat[1][0];
      while (true)
      {
        local[F2[j] = f2;
        return b(arrayOfFloat);
        f2 = paramArrayOfFloat[1][1] - 60.0F;
      }
    }
    [F local[F1 = arrayOfFloat[0];
    int i = 1 - this.a[0];
    float f1;
    if (this.a[0] == 0)
      f1 = 60.0F + paramArrayOfFloat[0][0];
    while (true)
    {
      local[F1[i] = f1;
      break;
      f1 = paramArrayOfFloat[0][1] - 60.0F;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.Edge
 * JD-Core Version:    0.6.0
 */