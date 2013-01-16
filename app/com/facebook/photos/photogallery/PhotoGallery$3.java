package com.facebook.photos.photogallery;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class PhotoGallery$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16)
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    while (true)
    {
      PhotoGallery.a(this.a).a();
      PhotoGallery.a(this.a).b(this.a.getCurrentIndex(), PhotoGallery.a(this.a, this.a.getCurrentIndex()));
      return;
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.PhotoGallery.3
 * JD-Core Version:    0.6.0
 */