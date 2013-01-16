package com.facebook.maps;

import android.graphics.drawable.Drawable;
import com.google.android.maps.MapView;

class GoogleMapFragment$GoogleMapOverlayElement
  implements MapFragment.MapOverlayElement
{
  private GoogleMapFragment.SelectableOverlayItem b;

  private GoogleMapFragment$GoogleMapOverlayElement(GoogleMapFragment paramGoogleMapFragment, GoogleMapFragment.SelectableOverlayItem paramSelectableOverlayItem)
  {
    this.b = paramSelectableOverlayItem;
  }

  public void a(Drawable paramDrawable)
  {
    this.b.setMarker(paramDrawable);
    GoogleMapFragment.c(this.a).invalidate();
  }

  public void a(MapFragment.MapOverlayElement.OnSelectedListener paramOnSelectedListener)
  {
    this.b.a(paramOnSelectedListener);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.GoogleMapFragment.GoogleMapOverlayElement
 * JD-Core Version:    0.6.0
 */