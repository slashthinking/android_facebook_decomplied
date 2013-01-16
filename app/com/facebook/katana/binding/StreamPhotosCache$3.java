package com.facebook.katana.binding;

import android.os.Handler;
import com.facebook.common.util.Log;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;

class StreamPhotosCache$3
  implements Runnable
{
  public void run()
  {
    try
    {
      this.a.a(ImageUtils.b(this.a.c()));
      StreamPhotosCache.b(this.c).b().post(new StreamPhotosCache.3.1(this));
      return;
    }
    catch (ImageUtils.ImageException localImageException)
    {
      while (true)
        Log.a("StreamPhotosCache.decode", "cannot decoded: " + this.a.b(), localImageException);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.StreamPhotosCache.3
 * JD-Core Version:    0.6.0
 */