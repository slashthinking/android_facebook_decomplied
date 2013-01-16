package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet
{
  private int g;
  private int h;
  private int i;
  private boolean j = true;

  public IntKeyframeSet(Keyframe.IntKeyframe[] paramArrayOfIntKeyframe)
  {
    super(paramArrayOfIntKeyframe);
  }

  public IntKeyframeSet a()
  {
    ArrayList localArrayList = this.e;
    int k = this.e.size();
    Keyframe.IntKeyframe[] arrayOfIntKeyframe = new Keyframe.IntKeyframe[k];
    for (int m = 0; m < k; m++)
      arrayOfIntKeyframe[m] = ((Keyframe.IntKeyframe)((Keyframe)localArrayList.get(m)).f());
    return new IntKeyframeSet(arrayOfIntKeyframe);
  }

  public Object a(float paramFloat)
  {
    return Integer.valueOf(b(paramFloat));
  }

  public int b(float paramFloat)
  {
    int k = 1;
    int m;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((Keyframe.IntKeyframe)this.e.get(0)).g();
        this.h = ((Keyframe.IntKeyframe)this.e.get(k)).g();
        this.i = (this.h - this.g);
      }
      if (this.d != null)
        paramFloat = this.d.getInterpolation(paramFloat);
      if (this.f == null)
        m = this.g + (int)(paramFloat * this.i);
    }
    while (true)
    {
      return m;
      m = ((Number)this.f.a(paramFloat, Integer.valueOf(this.g), Integer.valueOf(this.h))).intValue();
      continue;
      if (paramFloat <= 0.0F)
      {
        Keyframe.IntKeyframe localIntKeyframe4 = (Keyframe.IntKeyframe)this.e.get(0);
        Keyframe.IntKeyframe localIntKeyframe5 = (Keyframe.IntKeyframe)this.e.get(k);
        int i4 = localIntKeyframe4.g();
        int i5 = localIntKeyframe5.g();
        float f5 = localIntKeyframe4.c();
        float f6 = localIntKeyframe5.c();
        Interpolator localInterpolator3 = localIntKeyframe5.d();
        if (localInterpolator3 != null)
          paramFloat = localInterpolator3.getInterpolation(paramFloat);
        float f7 = (paramFloat - f5) / (f6 - f5);
        if (this.f == null)
          m = i4 + (int)(f7 * (i5 - i4));
        else
          m = ((Number)this.f.a(f7, Integer.valueOf(i4), Integer.valueOf(i5))).intValue();
      }
      else if (paramFloat >= 1.0F)
      {
        Keyframe.IntKeyframe localIntKeyframe2 = (Keyframe.IntKeyframe)this.e.get(-2 + this.a);
        Keyframe.IntKeyframe localIntKeyframe3 = (Keyframe.IntKeyframe)this.e.get(-1 + this.a);
        int i2 = localIntKeyframe2.g();
        int i3 = localIntKeyframe3.g();
        float f2 = localIntKeyframe2.c();
        float f3 = localIntKeyframe3.c();
        Interpolator localInterpolator2 = localIntKeyframe3.d();
        if (localInterpolator2 != null)
          paramFloat = localInterpolator2.getInterpolation(paramFloat);
        float f4 = (paramFloat - f2) / (f3 - f2);
        if (this.f == null)
          m = i2 + (int)(f4 * (i3 - i2));
        else
          m = ((Number)this.f.a(f4, Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
      }
      else
      {
        Keyframe.IntKeyframe localIntKeyframe1;
        for (Object localObject = (Keyframe.IntKeyframe)this.e.get(0); ; localObject = localIntKeyframe1)
        {
          if (k >= this.a)
            break label622;
          localIntKeyframe1 = (Keyframe.IntKeyframe)this.e.get(k);
          if (paramFloat < localIntKeyframe1.c())
          {
            Interpolator localInterpolator1 = localIntKeyframe1.d();
            if (localInterpolator1 != null)
              paramFloat = localInterpolator1.getInterpolation(paramFloat);
            float f1 = (paramFloat - ((Keyframe.IntKeyframe)localObject).c()) / (localIntKeyframe1.c() - ((Keyframe.IntKeyframe)localObject).c());
            int n = ((Keyframe.IntKeyframe)localObject).g();
            int i1 = localIntKeyframe1.g();
            if (this.f == null)
            {
              m = n + (int)(f1 * (i1 - n));
              break;
            }
            m = ((Number)this.f.a(f1, Integer.valueOf(n), Integer.valueOf(i1))).intValue();
            break;
          }
          k++;
        }
        label622: m = ((Number)((Keyframe)this.e.get(-1 + this.a)).b()).intValue();
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.IntKeyframeSet
 * JD-Core Version:    0.6.2
 */