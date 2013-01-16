package it.sephiroth.android.library.imagezoom;

import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

public class ImageViewTouch$ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public ImageViewTouch$ScaleListener(ImageViewTouch paramImageViewTouch)
  {
  }

  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    int i = 1;
    Log.d("image", "onScale");
    (paramScaleGestureDetector.getCurrentSpan() - paramScaleGestureDetector.getPreviousSpan());
    float f1 = this.a.d * paramScaleGestureDetector.getScaleFactor();
    if (this.a.j)
    {
      float f2 = Math.min(this.a.getMaxZoom(), Math.max(f1, this.a.getMinZoom() - 0.1F));
      this.a.b(f2, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      this.a.d = Math.min(this.a.getMaxZoom(), Math.max(f2, this.a.getMinZoom() - 1.0F));
      this.a.f = i;
      this.a.invalidate();
    }
    while (true)
    {
      return i;
      i = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.ImageViewTouch.ScaleListener
 * JD-Core Version:    0.6.2
 */