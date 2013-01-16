package com.facebook.orca.threadview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class ZoomOverlay$1 extends GestureDetector.SimpleOnGestureListener
{
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return ZoomOverlay.a(this.a, paramMotionEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ZoomOverlay.1
 * JD-Core Version:    0.6.0
 */