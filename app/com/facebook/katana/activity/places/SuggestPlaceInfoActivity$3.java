package com.facebook.katana.activity.places;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class SuggestPlaceInfoActivity$3
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.getParent().requestDisallowInterceptTouchEvent(true);
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SuggestPlaceInfoActivity.3
 * JD-Core Version:    0.6.0
 */