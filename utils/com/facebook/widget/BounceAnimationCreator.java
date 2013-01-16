package com.facebook.widget;

import com.nineoldandroids.animation.Keyframe;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import java.util.ArrayList;

public class BounceAnimationCreator
{
  private static BounceAnimationCreator.OscillationData a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    BounceAnimationCreator.OscillationData localOscillationData = new BounceAnimationCreator.OscillationData(null);
    double d1 = Math.sqrt(paramDouble2 / paramDouble4);
    double d2 = paramDouble3 / Math.sqrt(paramDouble2 * (2.0D * paramDouble4));
    double d3 = d1 * Math.sqrt(1.0D - Math.pow(d2, 2.0D));
    double d4 = paramDouble5 + d1 * paramDouble1;
    localOscillationData.b = ((float)(-Math.log(0.01D / (paramDouble1 + d4)) / (d2 * d1)));
    double d5 = 2.0D * d3;
    double d6 = 1.0D / d5;
    int i = 1 + (int)Math.ceil(d5 * localOscillationData.b);
    localOscillationData.a = new Keyframe[i];
    int j = 0;
    for (double d7 = 0.0D; d7 < localOscillationData.b; d7 += d6)
    {
      double d8 = d3 * d7;
      double d9 = Math.exp(-(d7 * (d2 * d1))) * (paramDouble1 * Math.cos(d8) + d4 * Math.sin(d8));
      localOscillationData.a[j] = Keyframe.a((float)(d7 / localOscillationData.b), (float)d9);
      j++;
    }
    localOscillationData.a[(i - 1)] = Keyframe.a(1.0F, 0.0F);
    return localOscillationData;
  }

  private static ObjectAnimator a(BounceAnimationCreator.OscillationData paramOscillationData, Object paramObject, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramOscillationData.a.length; i++)
    {
      float f1 = paramOscillationData.a[i].c();
      float f2 = 1.0F + 0.6F * ((Float)paramOscillationData.a[i].b()).floatValue() * paramInt;
      if ((f1 >= 0.0F) && (f1 <= 0.508489F))
        localArrayList.add(Keyframe.a((f1 - 0.0F) / (0.508489F - 0.0F), f2));
    }
    ((Keyframe)localArrayList.get(-1 + localArrayList.size())).a(Float.valueOf(1.0F));
    long l = Math.round(0.5F * (1000.0F * (paramOscillationData.b - paramOscillationData.b * (0.508489F - 0.0F))));
    ObjectAnimator localObjectAnimator = ObjectAnimator.a(paramObject, new PropertyValuesHolder[] { PropertyValuesHolder.a("scaleX", (Keyframe[])localArrayList.toArray(new Keyframe[localArrayList.size()])), PropertyValuesHolder.a("scaleY", (Keyframe[])localArrayList.toArray(new Keyframe[localArrayList.size()])) });
    localObjectAnimator.d(l);
    return localObjectAnimator;
  }

  public static ObjectAnimator a(Object paramObject)
  {
    return a(a(0.1D, 10.0D, 0.9D, 0.1D, 0.2D), paramObject, 1);
  }

  public static ObjectAnimator b(Object paramObject)
  {
    return a(a(0.1D, 10.0D, 0.9D, 0.1D, 0.2D), paramObject, -1);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.BounceAnimationCreator
 * JD-Core Version:    0.6.2
 */