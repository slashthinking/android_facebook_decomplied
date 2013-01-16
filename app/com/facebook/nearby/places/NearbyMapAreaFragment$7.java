package com.facebook.nearby.places;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.facebook.maps.MapFragment;
import com.facebook.nearby.analytics.NearbyAnalytics;

class NearbyMapAreaFragment$7
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    NearbyMapAreaFragment.f(this.a).c(NearbyMapAreaFragment.e(this.a));
    NearbyMapAreaFragment.g(this.a).b();
    NearbyMapAreaFragment.c(this.a).a(null);
    NearbyMapAreaFragment.h(this.a).clearAnimation();
    NearbyMapAreaFragment.k(this.a).reset();
    NearbyMapAreaFragment.h(this.a).startAnimation(NearbyMapAreaFragment.k(this.a));
    NearbyMapAreaFragment.h(this.a).setVisibility(8);
    NearbyMapAreaFragment.l(this.a);
    NearbyMapAreaFragment.m(this.a);
    NearbyMapAreaFragment.n(this.a).setVisibility(0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyMapAreaFragment.7
 * JD-Core Version:    0.6.0
 */