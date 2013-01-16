package com.facebook.widget;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import it.sephiroth.android.library.imagezoom.ImageViewTouch.GestureListener;

public class ZoomableImageView$GestureListener extends ImageViewTouch.GestureListener
{
  public ZoomableImageView$GestureListener(ZoomableImageView paramZoomableImageView)
  {
    super(paramZoomableImageView);
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (ZoomableImageView.a(this.a) != null)
    {
      RectF localRectF = ZoomableImageView.b(this.a);
      ZoomableImageView.a(this.a).a(new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()), localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ZoomableImageView.GestureListener
 * JD-Core Version:    0.6.2
 */