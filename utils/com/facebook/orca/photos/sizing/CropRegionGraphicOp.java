package com.facebook.orca.photos.sizing;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.google.common.base.Preconditions;

public class CropRegionGraphicOp
  implements GraphicOp
{
  private final float a;
  private final float b;
  private final float c;
  private final CropRegionGraphicOp.CropType d;
  private final int e;
  private final int f;

  public CropRegionGraphicOp(float paramFloat1, float paramFloat2, float paramFloat3, CropRegionGraphicOp.CropType paramCropType, int paramInt1, int paramInt2)
  {
    boolean bool2;
    if ((paramFloat2 >= 0.0F) && (paramFloat2 <= 1.0F))
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if ((paramFloat3 < 0.0F) || (paramFloat3 > 1.0F))
        break label91;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      Preconditions.checkNotNull(paramCropType);
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramCropType;
      this.e = paramInt1;
      this.f = paramInt2;
      return;
      bool2 = false;
      break;
      label91: bool1 = false;
    }
  }

  private Rect a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j;
    int k;
    int m;
    if (i > paramInt1)
      if (this.d == CropRegionGraphicOp.CropType.CENTER)
      {
        j = (i - paramInt1) / 2;
        paramInt1 += j;
        k = paramBitmap.getHeight();
        if (k <= paramInt2)
          break label158;
        if (this.d != CropRegionGraphicOp.CropType.CENTER)
          break label125;
        m = (k - paramInt2) / 2;
        paramInt2 += m;
      }
    while (true)
    {
      return new Rect(j, m, paramInt1, paramInt2);
      if (this.d == CropRegionGraphicOp.CropType.TOP_OR_LEFT)
      {
        j = 0;
        break;
      }
      int n = i - paramInt1;
      paramInt1 = i;
      j = n;
      break;
      paramInt1 = i;
      j = 0;
      break;
      label125: CropRegionGraphicOp.CropType localCropType1 = this.d;
      CropRegionGraphicOp.CropType localCropType2 = CropRegionGraphicOp.CropType.TOP_OR_LEFT;
      m = 0;
      if (localCropType1 != localCropType2)
      {
        m = k - paramInt2;
        paramInt2 = k;
        continue;
        label158: paramInt2 = k;
        m = 0;
      }
    }
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    a(localRect);
    if (paramBitmap.getConfig() != null);
    for (Bitmap.Config localConfig = paramBitmap.getConfig(); ; localConfig = Bitmap.Config.ARGB_8888)
    {
      Bitmap localBitmap = Bitmap.createBitmap(localRect.width(), localRect.height(), localConfig);
      new Canvas(localBitmap).drawBitmap(paramBitmap, a(paramBitmap, localRect.width(), localRect.height()), localRect, null);
      return localBitmap;
    }
  }

  public void a(Rect paramRect)
  {
    int i = paramRect.width();
    int j = paramRect.height();
    if (i / j > this.a)
      if (i > this.e);
    while (true)
    {
      return;
      int n = (int)(j * this.a);
      int i1 = (int)((1.0F - this.b) * i);
      paramRect.set(0, 0, Math.max(this.e, Math.max(n, i1)), j);
      continue;
      if (j >= this.f)
      {
        int k = (int)(i / this.a);
        int m = (int)((1.0F - this.c) * j);
        paramRect.set(0, 0, i, Math.max(this.f, Math.max(k, m)));
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.CropRegionGraphicOp
 * JD-Core Version:    0.6.2
 */