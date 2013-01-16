package com.nineoldandroids.animation;

class Keyframe$FloatKeyframe extends Keyframe
{
  float d;

  Keyframe$FloatKeyframe(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Float.TYPE;
  }

  Keyframe$FloatKeyframe(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.d = paramFloat2;
    this.b = Float.TYPE;
    this.c = true;
  }

  public void a(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == Float.class))
    {
      this.d = ((Float)paramObject).floatValue();
      this.c = true;
    }
  }

  public Object b()
  {
    return Float.valueOf(this.d);
  }

  public float g()
  {
    return this.d;
  }

  public FloatKeyframe h()
  {
    FloatKeyframe localFloatKeyframe = new FloatKeyframe(c(), this.d);
    localFloatKeyframe.a(d());
    return localFloatKeyframe;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe.FloatKeyframe
 * JD-Core Version:    0.6.2
 */