package com.facebook.katana.view.vault;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.facebook.photos.analytics.PhotoFlowLogger;

class PickerGalleryView$2
  implements View.OnKeyListener
{
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (!PickerGalleryView.c(this.a))
    {
      PickerGalleryView.a(this.a, true);
      PickerGalleryView.d(this.a).b();
    }
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.2
 * JD-Core Version:    0.6.0
 */