package com.facebook.katana.activity.media;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class CameraReviewActivity$PhotoTouchListener
  implements View.OnTouchListener
{
  private CameraReviewActivity$PhotoTouchListener(CameraReviewActivity paramCameraReviewActivity)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    CameraReviewActivity.r(this.a);
    Rect localRect = new Rect();
    CameraReviewActivity.e(this.a).getGlobalVisibleRect(localRect);
    RectF localRectF1 = new RectF(localRect);
    Matrix localMatrix = CameraReviewActivity.e(this.a).getImageMatrix();
    float[] arrayOfFloat = { 0.0F, 0.0F };
    localMatrix.mapPoints(arrayOfFloat);
    float f1 = CameraReviewActivity.e(this.a).getWidth() - 2.0F * arrayOfFloat[0];
    float f2 = CameraReviewActivity.e(this.a).getHeight() - 2.0F * arrayOfFloat[1];
    RectF localRectF2 = new RectF(arrayOfFloat[0] + localRect.left, arrayOfFloat[1] + localRect.top, f1 + (arrayOfFloat[0] + localRect.left), f2 + (arrayOfFloat[1] + localRect.top));
    if (localRectF2.contains(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))
    {
      float f3 = (paramMotionEvent.getRawX() - arrayOfFloat[0] - localRectF1.left) / f1;
      float f4 = (paramMotionEvent.getRawY() - arrayOfFloat[1] - localRectF1.top) / f2;
      CameraReviewActivity.a(this.a, new PointF(f3, f4));
      CameraReviewActivity.s(this.a).a(CameraReviewActivity.i(this.a), localRectF2);
      if (paramMotionEvent.getAction() == 1)
        CameraReviewActivity.l(this.a);
    }
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.PhotoTouchListener
 * JD-Core Version:    0.6.0
 */