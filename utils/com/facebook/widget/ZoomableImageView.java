package com.facebook.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class ZoomableImageView extends ImageViewTouch
{
  private boolean C = true;
  private ZoomableImageView.ZoomableImageViewListener D;

  public ZoomableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFitToScreen(true);
  }

  private RectF getImageRect()
  {
    RectF localRectF = new RectF(0.0F, 0.0F, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
    getImageMatrix().mapRect(localRectF);
    return localRectF;
  }

  public PointF a(PointF paramPointF)
  {
    RectF localRectF = getImageRect();
    return new PointF(100.0F * ((paramPointF.x - localRectF.left) / localRectF.width()), 100.0F * ((paramPointF.y - localRectF.top) / localRectF.height()));
  }

  public void a()
  {
    this.C = true;
  }

  public void a(ZoomableImageView.ZoomableImageViewListener paramZoomableImageViewListener)
  {
    this.D = paramZoomableImageViewListener;
  }

  public void b()
  {
    this.C = false;
  }

  protected GestureDetector.OnGestureListener getGestureListener()
  {
    return new ZoomableImageView.GestureListener(this);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.C);
    for (boolean bool = super.onTouchEvent(paramMotionEvent); ; bool = false)
      return bool;
  }

  public void setImageMatrix(Matrix paramMatrix)
  {
    super.setImageMatrix(paramMatrix);
    if (this.D != null)
      this.D.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ZoomableImageView
 * JD-Core Version:    0.6.2
 */