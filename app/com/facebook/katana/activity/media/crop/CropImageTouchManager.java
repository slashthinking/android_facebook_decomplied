package com.facebook.katana.activity.media.crop;

import android.view.MotionEvent;

public class CropImageTouchManager
{
  private final CropState a;
  private final CropHelper b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private int m = -1;
  private int n = -1;
  private long o = -100L;

  public CropImageTouchManager(CropHelper paramCropHelper, CropState paramCropState)
  {
    this.b = paramCropHelper;
    this.a = paramCropState;
  }

  private void b(MotionEvent paramMotionEvent)
  {
    this.m = paramMotionEvent.getPointerId(0);
    this.e = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.m));
    this.f = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.m));
  }

  private void c(MotionEvent paramMotionEvent)
  {
    this.n = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
    this.c = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.n));
    this.d = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.n));
    this.k = this.b.a(this.c, this.e);
    this.l = this.b.a(this.d, this.f);
  }

  private void d(MotionEvent paramMotionEvent)
  {
    this.i = paramMotionEvent.getX();
    this.j = paramMotionEvent.getY();
    a();
    this.e = this.i;
    this.f = this.j;
  }

  private void e(MotionEvent paramMotionEvent)
  {
    this.i = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.m));
    this.j = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.m));
    this.g = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.n));
    this.h = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.n));
    b();
    this.c = this.g;
    this.d = this.h;
    this.e = this.i;
    this.f = this.j;
    this.o = paramMotionEvent.getEventTime();
  }

  protected void a()
  {
    this.a.a(this.i - this.e, this.j - this.f);
  }

  public void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 3:
    case 4:
    default:
    case 0:
    case 5:
    case 2:
    case 1:
    case 6:
    }
    while (true)
    {
      return;
      b(paramMotionEvent);
      continue;
      c(paramMotionEvent);
      continue;
      if ((this.m != -1) && (this.n != -1))
      {
        e(paramMotionEvent);
        continue;
      }
      if ((this.m == -1) || (paramMotionEvent.getEventTime() < 100L + this.o))
        continue;
      d(paramMotionEvent);
      continue;
      this.m = -1;
      continue;
      this.n = -1;
    }
  }

  protected void b()
  {
    float f1 = this.b.a(this.e, this.f, this.c, this.d, this.i, this.j, this.g, this.h);
    this.a.a(-f1, this.k, this.l);
    float f2 = this.b.b(this.e, this.f, this.c, this.d, this.i, this.j, this.g, this.h);
    this.a.b(f2, this.k, this.l);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropImageTouchManager
 * JD-Core Version:    0.6.0
 */