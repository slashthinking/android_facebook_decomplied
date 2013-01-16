package com.nineoldandroids.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ValueAnimator extends Animator
{
  private static ThreadLocal<ValueAnimator.AnimationHandler> h = new ThreadLocal();
  private static final ThreadLocal<ArrayList<ValueAnimator>> i = new ValueAnimator.1();
  private static final ThreadLocal<ArrayList<ValueAnimator>> j = new ValueAnimator.2();
  private static final ThreadLocal<ArrayList<ValueAnimator>> k = new ValueAnimator.3();
  private static final ThreadLocal<ArrayList<ValueAnimator>> l = new ValueAnimator.4();
  private static final ThreadLocal<ArrayList<ValueAnimator>> m = new ValueAnimator.5();
  private static final Interpolator n = new AccelerateDecelerateInterpolator();
  private static final TypeEvaluator o = new IntEvaluator();
  private static final TypeEvaluator p = new FloatEvaluator();
  private static long z = 10L;
  private int A = 0;
  private int B = 1;
  private Interpolator C = n;
  private ArrayList<ValueAnimator.AnimatorUpdateListener> D = null;
  long b;
  long c = -1L;
  int d = 0;
  boolean e = false;
  PropertyValuesHolder[] f;
  HashMap<String, PropertyValuesHolder> g;
  private boolean q = false;
  private int r = 0;
  private float s = 0.0F;
  private boolean t = false;
  private long u;
  private boolean v = false;
  private boolean w = false;
  private long x = 300L;
  private long y = 0L;

  public static ValueAnimator a(TypeEvaluator paramTypeEvaluator, Object[] paramArrayOfObject)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.a(paramArrayOfObject);
    localValueAnimator.a(paramTypeEvaluator);
    return localValueAnimator;
  }

  private void a()
  {
    ((ArrayList)i.get()).remove(this);
    ((ArrayList)j.get()).remove(this);
    ((ArrayList)k.get()).remove(this);
    this.d = 0;
    if ((this.v) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i1 = localArrayList.size();
      for (int i2 = 0; i2 < i1; i2++)
        ((Animator.AnimatorListener)localArrayList.get(i2)).a(this);
    }
    this.v = false;
    this.w = false;
  }

  private void a(boolean paramBoolean)
  {
    if (Looper.myLooper() == null)
      throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    this.q = paramBoolean;
    this.r = 0;
    this.d = 0;
    this.w = true;
    this.t = false;
    ((ArrayList)j.get()).add(this);
    if (this.y == 0L)
    {
      e(n());
      this.d = 0;
      this.v = true;
      if (this.a != null)
      {
        ArrayList localArrayList = (ArrayList)this.a.clone();
        int i1 = localArrayList.size();
        for (int i2 = 0; i2 < i1; i2++)
          ((Animator.AnimatorListener)localArrayList.get(i2)).b(this);
      }
    }
    ValueAnimator.AnimationHandler localAnimationHandler = (ValueAnimator.AnimationHandler)h.get();
    if (localAnimationHandler == null)
    {
      localAnimationHandler = new ValueAnimator.AnimationHandler(null);
      h.set(localAnimationHandler);
    }
    localAnimationHandler.sendEmptyMessage(0);
  }

  public static ValueAnimator b(float[] paramArrayOfFloat)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.a(paramArrayOfFloat);
    return localValueAnimator;
  }

  private boolean d(long paramLong)
  {
    int i1 = 1;
    if (!this.t)
    {
      this.t = i1;
      this.u = paramLong;
      i1 = 0;
    }
    while (true)
    {
      return i1;
      long l1 = paramLong - this.u;
      if (l1 <= this.y)
        break;
      this.b = (paramLong - (l1 - this.y));
      this.d = i1;
    }
  }

  private void h()
  {
    c_();
    ((ArrayList)i.get()).add(this);
    if ((this.y > 0L) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i1 = localArrayList.size();
      for (int i2 = 0; i2 < i1; i2++)
        ((Animator.AnimatorListener)localArrayList.get(i2)).b(this);
    }
  }

  void a(float paramFloat)
  {
    float f1 = this.C.getInterpolation(paramFloat);
    this.s = f1;
    int i1 = this.f.length;
    for (int i2 = 0; i2 < i1; i2++)
      this.f[i2].a(f1);
    if (this.D != null)
    {
      int i3 = this.D.size();
      for (int i4 = 0; i4 < i3; i4++)
        ((ValueAnimator.AnimatorUpdateListener)this.D.get(i4)).a(this);
    }
  }

  public void a(long paramLong)
  {
    this.y = paramLong;
  }

  public void a(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null);
    for (this.C = paramInterpolator; ; this.C = new LinearInterpolator())
      return;
  }

  public void a(TypeEvaluator paramTypeEvaluator)
  {
    if ((paramTypeEvaluator != null) && (this.f != null) && (this.f.length > 0))
      this.f[0].a(paramTypeEvaluator);
  }

  public void a(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (this.D == null)
      this.D = new ArrayList();
    this.D.add(paramAnimatorUpdateListener);
  }

  public void a(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
      return;
    if ((this.f == null) || (this.f.length == 0))
    {
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.a("", paramArrayOfFloat);
      a(arrayOfPropertyValuesHolder);
    }
    while (true)
    {
      this.e = false;
      break;
      this.f[0].a(paramArrayOfFloat);
    }
  }

  public void a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      return;
    if ((this.f == null) || (this.f.length == 0))
    {
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.a("", paramArrayOfInt);
      a(arrayOfPropertyValuesHolder);
    }
    while (true)
    {
      this.e = false;
      break;
      this.f[0].a(paramArrayOfInt);
    }
  }

  public void a(PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    int i1 = paramArrayOfPropertyValuesHolder.length;
    this.f = paramArrayOfPropertyValuesHolder;
    this.g = new HashMap(i1);
    for (int i2 = 0; i2 < i1; i2++)
    {
      PropertyValuesHolder localPropertyValuesHolder = paramArrayOfPropertyValuesHolder[i2];
      this.g.put(localPropertyValuesHolder.c(), localPropertyValuesHolder);
    }
    this.e = false;
  }

  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
      return;
    if ((this.f == null) || (this.f.length == 0))
    {
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.a("", (TypeEvaluator)null, paramArrayOfObject);
      a(arrayOfPropertyValuesHolder);
    }
    while (true)
    {
      this.e = false;
      break;
      this.f[0].a(paramArrayOfObject);
    }
  }

  public ValueAnimator b(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.x = paramLong;
    return this;
  }

  public void c()
  {
    a(false);
  }

  void c_()
  {
    if (!this.e)
    {
      int i1 = this.f.length;
      for (int i2 = 0; i2 < i1; i2++)
        this.f[i2].b();
      this.e = true;
    }
  }

  public void d()
  {
    if ((this.d != 0) || (((ArrayList)j.get()).contains(this)) || (((ArrayList)k.get()).contains(this)))
    {
      if ((this.v) && (this.a != null))
      {
        Iterator localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext())
          ((Animator.AnimatorListener)localIterator.next()).c(this);
      }
      a();
    }
  }

  public void e()
  {
    if ((!((ArrayList)i.get()).contains(this)) && (!((ArrayList)j.get()).contains(this)))
    {
      this.t = false;
      h();
      if ((this.A <= 0) || ((0x1 & this.A) != 1))
        break label82;
      a(0.0F);
    }
    while (true)
    {
      a();
      return;
      if (this.e)
        break;
      c_();
      break;
      label82: a(1.0F);
    }
  }

  public void e(long paramLong)
  {
    c_();
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if (this.d != 1)
    {
      this.c = paramLong;
      this.d = 2;
    }
    this.b = (l1 - paramLong);
    f(l1);
  }

  public boolean f()
  {
    int i1 = 1;
    if ((this.d == i1) || (this.v));
    while (true)
    {
      return i1;
      int i2 = 0;
    }
  }

  boolean f(long paramLong)
  {
    if (this.d == 0)
    {
      this.d = 1;
      if (this.c >= 0L)
        break label59;
      this.b = paramLong;
    }
    boolean bool1;
    while (true)
    {
      int i1 = this.d;
      bool1 = false;
      switch (i1)
      {
      default:
        return bool1;
        label59: this.b = (paramLong - this.c);
        this.c = -1L;
      case 1:
      case 2:
      }
    }
    float f1;
    if (this.x > 0L)
      f1 = (float)(paramLong - this.b) / (float)this.x;
    boolean bool2;
    label203: float f2;
    while (true)
      if (f1 >= 1.0F)
        if ((this.r < this.A) || (this.A == -1))
        {
          if (this.a != null)
          {
            int i2 = this.a.size();
            int i3 = 0;
            while (true)
              if (i3 < i2)
              {
                ((Animator.AnimatorListener)this.a.get(i3)).d(this);
                i3++;
                continue;
                f1 = 1.0F;
                break;
              }
          }
          if (this.B == 2)
          {
            if (this.q)
            {
              bool2 = false;
              this.q = bool2;
            }
          }
          else
          {
            this.r += (int)f1;
            f2 = f1 % 1.0F;
            this.b += this.x;
          }
        }
    while (true)
    {
      if (this.q)
        f2 = 1.0F - f2;
      a(f2);
      break;
      bool2 = true;
      break label203;
      f2 = Math.min(f1, 1.0F);
      bool1 = true;
      continue;
      f2 = f1;
      bool1 = false;
    }
  }

  public boolean g()
  {
    return this.w;
  }

  public ValueAnimator i()
  {
    int i1 = 0;
    ValueAnimator localValueAnimator = (ValueAnimator)super.j();
    if (this.D != null)
    {
      ArrayList localArrayList = this.D;
      localValueAnimator.D = new ArrayList();
      int i3 = localArrayList.size();
      for (int i4 = 0; i4 < i3; i4++)
        localValueAnimator.D.add(localArrayList.get(i4));
    }
    localValueAnimator.c = -1L;
    localValueAnimator.q = false;
    localValueAnimator.r = 0;
    localValueAnimator.e = false;
    localValueAnimator.d = 0;
    localValueAnimator.t = false;
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = this.f;
    if (arrayOfPropertyValuesHolder != null)
    {
      int i2 = arrayOfPropertyValuesHolder.length;
      localValueAnimator.f = new PropertyValuesHolder[i2];
      localValueAnimator.g = new HashMap(i2);
      while (i1 < i2)
      {
        PropertyValuesHolder localPropertyValuesHolder = arrayOfPropertyValuesHolder[i1].a();
        localValueAnimator.f[i1] = localPropertyValuesHolder;
        localValueAnimator.g.put(localPropertyValuesHolder.c(), localPropertyValuesHolder);
        i1++;
      }
    }
    return localValueAnimator;
  }

  public long n()
  {
    if ((!this.e) || (this.d == 0));
    for (long l1 = 0L; ; l1 = AnimationUtils.currentAnimationTimeMillis() - this.b)
      return l1;
  }

  public Object o()
  {
    if ((this.f != null) && (this.f.length > 0));
    for (Object localObject = this.f[0].d(); ; localObject = null)
      return localObject;
  }

  public float p()
  {
    return this.s;
  }

  public String toString()
  {
    String str = "ValueAnimator@" + Integer.toHexString(hashCode());
    if (this.f != null)
      for (int i1 = 0; i1 < this.f.length; i1++)
        str = str + "\n    " + this.f[i1].toString();
    return str;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.ValueAnimator
 * JD-Core Version:    0.6.2
 */