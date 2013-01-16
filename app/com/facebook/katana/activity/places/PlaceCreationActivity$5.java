package com.facebook.katana.activity.places;

import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.ImageView;
import com.facebook.katana.util.FBLocationManager;
import com.facebook.maps.Locations;
import com.facebook.maps.MapFragment;

class PlaceCreationActivity$5
  implements View.OnTouchListener
{
  private Location b;

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView.getParent().requestDisallowInterceptTouchEvent(true);
    if (i == 0)
      this.b = PlaceCreationActivity.o(this.a).a();
    while (true)
    {
      return false;
      if (i == 2)
      {
        if (Locations.a(PlaceCreationActivity.o(this.a).a(), this.b))
          continue;
        PlaceCreationActivity.v(this.a).setVisibility(0);
        PlaceCreationActivity.a(this.a, true);
        FBLocationManager.a(PlaceCreationActivity.w(this.a));
        continue;
      }
      if (i != 1)
        continue;
      PlaceCreationActivity.a(this.a, PlaceCreationActivity.o(this.a).a());
      PlaceCreationActivity.b(this.a, PlaceCreationActivity.q(this.a));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.PlaceCreationActivity.5
 * JD-Core Version:    0.6.0
 */