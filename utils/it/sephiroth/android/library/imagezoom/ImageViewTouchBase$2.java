package it.sephiroth.android.library.imagezoom;

import android.graphics.RectF;
import android.os.Handler;
import it.sephiroth.android.library.imagezoom.easing.Easing;

class ImageViewTouchBase$2
  implements Runnable
{
  double a = 0.0D;
  double b = 0.0D;

  ImageViewTouchBase$2(ImageViewTouchBase paramImageViewTouchBase, double paramDouble1, long paramLong, double paramDouble2, double paramDouble3)
  {
  }

  public void run()
  {
    long l = System.currentTimeMillis();
    double d1 = Math.min(this.c, l - this.d);
    double d2 = this.g.l.a(d1, 0.0D, this.e, this.c);
    double d3 = this.g.l.a(d1, 0.0D, this.f, this.c);
    this.g.a(d2 - this.a, d3 - this.b);
    this.a = d2;
    this.b = d3;
    if (d1 < this.c)
      this.g.o.post(this);
    while (true)
    {
      return;
      RectF localRectF = this.g.a(this.g.n, true, true);
      if ((localRectF.left != 0.0F) || (localRectF.top != 0.0F))
        this.g.d(localRectF.left, localRectF.top);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.ImageViewTouchBase.2
 * JD-Core Version:    0.6.2
 */