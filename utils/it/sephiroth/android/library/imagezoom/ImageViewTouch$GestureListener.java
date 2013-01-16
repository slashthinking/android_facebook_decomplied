package it.sephiroth.android.library.imagezoom;

import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class ImageViewTouch$GestureListener extends GestureDetector.SimpleOnGestureListener
{
  public ImageViewTouch$GestureListener(ImageViewTouch paramImageViewTouch)
  {
  }

  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    Log.i("image", "onDoubleTap. double tap enabled? " + this.b.i);
    if (this.b.i)
    {
      float f1 = this.b.getScale();
      float f2 = this.b.a(f1, this.b.getMaxZoom());
      float f3 = Math.min(this.b.getMaxZoom(), Math.max(f2, this.b.getMinZoom()));
      this.b.d = f3;
      this.b.a(f3, paramMotionEvent.getX(), paramMotionEvent.getY(), 200.0F);
      this.b.invalidate();
    }
    if (ImageViewTouch.a(this.b) != null)
      ImageViewTouch.a(this.b).a();
    return super.onDoubleTap(paramMotionEvent);
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.b.b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.b.isLongClickable()) && (!this.b.a.isInProgress()))
    {
      this.b.setPressed(true);
      this.b.performLongClick();
    }
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.b.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.ImageViewTouch.GestureListener
 * JD-Core Version:    0.6.2
 */