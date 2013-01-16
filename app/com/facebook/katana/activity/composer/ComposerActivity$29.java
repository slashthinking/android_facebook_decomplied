package com.facebook.katana.activity.composer;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ComposerActivity$29
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    View localView = this.b.findViewById(2131296520);
    paramMotionEvent.setLocation(this.a.getWidth(), paramMotionEvent.getY() + localView.getHeight());
    localView.onTouchEvent(paramMotionEvent);
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.29
 * JD-Core Version:    0.6.0
 */