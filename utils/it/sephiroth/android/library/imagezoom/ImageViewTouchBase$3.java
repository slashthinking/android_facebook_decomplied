package it.sephiroth.android.library.imagezoom;

import android.os.Handler;
import it.sephiroth.android.library.imagezoom.easing.Easing;

class ImageViewTouchBase$3
  implements Runnable
{
  ImageViewTouchBase$3(ImageViewTouchBase paramImageViewTouchBase, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
  }

  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.a, (float)(l - this.b));
    float f2 = (float)this.g.l.b(f1, 0.0D, this.c, this.a);
    this.g.b(f2 + this.d, this.e, this.f);
    if (f1 < this.a)
      this.g.o.post(this);
    while (true)
    {
      return;
      this.g.b(this.g.getScale());
      this.g.a(true, true);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.ImageViewTouchBase.3
 * JD-Core Version:    0.6.2
 */