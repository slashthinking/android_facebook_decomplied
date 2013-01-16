package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class KeyframeSet
{
  int a;
  Keyframe b;
  Keyframe c;
  Interpolator d;
  ArrayList<Keyframe> e;
  TypeEvaluator f;

  public KeyframeSet(Keyframe[] paramArrayOfKeyframe)
  {
    this.a = paramArrayOfKeyframe.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramArrayOfKeyframe));
    this.b = ((Keyframe)this.e.get(0));
    this.c = ((Keyframe)this.e.get(-1 + this.a));
    this.d = this.c.d();
  }

  public static KeyframeSet a(float[] paramArrayOfFloat)
  {
    int i = 1;
    int j = paramArrayOfFloat.length;
    Keyframe.FloatKeyframe[] arrayOfFloatKeyframe = new Keyframe.FloatKeyframe[Math.max(j, 2)];
    if (j == i)
    {
      arrayOfFloatKeyframe[0] = ((Keyframe.FloatKeyframe)Keyframe.b(0.0F));
      arrayOfFloatKeyframe[i] = ((Keyframe.FloatKeyframe)Keyframe.a(1.0F, paramArrayOfFloat[0]));
    }
    while (true)
    {
      return new FloatKeyframeSet(arrayOfFloatKeyframe);
      arrayOfFloatKeyframe[0] = ((Keyframe.FloatKeyframe)Keyframe.a(0.0F, paramArrayOfFloat[0]));
      while (i < j)
      {
        arrayOfFloatKeyframe[i] = ((Keyframe.FloatKeyframe)Keyframe.a(i / (j - 1), paramArrayOfFloat[i]));
        i++;
      }
    }
  }

  public static KeyframeSet a(int[] paramArrayOfInt)
  {
    int i = 1;
    int j = paramArrayOfInt.length;
    Keyframe.IntKeyframe[] arrayOfIntKeyframe = new Keyframe.IntKeyframe[Math.max(j, 2)];
    if (j == i)
    {
      arrayOfIntKeyframe[0] = ((Keyframe.IntKeyframe)Keyframe.a(0.0F));
      arrayOfIntKeyframe[i] = ((Keyframe.IntKeyframe)Keyframe.a(1.0F, paramArrayOfInt[0]));
    }
    while (true)
    {
      return new IntKeyframeSet(arrayOfIntKeyframe);
      arrayOfIntKeyframe[0] = ((Keyframe.IntKeyframe)Keyframe.a(0.0F, paramArrayOfInt[0]));
      while (i < j)
      {
        arrayOfIntKeyframe[i] = ((Keyframe.IntKeyframe)Keyframe.a(i / (j - 1), paramArrayOfInt[i]));
        i++;
      }
    }
  }

  public static KeyframeSet a(Keyframe[] paramArrayOfKeyframe)
  {
    int i = 0;
    int j = paramArrayOfKeyframe.length;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    if (k < j)
    {
      if ((paramArrayOfKeyframe[k] instanceof Keyframe.FloatKeyframe))
        i1 = 1;
      while (true)
      {
        k++;
        break;
        if ((paramArrayOfKeyframe[k] instanceof Keyframe.IntKeyframe))
          n = 1;
        else
          m = 1;
      }
    }
    Object localObject;
    if ((i1 != 0) && (n == 0) && (m == 0))
    {
      Keyframe.FloatKeyframe[] arrayOfFloatKeyframe = new Keyframe.FloatKeyframe[j];
      while (i < j)
      {
        arrayOfFloatKeyframe[i] = ((Keyframe.FloatKeyframe)paramArrayOfKeyframe[i]);
        i++;
      }
      localObject = new FloatKeyframeSet(arrayOfFloatKeyframe);
    }
    while (true)
    {
      return localObject;
      if ((n != 0) && (i1 == 0) && (m == 0))
      {
        Keyframe.IntKeyframe[] arrayOfIntKeyframe = new Keyframe.IntKeyframe[j];
        for (int i2 = 0; i2 < j; i2++)
          arrayOfIntKeyframe[i2] = ((Keyframe.IntKeyframe)paramArrayOfKeyframe[i2]);
        localObject = new IntKeyframeSet(arrayOfIntKeyframe);
      }
      else
      {
        localObject = new KeyframeSet(paramArrayOfKeyframe);
      }
    }
  }

  public static KeyframeSet a(Object[] paramArrayOfObject)
  {
    int i = 1;
    int j = paramArrayOfObject.length;
    Keyframe.ObjectKeyframe[] arrayOfObjectKeyframe = new Keyframe.ObjectKeyframe[Math.max(j, 2)];
    if (j == i)
    {
      arrayOfObjectKeyframe[0] = ((Keyframe.ObjectKeyframe)Keyframe.c(0.0F));
      arrayOfObjectKeyframe[i] = ((Keyframe.ObjectKeyframe)Keyframe.a(1.0F, paramArrayOfObject[0]));
    }
    while (true)
    {
      return new KeyframeSet(arrayOfObjectKeyframe);
      arrayOfObjectKeyframe[0] = ((Keyframe.ObjectKeyframe)Keyframe.a(0.0F, paramArrayOfObject[0]));
      while (i < j)
      {
        arrayOfObjectKeyframe[i] = ((Keyframe.ObjectKeyframe)Keyframe.a(i / (j - 1), paramArrayOfObject[i]));
        i++;
      }
    }
  }

  public Object a(float paramFloat)
  {
    Object localObject2;
    if (this.a == 2)
    {
      if (this.d != null)
        paramFloat = this.d.getInterpolation(paramFloat);
      localObject2 = this.f.a(paramFloat, this.b.b(), this.c.b());
    }
    while (true)
    {
      return localObject2;
      if (paramFloat <= 0.0F)
      {
        Keyframe localKeyframe3 = (Keyframe)this.e.get(1);
        Interpolator localInterpolator3 = localKeyframe3.d();
        if (localInterpolator3 != null)
          paramFloat = localInterpolator3.getInterpolation(paramFloat);
        float f5 = this.b.c();
        float f6 = (paramFloat - f5) / (localKeyframe3.c() - f5);
        localObject2 = this.f.a(f6, this.b.b(), localKeyframe3.b());
      }
      else if (paramFloat >= 1.0F)
      {
        Keyframe localKeyframe2 = (Keyframe)this.e.get(-2 + this.a);
        Interpolator localInterpolator2 = this.c.d();
        if (localInterpolator2 != null)
          paramFloat = localInterpolator2.getInterpolation(paramFloat);
        float f3 = localKeyframe2.c();
        float f4 = (paramFloat - f3) / (this.c.c() - f3);
        localObject2 = this.f.a(f4, localKeyframe2.b(), this.c.b());
      }
      else
      {
        Object localObject1 = this.b;
        int i = 1;
        while (true)
        {
          if (i >= this.a)
            break label361;
          Keyframe localKeyframe1 = (Keyframe)this.e.get(i);
          if (paramFloat < localKeyframe1.c())
          {
            Interpolator localInterpolator1 = localKeyframe1.d();
            if (localInterpolator1 != null)
              paramFloat = localInterpolator1.getInterpolation(paramFloat);
            float f1 = ((Keyframe)localObject1).c();
            float f2 = (paramFloat - f1) / (localKeyframe1.c() - f1);
            localObject2 = this.f.a(f2, ((Keyframe)localObject1).b(), localKeyframe1.b());
            break;
          }
          i++;
          localObject1 = localKeyframe1;
        }
        label361: localObject2 = this.c.b();
      }
    }
  }

  public void a(TypeEvaluator paramTypeEvaluator)
  {
    this.f = paramTypeEvaluator;
  }

  public KeyframeSet b()
  {
    ArrayList localArrayList = this.e;
    int i = this.e.size();
    Keyframe[] arrayOfKeyframe = new Keyframe[i];
    for (int j = 0; j < i; j++)
      arrayOfKeyframe[j] = ((Keyframe)localArrayList.get(j)).f();
    return new KeyframeSet(arrayOfKeyframe);
  }

  public String toString()
  {
    Object localObject = " ";
    int i = 0;
    while (i < this.a)
    {
      String str = (String)localObject + ((Keyframe)this.e.get(i)).b() + "  ";
      i++;
      localObject = str;
    }
    return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.KeyframeSet
 * JD-Core Version:    0.6.2
 */