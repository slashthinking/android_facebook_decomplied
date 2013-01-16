package com.facebook.orca.camera;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

class CropImage$3$1
  implements Runnable
{
  public void run()
  {
    if ((this.a != CropImage.c(this.c.a)) && (this.a != null))
    {
      CropImage.d(this.c.a).a(this.a, true);
      CropImage.c(this.c.a).recycle();
      CropImage.a(this.c.a, this.a);
    }
    if (CropImage.d(this.c.a).b() == 1.0F)
      CropImage.d(this.c.a).a(true, true);
    this.b.countDown();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.CropImage.3.1
 * JD-Core Version:    0.6.0
 */