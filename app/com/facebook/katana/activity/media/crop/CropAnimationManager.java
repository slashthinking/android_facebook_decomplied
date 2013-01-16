package com.facebook.katana.activity.media.crop;

import android.graphics.RectF;
import android.os.Handler;

public class CropAnimationManager
{
  private final CropImageView a;
  private final CropRectView b;
  private final CropState c;
  private boolean d = false;

  public CropAnimationManager(CropImageView paramCropImageView, CropRectView paramCropRectView, CropState paramCropState)
  {
    this.a = paramCropImageView;
    this.b = paramCropRectView;
    this.c = paramCropState;
  }

  private RectF a(RectF paramRectF1, RectF paramRectF2, int paramInt1, int paramInt2)
  {
    RectF localRectF = new RectF();
    localRectF.bottom = ((paramRectF1.bottom * (paramInt2 - paramInt1) + paramRectF2.bottom * paramInt1) / paramInt2);
    localRectF.top = ((paramRectF1.top * (paramInt2 - paramInt1) + paramRectF2.top * paramInt1) / paramInt2);
    localRectF.left = ((paramRectF1.left * (paramInt2 - paramInt1) + paramRectF2.left * paramInt1) / paramInt2);
    localRectF.right = ((paramRectF1.right * (paramInt2 - paramInt1) + paramRectF2.right * paramInt1) / paramInt2);
    return localRectF;
  }

  private RectF b(RectF paramRectF)
  {
    int i = this.a.getViewWidth();
    int j = this.a.getViewHeight();
    float f1 = paramRectF.width();
    float f2 = paramRectF.height();
    float f3 = Math.min(Math.min(0.9F * i / f1, 10.0F), Math.min(0.9F * j / f2, 10.0F));
    int k = (int)(0.1F * i / 2.0F + (0.9F * i - f1 * f3) / 2.0F);
    int m = (int)(0.1F * j / 2.0F + (0.9F * j - f2 * f3) / 2.0F);
    return new RectF(k, m, k + (int)(f1 * f3), m + (int)(f3 * f2));
  }

  public void a()
  {
    a(b(this.c.i()));
  }

  public void a(RectF paramRectF)
  {
    this.d = true;
    int[] arrayOfInt = { 1 };
    Handler localHandler = new Handler();
    localHandler.postDelayed(new CropAnimationManager.1(this, paramRectF, arrayOfInt, localHandler), 25L);
  }

  public boolean b()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropAnimationManager
 * JD-Core Version:    0.6.0
 */