package com.facebook.photos.photogallery;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.View;
import com.facebook.widget.UrlImage;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

class ZoomableViewPager$1 extends ViewPager.SimpleOnPageChangeListener
{
  public void b(int paramInt)
  {
    super.b(paramInt);
    if (this.a.getAdapter() != null)
      ((ImageViewTouch)((UrlImage)(UrlImage)ZoomableViewPager.a(this.a).A().findViewById(2131296658)).getImageView()).c(1.0F, 300.0F);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.ZoomableViewPager.1
 * JD-Core Version:    0.6.0
 */