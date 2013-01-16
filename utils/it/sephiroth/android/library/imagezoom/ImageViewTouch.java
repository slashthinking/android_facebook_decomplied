package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ViewConfiguration;

public class ImageViewTouch extends ImageViewTouchBase
{
  private ImageViewTouch.OnImageViewTouchDoubleTapListener C;
  protected ScaleGestureDetector a;
  protected GestureDetector b;
  protected int c;
  protected float d;
  protected float e;
  protected int f;
  protected GestureDetector.OnGestureListener g;
  protected ScaleGestureDetector.OnScaleGestureListener h;
  protected boolean i = true;
  protected boolean j = true;
  protected boolean k = true;

  public ImageViewTouch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected float a(float paramFloat1, float paramFloat2)
  {
    if (this.f == 1)
      if (paramFloat1 + 2.0F * this.e <= paramFloat2)
        paramFloat2 = paramFloat1 + this.e;
    while (true)
    {
      return paramFloat2;
      this.f = -1;
      continue;
      this.f = 1;
      paramFloat2 = 1.0F;
    }
  }

  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    if (!this.a.isInProgress())
      this.d = paramFloat;
  }

  protected void a(Drawable paramDrawable)
  {
    super.a(paramDrawable);
    float[] arrayOfFloat = new float[9];
    this.n.getValues(arrayOfFloat);
    this.d = arrayOfFloat[0];
  }

  protected void a(Drawable paramDrawable, boolean paramBoolean, Matrix paramMatrix, float paramFloat)
  {
    super.a(paramDrawable, paramBoolean, paramMatrix, paramFloat);
    this.e = (getMaxZoom() / 3.0F);
  }

  public boolean a(int paramInt)
  {
    boolean bool = true;
    RectF localRectF = getBitmapRect();
    a(localRectF, this.B);
    Rect localRect = new Rect();
    getGlobalVisibleRect(localRect);
    if ((localRectF.right >= localRect.right) && (paramInt < 0))
      if (Math.abs(localRectF.right - localRect.right) <= 1.0F);
    while (true)
    {
      return bool;
      bool = false;
      continue;
      if (Math.abs(localRectF.left - this.B.left) <= 1.0D)
        bool = false;
    }
  }

  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = this.k;
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      bool2 = false;
      if (paramMotionEvent1 != null)
      {
        bool2 = false;
        if (paramMotionEvent2 != null)
        {
          int m = paramMotionEvent1.getPointerCount();
          bool2 = false;
          if (m <= 1)
          {
            int n = paramMotionEvent2.getPointerCount();
            bool2 = false;
            if (n <= 1)
            {
              boolean bool3 = this.a.isInProgress();
              bool2 = false;
              if (!bool3)
              {
                boolean bool4 = getScale() < 1.0F;
                bool2 = false;
                if (bool4)
                {
                  Log.d("image", "onScroll: " + paramFloat1 + ", " + paramFloat2);
                  d(-paramFloat1, -paramFloat2);
                  invalidate();
                  bool2 = true;
                }
              }
            }
          }
        }
      }
    }
  }

  protected void b(float paramFloat)
  {
    super.b(paramFloat);
    if (!this.a.isInProgress())
      this.d = paramFloat;
    if (paramFloat < getMinZoom())
      c(getMinZoom(), 50.0F);
  }

  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = this.k;
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      int m = paramMotionEvent1.getPointerCount();
      bool2 = false;
      if (m <= 1)
      {
        int n = paramMotionEvent2.getPointerCount();
        bool2 = false;
        if (n <= 1)
        {
          boolean bool3 = this.a.isInProgress();
          bool2 = false;
          if (!bool3)
          {
            float f1 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
            float f2 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
            if (Math.abs(paramFloat1) <= 800.0F)
            {
              boolean bool4 = Math.abs(paramFloat2) < 800.0F;
              bool2 = false;
              if (!bool4);
            }
            else
            {
              a(f1 / 2.0F, f2 / 2.0F, 300.0D);
              invalidate();
              bool2 = true;
            }
          }
        }
      }
    }
  }

  protected void c()
  {
    super.c();
    this.c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.g = getGestureListener();
    this.h = getScaleListener();
    this.a = new ScaleGestureDetector(getContext(), this.h);
    this.b = new GestureDetector(getContext(), this.g, null, true);
    this.d = 1.0F;
    this.f = 1;
  }

  public boolean getDoubleTapEnabled()
  {
    return this.i;
  }

  protected GestureDetector.OnGestureListener getGestureListener()
  {
    return new ImageViewTouch.GestureListener(this);
  }

  protected ScaleGestureDetector.OnScaleGestureListener getScaleListener()
  {
    return new ImageViewTouch.ScaleListener(this);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.onTouchEvent(paramMotionEvent);
    if (!this.a.isInProgress())
      this.b.onTouchEvent(paramMotionEvent);
    switch (0xFF & paramMotionEvent.getAction())
    {
    default:
    case 1:
    }
    while (true)
    {
      return true;
      if (getScale() < getMinZoom())
        c(getMinZoom(), 50.0F);
    }
  }

  public void setDoubleTapEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void setDoubleTapListener(ImageViewTouch.OnImageViewTouchDoubleTapListener paramOnImageViewTouchDoubleTapListener)
  {
    this.C = paramOnImageViewTouchDoubleTapListener;
  }

  public void setScaleEnabled(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public void setScrollEnabled(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     it.sephiroth.android.library.imagezoom.ImageViewTouch
 * JD-Core Version:    0.6.2
 */