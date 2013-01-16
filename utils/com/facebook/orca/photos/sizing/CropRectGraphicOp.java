package com.facebook.orca.photos.sizing;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class CropRectGraphicOp
  implements GraphicOp
{
  private final RectF a;
  private final float b;

  public CropRectGraphicOp(RectF paramRectF, float paramFloat)
  {
    this.a = paramRectF;
    this.b = paramFloat;
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    a(localRect);
    int i = localRect.width();
    int j = localRect.height();
    if ((j <= 0) || (i <= 0))
      return paramBitmap;
    if (paramBitmap.getConfig() != null);
    for (Bitmap.Config localConfig = paramBitmap.getConfig(); ; localConfig = Bitmap.Config.ARGB_8888)
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
      new Canvas(localBitmap).drawBitmap(paramBitmap, localRect, new Rect(0, 0, i, j), null);
      paramBitmap = localBitmap;
      break;
    }
  }

  public void a(Rect paramRect)
  {
    int i = paramRect.width();
    int j = paramRect.height();
    int k = (int)(i * this.a.left);
    int m = (int)(i * this.a.right);
    int n = (int)(j * this.a.top);
    int i1 = (int)(j * this.a.bottom);
    paramRect.set(k, n, m, i1);
    if (this.b != 0.0F)
    {
      if (paramRect.width() / paramRect.height() <= this.b)
        break label193;
      int i5 = (int)(paramRect.width() / this.b);
      int i6 = (i5 - paramRect.height()) / 2;
      paramRect.top = Math.max(0, n - i6);
      paramRect.bottom = Math.min(j, i6 + i1);
      int i7 = i5 - paramRect.height();
      if (i7 > 0)
      {
        paramRect.top = Math.max(0, n - i7);
        paramRect.bottom = Math.min(j, i7 + i1);
      }
    }
    while (true)
    {
      return;
      label193: int i2 = (int)(paramRect.height() * this.b);
      int i3 = (i2 - paramRect.width()) / 2;
      paramRect.left = Math.max(0, k - i3);
      paramRect.right = Math.min(i, i3 + m);
      int i4 = i2 - paramRect.width();
      if (i4 > 0)
      {
        paramRect.left = Math.max(0, k - i4);
        paramRect.right = Math.min(i, i4 + m);
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.CropRectGraphicOp
 * JD-Core Version:    0.6.2
 */