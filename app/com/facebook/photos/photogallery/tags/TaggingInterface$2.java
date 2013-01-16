package com.facebook.photos.photogallery.tags;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.widget.ViewTransform;

class TaggingInterface$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    TaggingInterface.a(this.a).setTranslationY(-this.a.getHeight());
    if (Build.VERSION.SDK_INT >= 16)
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    while (true)
    {
      return;
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TaggingInterface.2
 * JD-Core Version:    0.6.0
 */