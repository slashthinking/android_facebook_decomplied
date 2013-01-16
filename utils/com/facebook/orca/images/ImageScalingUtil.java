package com.facebook.orca.images;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class ImageScalingUtil
{
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f;
    if (i > j)
    {
      if (i <= paramInt)
        break label88;
      f = paramInt / i;
    }
    while (true)
    {
      if (f != -1.0F)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f, f);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      }
      return paramBitmap;
      if (j > paramInt)
        f = paramInt / j;
      else
        label88: f = -1.0F;
    }
  }

  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i > paramInt1);
    for (float f1 = paramInt1 / i; ; f1 = -1.0F)
    {
      if (j > paramInt2);
      for (float f2 = paramInt2 / j; ; f2 = -1.0F)
      {
        if ((f1 == -1.0F) && (f2 == -1.0F));
        while (true)
        {
          return paramBitmap;
          float f3 = Math.max(f1, f2);
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(f3, f3);
          paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        }
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageScalingUtil
 * JD-Core Version:    0.6.2
 */