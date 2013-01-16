package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler
{
  private static GridSampler a = new DefaultGridSampler();

  public static GridSampler a()
  {
    return a;
  }

  protected static void a(BitMatrix paramBitMatrix, float[] paramArrayOfFloat)
  {
    int i = paramBitMatrix.c();
    int j = paramBitMatrix.d();
    int k = 0;
    int m = 1;
    int i4;
    int i5;
    if ((k < paramArrayOfFloat.length) && (m != 0))
    {
      i4 = (int)paramArrayOfFloat[k];
      i5 = (int)paramArrayOfFloat[(k + 1)];
      if ((i4 < -1) || (i4 > i) || (i5 < -1) || (i5 > j))
        throw NotFoundException.a();
      if (i4 == -1)
      {
        paramArrayOfFloat[k] = 0.0F;
        m = 1;
      }
    }
    while (true)
    {
      label86: if (i5 == -1)
      {
        paramArrayOfFloat[(k + 1)] = 0.0F;
        m = 1;
      }
      while (true)
      {
        k += 2;
        break;
        if (i4 != i)
          break label299;
        paramArrayOfFloat[k] = (i - 1);
        m = 1;
        break label86;
        if (i5 != j)
          continue;
        paramArrayOfFloat[(k + 1)] = (j - 1);
        m = 1;
      }
      int n = -2 + paramArrayOfFloat.length;
      int i1 = 1;
      int i2;
      int i3;
      if ((n >= 0) && (i1 != 0))
      {
        i2 = (int)paramArrayOfFloat[n];
        i3 = (int)paramArrayOfFloat[(n + 1)];
        if ((i2 < -1) || (i2 > i) || (i3 < -1) || (i3 > j))
          throw NotFoundException.a();
        if (i2 == -1)
        {
          paramArrayOfFloat[n] = 0.0F;
          i1 = 1;
        }
      }
      while (true)
      {
        label228: if (i3 == -1)
        {
          paramArrayOfFloat[(n + 1)] = 0.0F;
          i1 = 1;
        }
        while (true)
        {
          n -= 2;
          break;
          if (i2 != i)
            break label293;
          paramArrayOfFloat[n] = (i - 1);
          i1 = 1;
          break label228;
          if (i3 != j)
            continue;
          paramArrayOfFloat[(n + 1)] = (j - 1);
          i1 = 1;
        }
        return;
        label293: i1 = 0;
      }
      label299: m = 0;
    }
  }

  public abstract BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.GridSampler
 * JD-Core Version:    0.6.0
 */