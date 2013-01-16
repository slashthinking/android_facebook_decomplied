package it.sephiroth.android.library.imagezoom;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

class ImageViewTouchBase$1
  implements Runnable
{
  ImageViewTouchBase$1(ImageViewTouchBase paramImageViewTouchBase, Drawable paramDrawable, boolean paramBoolean, Matrix paramMatrix, float paramFloat)
  {
  }

  public void run()
  {
    this.e.setImageDrawable(this.a, this.b, this.c, this.d);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.ImageViewTouchBase.1
 * JD-Core Version:    0.6.2
 */