package com.facebook.orca.common.ui.titlebar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class DivebarController$6
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f;
    if ((DivebarController.k(this.a) != null) && (this.a.a()))
    {
      f = paramMotionEvent.getX();
      paramMotionEvent.setLocation(f - DivebarController.l(this.a), paramMotionEvent.getY());
      if (!DivebarController.k(this.a).a(paramMotionEvent));
    }
    for (int i = 1; ; i = 0)
    {
      return i;
      paramMotionEvent.setLocation(f, paramMotionEvent.getY());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.DivebarController.6
 * JD-Core Version:    0.6.0
 */