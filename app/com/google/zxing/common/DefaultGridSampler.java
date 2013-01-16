package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public final class DefaultGridSampler extends GridSampler
{
  public BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      throw NotFoundException.a();
    BitMatrix localBitMatrix = new BitMatrix(paramInt1, paramInt2);
    float[] arrayOfFloat = new float[paramInt1 << 1];
    for (int i = 0; i < paramInt2; i++)
    {
      int j = arrayOfFloat.length;
      float f = 0.5F + i;
      for (int k = 0; k < j; k += 2)
      {
        arrayOfFloat[k] = (0.5F + (k >> 1));
        arrayOfFloat[(k + 1)] = f;
      }
      paramPerspectiveTransform.a(arrayOfFloat);
      a(paramBitMatrix, arrayOfFloat);
      int m = 0;
      while (m < j)
        try
        {
          if (paramBitMatrix.a((int)arrayOfFloat[m], (int)arrayOfFloat[(m + 1)]))
            localBitMatrix.b(m >> 1, i);
          m += 2;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          throw NotFoundException.a();
        }
    }
    return localBitMatrix;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.DefaultGridSampler
 * JD-Core Version:    0.6.0
 */