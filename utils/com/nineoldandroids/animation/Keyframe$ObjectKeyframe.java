package com.nineoldandroids.animation;

class Keyframe$ObjectKeyframe extends Keyframe
{
  Object d;

  Keyframe$ObjectKeyframe(float paramFloat, Object paramObject)
  {
    this.a = paramFloat;
    this.d = paramObject;
    boolean bool;
    if (paramObject != null)
    {
      bool = true;
      this.c = bool;
      if (!this.c)
        break label50;
    }
    label50: for (Object localObject = paramObject.getClass(); ; localObject = Object.class)
    {
      this.b = ((Class)localObject);
      return;
      bool = false;
      break;
    }
  }

  public void a(Object paramObject)
  {
    this.d = paramObject;
    if (paramObject != null);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      return;
    }
  }

  public Object b()
  {
    return this.d;
  }

  public ObjectKeyframe g()
  {
    ObjectKeyframe localObjectKeyframe = new ObjectKeyframe(c(), this.d);
    localObjectKeyframe.a(d());
    return localObjectKeyframe;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe.ObjectKeyframe
 * JD-Core Version:    0.6.2
 */