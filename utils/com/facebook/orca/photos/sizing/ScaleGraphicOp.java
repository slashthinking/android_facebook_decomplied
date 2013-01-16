package com.facebook.orca.photos.sizing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

public class ScaleGraphicOp
  implements GraphicOp
{
  private final int a;
  private final int b;

  public ScaleGraphicOp(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }

  private float a(int paramInt1, int paramInt2)
  {
    float f = -1.0F;
    if (paramInt1 > paramInt2)
      if (paramInt1 > this.b)
        f = this.b / paramInt1;
    while (true)
    {
      return f;
      if (paramInt2 > this.a)
        f = this.a / paramInt2;
    }
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = a(i, j);
    if (f != -1.0F)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f, f);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    }
    return paramBitmap;
  }

  public void a(Rect paramRect)
  {
    int i = paramRect.width();
    int j = paramRect.height();
    float f = a(i, j);
    if (f != -1.0F)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f, f);
      RectF localRectF = new RectF();
      localMatrix.mapRect(localRectF, new RectF(0.0F, 0.0F, i, j));
      paramRect.set(0, 0, Math.round(localRectF.width()), Math.round(localRectF.height()));
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.ScaleGraphicOp
 * JD-Core Version:    0.6.2
 */