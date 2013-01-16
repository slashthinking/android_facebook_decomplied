package com.facebook.orca.camera;

import android.os.Handler;

class ImageViewTouchBase$2
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.a, (float)(l - this.b));
    float f2 = this.c + f1 * this.d;
    this.g.a(f2, this.e, this.f);
    if (f1 < this.a)
      this.g.l.post(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.ImageViewTouchBase.2
 * JD-Core Version:    0.6.0
 */