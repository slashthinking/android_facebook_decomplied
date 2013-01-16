package com.facebook.maps;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.ItemizedOverlay.OnFocusChangeListener;
import com.google.android.maps.OverlayItem;

class GoogleMapFragment$1
  implements ItemizedOverlay.OnFocusChangeListener
{
  public void onFocusChanged(ItemizedOverlay paramItemizedOverlay, OverlayItem paramOverlayItem)
  {
    GoogleMapFragment.SelectableOverlayItem localSelectableOverlayItem = (GoogleMapFragment.SelectableOverlayItem)paramOverlayItem;
    GoogleMapFragment.a(this.a, localSelectableOverlayItem);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.GoogleMapFragment.1
 * JD-Core Version:    0.6.0
 */