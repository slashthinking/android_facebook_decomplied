package com.facebook.orca.camera;

import android.graphics.Bitmap;
import android.os.Handler;
import com.facebook.orca.camera.gallery.IImage;
import java.util.concurrent.CountDownLatch;

class CropImage$3
  implements Runnable
{
  public void run()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bitmap localBitmap;
    if (CropImage.b(this.a) != null)
      localBitmap = CropImage.b(this.a).a(-1, 1048576);
    while (true)
    {
      CropImage.e(this.a).post(new CropImage.3.1(this, localBitmap, localCountDownLatch));
      try
      {
        localCountDownLatch.await();
        this.a.d.run();
        return;
        localBitmap = CropImage.c(this.a);
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
    throw new RuntimeException(localInterruptedException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.CropImage.3
 * JD-Core Version:    0.6.0
 */