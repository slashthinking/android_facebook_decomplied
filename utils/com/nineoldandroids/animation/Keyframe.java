package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe
  implements Cloneable
{
  float a;
  Class b;
  boolean c = false;
  private Interpolator d = null;

  public static Keyframe a(float paramFloat)
  {
    return new Keyframe.IntKeyframe(paramFloat);
  }

  public static Keyframe a(float paramFloat1, float paramFloat2)
  {
    return new Keyframe.FloatKeyframe(paramFloat1, paramFloat2);
  }

  public static Keyframe a(float paramFloat, int paramInt)
  {
    return new Keyframe.IntKeyframe(paramFloat, paramInt);
  }

  public static Keyframe a(float paramFloat, Object paramObject)
  {
    return new Keyframe.ObjectKeyframe(paramFloat, paramObject);
  }

  public static Keyframe b(float paramFloat)
  {
    return new Keyframe.FloatKeyframe(paramFloat);
  }

  public static Keyframe c(float paramFloat)
  {
    return new Keyframe.ObjectKeyframe(paramFloat, null);
  }

  public void a(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }

  public abstract void a(Object paramObject);

  public boolean a()
  {
    return this.c;
  }

  public abstract Object b();

  public float c()
  {
    return this.a;
  }

  public Interpolator d()
  {
    return this.d;
  }

  public Class e()
  {
    return this.b;
  }

  public abstract Keyframe f();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe
 * JD-Core Version:    0.6.2
 */