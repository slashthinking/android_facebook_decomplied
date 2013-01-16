package com.facebook.katana.view.vault;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.facebook.katana.activity.media.MediaPickerGalleryAdapter;

class PickerGalleryView$5
  implements ViewPager.OnPageChangeListener
{
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }

  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void b(int paramInt)
  {
    if (paramInt == 1)
    {
      if (!PickerGalleryView.k(this.a))
        PickerGalleryView.f(this.a).i();
      PickerGalleryView.c(this.a, false);
      PickerGalleryView.j(this.a);
    }
    while (true)
    {
      return;
      if ((paramInt == 0) && (PickerGalleryView.l(this.a) != null))
      {
        PickerGalleryView.m(this.a);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.5
 * JD-Core Version:    0.6.0
 */