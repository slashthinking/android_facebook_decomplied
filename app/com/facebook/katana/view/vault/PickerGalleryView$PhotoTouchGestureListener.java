package com.facebook.katana.view.vault;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.facebook.katana.activity.media.MediaPickerGalleryAdapter;
import com.facebook.katana.activity.media.PhotoPage;
import com.facebook.katana.activity.media.TouchBlip;
import com.facebook.katana.ui.ImageViewTouchBase;

class PickerGalleryView$PhotoTouchGestureListener extends GestureDetector.SimpleOnGestureListener
{
  private PickerGalleryView$PhotoTouchGestureListener(PickerGalleryView paramPickerGalleryView)
  {
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    PickerGalleryView.n(this.a);
    PickerGalleryView.d(this.a, false);
    Rect localRect = new Rect();
    ImageViewTouchBase localImageViewTouchBase = PickerGalleryView.f(this.a).f().getImageView();
    localImageViewTouchBase.getGlobalVisibleRect(localRect);
    RectF localRectF1 = localImageViewTouchBase.getDisplayedImageRect();
    float f1 = localRectF1.right - localRectF1.left;
    float f2 = localRectF1.bottom - localRectF1.top;
    RectF localRectF2 = new RectF(localRectF1.left + localRect.left, localRectF1.top + localRect.top, f1 + (localRectF1.left + localRect.left), f2 + (localRectF1.top + localRect.top));
    if (localRectF2.contains(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
    {
      float f3 = (paramMotionEvent.getRawX() - localRectF2.left) / f1;
      float f4 = (paramMotionEvent.getRawY() - localRectF2.top) / f2;
      PickerGalleryView.a(this.a, new PointF(f3, f4));
      PickerGalleryView.o(this.a).a(PickerGalleryView.e(this.a), localRectF1);
      if (!PickerGalleryView.f(this.a).b(PickerGalleryView.e(this.a)))
        PickerGalleryView.p(this.a);
    }
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.PhotoTouchGestureListener
 * JD-Core Version:    0.6.0
 */