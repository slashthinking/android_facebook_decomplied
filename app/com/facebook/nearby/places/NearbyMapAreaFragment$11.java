package com.facebook.nearby.places;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.facebook.maps.MapFragment;

class NearbyMapAreaFragment$11
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 2)
      NearbyMapAreaFragment.c(this.b).a(null);
    if (paramMotionEvent.getAction() == 0)
    {
      NearbyMapAreaFragment.g(this.b).a();
      NearbyMapAreaFragment.l(this.b);
      this.b.A().getParent().requestDisallowInterceptTouchEvent(true);
    }
    while (true)
    {
      return this.a.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() != 1)
        continue;
      NearbyMapAreaFragment.a(this.b);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment.11
 * JD-Core Version:    0.6.0
 */