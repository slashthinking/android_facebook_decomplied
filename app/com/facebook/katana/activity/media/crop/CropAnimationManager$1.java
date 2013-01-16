package com.facebook.katana.activity.media.crop;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;

class CropAnimationManager$1
  implements Runnable
{
  public void run()
  {
    RectF localRectF = CropAnimationManager.a(this.d, CropAnimationManager.a(this.d).i(), this.a, this.b[0], 10);
    Matrix localMatrix = new Matrix();
    float f = localRectF.width() / CropAnimationManager.a(this.d).i().width();
    localMatrix.postScale(f, f, CropAnimationManager.a(this.d).i().centerX(), CropAnimationManager.a(this.d).i().centerY());
    localMatrix.postTranslate(localRectF.centerX() - CropAnimationManager.a(this.d).i().centerX(), localRectF.centerY() - CropAnimationManager.a(this.d).i().centerY());
    CropAnimationManager.a(this.d).b(localMatrix);
    CropAnimationManager.b(this.d).setImageMatrix(CropAnimationManager.a(this.d).m());
    CropAnimationManager.c(this.d).setHighlightArea();
    int[] arrayOfInt = this.b;
    arrayOfInt[0] = (1 + arrayOfInt[0]);
    if (this.b[0] <= 10)
      this.c.postDelayed(this, 25L);
    while (true)
    {
      return;
      CropAnimationManager.a(this.d, false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropAnimationManager.1
 * JD-Core Version:    0.6.0
 */