package com.facebook.orca.threadview;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class ZoomOverlay extends Overlay
{
  private final GestureDetector a;
  private final MapView b;

  ZoomOverlay(Context paramContext, MapView paramMapView)
  {
    ZoomOverlay.1 local1 = new ZoomOverlay.1(this);
    ZoomOverlay.2 local2 = new ZoomOverlay.2(this);
    this.b = paramMapView;
    this.a = new GestureDetector(paramContext, local1);
    this.a.setOnDoubleTapListener(local1);
    paramMapView.setOnTouchListener(local2);
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    this.b.getController().zoomInFixing((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    return true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return this.a.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ZoomOverlay
 * JD-Core Version:    0.6.0
 */