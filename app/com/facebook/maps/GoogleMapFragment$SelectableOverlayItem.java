package com.facebook.maps;

import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

class GoogleMapFragment$SelectableOverlayItem extends OverlayItem
{
  private boolean a = false;
  private MapFragment.MapOverlayElement.OnSelectedListener b;

  public GoogleMapFragment$SelectableOverlayItem(GeoPoint paramGeoPoint, Drawable paramDrawable, String paramString1, String paramString2)
  {
    super(paramGeoPoint, paramString1, paramString2);
    setMarker(paramDrawable);
  }

  public void a()
  {
    this.a = true;
    this.b.a();
  }

  public void a(MapFragment.MapOverlayElement.OnSelectedListener paramOnSelectedListener)
  {
    this.b = paramOnSelectedListener;
  }

  public void b()
  {
    this.a = false;
    this.b.b();
  }

  public Drawable getMarker(int paramInt)
  {
    int i;
    if (((paramInt & 0x4) != 0) || ((paramInt & 0x2) != 0))
    {
      i = 1;
      if ((i == 0) || (this.a))
        break label38;
    }
    label38: for (Drawable localDrawable = super.getMarker(0); ; localDrawable = super.getMarker(paramInt))
    {
      return localDrawable;
      i = 0;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.GoogleMapFragment.SelectableOverlayItem
 * JD-Core Version:    0.6.0
 */