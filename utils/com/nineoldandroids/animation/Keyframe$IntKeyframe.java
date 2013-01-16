package com.nineoldandroids.animation;

class Keyframe$IntKeyframe extends Keyframe
{
  int d;

  Keyframe$IntKeyframe(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Integer.TYPE;
  }

  Keyframe$IntKeyframe(float paramFloat, int paramInt)
  {
    this.a = paramFloat;
    this.d = paramInt;
    this.b = Integer.TYPE;
    this.c = true;
  }

  public void a(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == Integer.class))
    {
      this.d = ((Integer)paramObject).intValue();
      this.c = true;
    }
  }

  public Object b()
  {
    return Integer.valueOf(this.d);
  }

  public int g()
  {
    return this.d;
  }

  public IntKeyframe h()
  {
    IntKeyframe localIntKeyframe = new IntKeyframe(c(), this.d);
    localIntKeyframe.a(d());
    return localIntKeyframe;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe.IntKeyframe
 * JD-Core Version:    0.6.2
 */