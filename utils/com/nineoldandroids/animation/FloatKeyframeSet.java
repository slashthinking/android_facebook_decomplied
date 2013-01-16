package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class FloatKeyframeSet extends KeyframeSet
{
  private float g;
  private float h;
  private float i;
  private boolean j = true;

  public FloatKeyframeSet(Keyframe.FloatKeyframe[] paramArrayOfFloatKeyframe)
  {
    super(paramArrayOfFloatKeyframe);
  }

  public FloatKeyframeSet a()
  {
    ArrayList localArrayList = this.e;
    int k = this.e.size();
    Keyframe.FloatKeyframe[] arrayOfFloatKeyframe = new Keyframe.FloatKeyframe[k];
    for (int m = 0; m < k; m++)
      arrayOfFloatKeyframe[m] = ((Keyframe.FloatKeyframe)((Keyframe)localArrayList.get(m)).f());
    return new FloatKeyframeSet(arrayOfFloatKeyframe);
  }

  public Object a(float paramFloat)
  {
    return Float.valueOf(b(paramFloat));
  }

  public float b(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((Keyframe.FloatKeyframe)this.e.get(0)).g();
        this.h = ((Keyframe.FloatKeyframe)this.e.get(k)).g();
        this.i = (this.h - this.g);
      }
      if (this.d != null)
        paramFloat = this.d.getInterpolation(paramFloat);
      if (this.f == null)
        f1 = this.g + paramFloat * this.i;
    }
    while (true)
    {
      return f1;
      f1 = ((Number)this.f.a(paramFloat, Float.valueOf(this.g), Float.valueOf(this.h))).floatValue();
      continue;
      if (paramFloat <= 0.0F)
      {
        Keyframe.FloatKeyframe localFloatKeyframe4 = (Keyframe.FloatKeyframe)this.e.get(0);
        Keyframe.FloatKeyframe localFloatKeyframe5 = (Keyframe.FloatKeyframe)this.e.get(k);
        float f10 = localFloatKeyframe4.g();
        float f11 = localFloatKeyframe5.g();
        float f12 = localFloatKeyframe4.c();
        float f13 = localFloatKeyframe5.c();
        Interpolator localInterpolator3 = localFloatKeyframe5.d();
        if (localInterpolator3 != null)
          paramFloat = localInterpolator3.getInterpolation(paramFloat);
        float f14 = (paramFloat - f12) / (f13 - f12);
        if (this.f == null)
          f1 = f10 + f14 * (f11 - f10);
        else
          f1 = ((Number)this.f.a(f14, Float.valueOf(f10), Float.valueOf(f11))).floatValue();
      }
      else if (paramFloat >= 1.0F)
      {
        Keyframe.FloatKeyframe localFloatKeyframe2 = (Keyframe.FloatKeyframe)this.e.get(-2 + this.a);
        Keyframe.FloatKeyframe localFloatKeyframe3 = (Keyframe.FloatKeyframe)this.e.get(-1 + this.a);
        float f5 = localFloatKeyframe2.g();
        float f6 = localFloatKeyframe3.g();
        float f7 = localFloatKeyframe2.c();
        float f8 = localFloatKeyframe3.c();
        Interpolator localInterpolator2 = localFloatKeyframe3.d();
        if (localInterpolator2 != null)
          paramFloat = localInterpolator2.getInterpolation(paramFloat);
        float f9 = (paramFloat - f7) / (f8 - f7);
        if (this.f == null)
          f1 = f5 + f9 * (f6 - f5);
        else
          f1 = ((Number)this.f.a(f9, Float.valueOf(f5), Float.valueOf(f6))).floatValue();
      }
      else
      {
        Keyframe.FloatKeyframe localFloatKeyframe1;
        for (Object localObject = (Keyframe.FloatKeyframe)this.e.get(0); ; localObject = localFloatKeyframe1)
        {
          if (k >= this.a)
            break label614;
          localFloatKeyframe1 = (Keyframe.FloatKeyframe)this.e.get(k);
          if (paramFloat < localFloatKeyframe1.c())
          {
            Interpolator localInterpolator1 = localFloatKeyframe1.d();
            if (localInterpolator1 != null)
              paramFloat = localInterpolator1.getInterpolation(paramFloat);
            float f2 = (paramFloat - ((Keyframe.FloatKeyframe)localObject).c()) / (localFloatKeyframe1.c() - ((Keyframe.FloatKeyframe)localObject).c());
            float f3 = ((Keyframe.FloatKeyframe)localObject).g();
            float f4 = localFloatKeyframe1.g();
            if (this.f == null)
            {
              f1 = f3 + f2 * (f4 - f3);
              break;
            }
            f1 = ((Number)this.f.a(f2, Float.valueOf(f3), Float.valueOf(f4))).floatValue();
            break;
          }
          k++;
        }
        label614: f1 = ((Number)((Keyframe)this.e.get(-1 + this.a)).b()).floatValue();
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.FloatKeyframeSet
 * JD-Core Version:    0.6.2
 */