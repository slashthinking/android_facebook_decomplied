package com.facebook.katana.view.vault;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PickerGalleryView$PhotoTouchListener
  implements View.OnTouchListener
{
  private PickerGalleryView$PhotoTouchListener(PickerGalleryView paramPickerGalleryView)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return PickerGalleryView.r(this.a).onTouchEvent(paramMotionEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.PhotoTouchListener
 * JD-Core Version:    0.6.0
 */