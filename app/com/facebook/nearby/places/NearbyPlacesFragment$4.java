package com.facebook.nearby.places;

import android.graphics.drawable.TransitionDrawable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.facebook.nearby.ui.SplitHideableListView.OnSplitHeightChangedListener;

class NearbyPlacesFragment$4
  implements SplitHideableListView.OnSplitHeightChangedListener
{
  private int b = NearbyPlacesFragment.g(this.a).getLayoutParams().height;
  private int c = -1;
  private int d = -1;

  public void a()
  {
    NearbyPlacesFragment.h(this.a);
    NearbyPlacesFragment.k(this.a).d();
  }

  public void a(int paramInt)
  {
    if (this.c == -1)
    {
      this.c = paramInt;
      this.d = this.c;
      return;
    }
    if (Math.abs(this.c - this.d) > 0)
      NearbyPlacesFragment.h(this.a);
    if ((this.c > this.b) && (paramInt <= this.b))
    {
      NearbyPlacesFragment.i(this.a).startTransition(125);
      NearbyPlacesFragment.j(this.a).setBackgroundResource(2130838402);
    }
    while (true)
    {
      this.c = paramInt;
      break;
      if ((this.c > this.b) || (paramInt <= this.b))
        continue;
      NearbyPlacesFragment.i(this.a).reverseTransition(125);
      NearbyPlacesFragment.j(this.a).setBackgroundResource(2130838400);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesFragment.4
 * JD-Core Version:    0.6.0
 */