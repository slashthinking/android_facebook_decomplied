package com.facebook.maps;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.google.common.collect.Lists;
import java.util.List;

class GoogleMapFragment$AddedOverlaysItemizedOverlay extends ItemizedOverlay<OverlayItem>
{
  private final boolean a;
  private List<OverlayItem> b = Lists.a();

  public GoogleMapFragment$AddedOverlaysItemizedOverlay(Drawable paramDrawable, boolean paramBoolean)
  {
    super(paramDrawable);
    populate();
    this.a = paramBoolean;
  }

  public void a(OverlayItem paramOverlayItem)
  {
    this.b.add(paramOverlayItem);
    setFocus(null);
    setLastFocusedIndex(-1);
    populate();
  }

  public void b(OverlayItem paramOverlayItem)
  {
    this.b.remove(paramOverlayItem);
    setFocus(null);
    setLastFocusedIndex(-1);
    populate();
  }

  protected OverlayItem createItem(int paramInt)
  {
    return (OverlayItem)this.b.get(paramInt);
  }

  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.a));
    while (true)
    {
      return;
      super.draw(paramCanvas, paramMapView, paramBoolean);
    }
  }

  public int size()
  {
    return this.b.size();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.GoogleMapFragment.AddedOverlaysItemizedOverlay
 * JD-Core Version:    0.6.0
 */