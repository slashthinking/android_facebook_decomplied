package com.facebook.camera.facetracking;

import android.graphics.Rect;

public class TrackedFace
{
  public float a = 0.0F;
  public float b = 0.0F;
  public Rect c = null;
  public float d = 0.0F;
  public float e = 0.0F;
  public Rect f = null;
  public double g = 1.7976931348623157E+308D;
  public boolean h = false;
  public float i = 0.0F;
  public float j = 0.0F;
  public int k = 0;
  public long l = 0L;

  public TrackedFace(long paramLong)
  {
    this.l = paramLong;
  }

  public TrackedFace(Rect paramRect)
  {
    this.f = paramRect;
    this.d = paramRect.exactCenterX();
    this.e = paramRect.exactCenterY();
    this.l = c();
  }

  private void b(Rect paramRect)
  {
    this.f = new Rect(paramRect);
    this.d = paramRect.exactCenterX();
    this.e = paramRect.exactCenterY();
  }

  private static long c()
  {
    return System.currentTimeMillis();
  }

  private void c(Rect paramRect)
  {
    this.c = new Rect(paramRect);
    this.a = paramRect.exactCenterX();
    this.b = paramRect.exactCenterY();
  }

  public int a()
  {
    return this.f.width() * this.f.height();
  }

  public void a(Rect paramRect)
  {
    this.c = this.f;
    this.a = this.d;
    this.b = this.e;
    this.g = FaceTracker.a(paramRect.exactCenterX(), paramRect.exactCenterY(), this.d, this.e);
    this.f = paramRect;
    this.d = paramRect.exactCenterX();
    this.e = paramRect.exactCenterY();
  }

  public TrackedFace b()
  {
    TrackedFace localTrackedFace = new TrackedFace(this.l);
    if (this.f != null)
      localTrackedFace.b(this.f);
    if (this.c != null)
      localTrackedFace.c(this.c);
    localTrackedFace.g = this.g;
    localTrackedFace.h = this.h;
    localTrackedFace.i = this.i;
    localTrackedFace.j = this.j;
    localTrackedFace.k = this.k;
    return localTrackedFace;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.facetracking.TrackedFace
 * JD-Core Version:    0.6.0
 */