package com.facebook.appcenter.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

class HorizontalImageGallery$CustomOnTouchListener
  implements View.OnTouchListener
{
  private boolean b = false;
  private float c;
  private int d;
  private boolean e = true;

  private HorizontalImageGallery$CustomOnTouchListener(HorizontalImageGallery paramHorizontalImageGallery)
  {
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    HorizontalImageGallery.a(this.a, paramMotionEvent.getX());
    HorizontalImageGallery.b(this.a, paramMotionEvent.getY());
    this.e = false;
    return false;
  }

  private boolean b(MotionEvent paramMotionEvent)
  {
    float f = HorizontalImageGallery.c(this.a) - (int)paramMotionEvent.getX();
    int i;
    if (f < 0.0F)
      if (4.0F + this.c <= f)
      {
        i = 1;
        if ((i == this.d) || (this.e))
          break label202;
        HorizontalImageGallery.a(this.a, paramMotionEvent.getX());
        this.c = (HorizontalImageGallery.c(this.a) - paramMotionEvent.getX());
        label78: this.d = i;
        if (!HorizontalImageGallery.b(this.a))
          break label210;
        this.b = true;
        this.a.dispatchTouchEvent(MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 0, HorizontalImageGallery.c(this.a), HorizontalImageGallery.d(this.a), paramMotionEvent.getPressure(), paramMotionEvent.getSize(), paramMotionEvent.getMetaState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags()));
        HorizontalImageGallery.a(this.a, false);
      }
    label202: label210: for (int j = 1; ; j = 0)
    {
      return j;
      i = 2;
      break;
      if (this.c - 4.0F <= f)
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      this.c = f;
      break label78;
    }
  }

  private boolean c(MotionEvent paramMotionEvent)
  {
    float f1 = this.a.getScrollX();
    float f2 = HorizontalImageGallery.e(this.a).getMeasuredWidth() / HorizontalImageGallery.f(this.a);
    float f3 = f1 / HorizontalImageGallery.f(this.a);
    float f4;
    if (this.d == 1)
      if (this.c > 30.0F)
        if (HorizontalImageGallery.g(this.a) < f2 - 1.0F)
          f4 = (f3 + 1.0F) * HorizontalImageGallery.f(this.a);
    while (true)
    {
      this.a.a((int)f4 / HorizontalImageGallery.f(this.a));
      this.e = true;
      this.c = 0.0F;
      HorizontalImageGallery.a(this.a, 0);
      return true;
      f4 = HorizontalImageGallery.g(this.a) * HorizontalImageGallery.f(this.a);
      continue;
      if (Math.round(f3) == f2 - 1.0F)
      {
        f4 = (int)(f3 + 1.0F) * HorizontalImageGallery.f(this.a);
        continue;
      }
      f4 = HorizontalImageGallery.g(this.a) * HorizontalImageGallery.f(this.a);
      continue;
      if (this.c < -30.0F)
      {
        f4 = (int)f3 * HorizontalImageGallery.f(this.a);
        continue;
      }
      if (Math.round(f3) == 0)
      {
        f4 = (int)f3 * HorizontalImageGallery.f(this.a);
        continue;
      }
      f4 = HorizontalImageGallery.g(this.a) * HorizontalImageGallery.f(this.a);
    }
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (((HorizontalImageGallery.a(this.a) != null) && (!HorizontalImageGallery.b(this.a))) || ((HorizontalImageGallery.a(this.a) != null) && (this.b) && (HorizontalImageGallery.a(this.a).onTouch(paramView, paramMotionEvent))))
      if (paramMotionEvent.getAction() == i)
        c(paramMotionEvent);
    while (true)
    {
      return i;
      if (this.b)
      {
        this.b = false;
        i = 0;
        continue;
      }
      boolean bool;
      switch (paramMotionEvent.getAction())
      {
      default:
        i = 0;
        break;
      case 0:
        bool = a(paramMotionEvent);
        break;
      case 2:
        bool = b(paramMotionEvent);
        break;
      case 1:
        bool = c(paramMotionEvent);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.HorizontalImageGallery.CustomOnTouchListener
 * JD-Core Version:    0.6.0
 */