package com.facebook.katana.binding;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;

class ProfileImagesCache$4
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = ProfileImagesCache.a(this.a, this.b);
    this.c.a(localBitmap);
    ProfileImagesCache.f(this.e).b().post(new ProfileImagesCache.4.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ProfileImagesCache.4
 * JD-Core Version:    0.6.0
 */