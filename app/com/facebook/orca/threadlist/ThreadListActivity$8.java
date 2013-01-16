package com.facebook.orca.threadlist;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.orca.common.ui.titlebar.DivebarController.DivebarOverlayClickListener;

class ThreadListActivity$8
  implements DivebarController.DivebarOverlayClickListener
{
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (paramMotionEvent.getAction() != 0)
    {
      int i = paramMotionEvent.getAction();
      bool2 = false;
      if (1 != i);
    }
    else
    {
      Rect localRect = new Rect();
      ThreadListActivity.f(this.a).getHitRect(localRect);
      boolean bool1 = localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool2 = false;
      if (bool1)
        bool2 = ThreadListActivity.f(this.a).onTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListActivity.8
 * JD-Core Version:    0.6.0
 */