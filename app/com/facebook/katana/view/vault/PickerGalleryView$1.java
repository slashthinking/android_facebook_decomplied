package com.facebook.katana.view.vault;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class PickerGalleryView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    int i = this.a.getResources().getConfiguration().orientation;
    if ((PickerGalleryView.a(this.a) != -1) && (i != PickerGalleryView.a(this.a)))
    {
      int j = PickerGalleryView.b(this.a).getCurrentItem();
      if (j > 0)
      {
        PickerGalleryView.b(this.a).setCurrentItem(j - 1, false);
        PickerGalleryView.b(this.a).setCurrentItem(j, false);
      }
    }
    PickerGalleryView.a(this.a, i);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.1
 * JD-Core Version:    0.6.0
 */