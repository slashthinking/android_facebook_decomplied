package com.facebook.photos.photogallery.tags;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class TagsView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    if (this.a.getWidth() > 0)
    {
      TagsView.a(this.c, this.b);
      if (Build.VERSION.SDK_INT < 16)
        break label41;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    while (true)
    {
      return;
      label41: this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TagsView.2
 * JD-Core Version:    0.6.0
 */