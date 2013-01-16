package com.facebook.katana.activity.media;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.katana.ui.ImageViewTouchBase;

class PhotoGalleryActivity$6 extends GestureDetector.SimpleOnGestureListener
{
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    RectF localRectF = PhotoGalleryActivity.z(this.a).getImageRect();
    if (localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      float f1 = (paramMotionEvent.getX() - localRectF.left) / localRectF.width();
      float f2 = (paramMotionEvent.getY() - localRectF.top) / localRectF.height();
      PhotoGalleryActivity.a(this.a, new PointF(f1, f2));
      if (PhotoGalleryActivity.A(this.a) == null)
        PhotoGalleryActivity.a(this.a, new TouchBlip(this.a, (RelativeLayout)this.a.findViewById(2131296460)));
      PhotoGalleryActivity.A(this.a).a(PhotoGalleryActivity.B(this.a), localRectF);
      if (paramBoolean)
        PhotoGalleryActivity.t(this.a);
    }
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    PhotoGalleryActivity.C(this.a).getGlobalVisibleRect(localRect);
    return localRect.contains(paramInt1, paramInt2);
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((PhotoGalleryActivity.D(this.a).getVisibility() == 0) && (paramMotionEvent.getY() > PhotoGalleryActivity.D(this.a).getTop()))
      bool = false;
    while (true)
    {
      return bool;
      if (PhotoGalleryActivity.k(this.a) == PhotoGalleryActivity.ViewMode.DEFAULT)
      {
        PhotoGalleryActivity.a(this.a, PhotoGalleryActivity.ViewMode.CONTROLS);
        continue;
      }
      if ((PhotoGalleryActivity.k(this.a) != PhotoGalleryActivity.ViewMode.CONTROLS) || (a((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
        continue;
      if ((PhotoGalleryActivity.E(this.a)) && (PhotoGalleryActivity.F(this.a)))
      {
        if (PhotoGalleryActivity.B(this.a) == null)
          a(paramMotionEvent, bool);
        while (true)
        {
          PhotoGalleryActivity.a(this.a);
          break;
          PhotoGalleryActivity.r(this.a);
        }
      }
      PhotoGalleryActivity.a(this.a, PhotoGalleryActivity.ViewMode.DEFAULT);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.6
 * JD-Core Version:    0.6.0
 */