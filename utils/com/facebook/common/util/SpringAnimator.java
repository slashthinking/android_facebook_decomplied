package com.facebook.common.util;

import android.view.View;
import android.view.animation.Interpolator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.TypeEvaluator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.nineoldandroids.view.ViewHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

public class SpringAnimator extends ValueAnimator
{
  private static final HashSet<String> h = Sets.a(new String[] { "alpha", "pivotX", "pivotY", "translationX", "translationY", "rotation", "rotationX", "rotationY", "scaleX", "scaleY", "scrollX", "scrollY", "x", "y" });
  private final ValueAnimator.AnimatorUpdateListener i = new SpringAnimator.1(this);
  private final ObjectAnimator j;
  private float k = 0.1F;
  private float l = 0.7F;
  private float m = 0.01F;
  private float n = 0.6F;
  private float o = 0.0F;
  private Method p;
  private Class q;
  private boolean r = false;
  private Number s;
  private Number t;
  private float u;
  private long v;
  private int w;
  private ImmutableList<ValueAnimator.AnimatorUpdateListener> x = ImmutableList.d();
  private boolean y;

  private SpringAnimator(ObjectAnimator paramObjectAnimator)
  {
    this.j = paramObjectAnimator;
    this.j.a(new SpringAnimator.SpringInterpolator(this, null));
    m();
  }

  private Number A()
  {
    Object localObject = x();
    Method localMethod = b(localObject, y());
    Number localNumber;
    try
    {
      if (z())
        localNumber = (Number)localMethod.invoke(ViewHelper.class, new Object[] { localObject });
      else
        localNumber = (Number)localMethod.invoke(localObject, new Object[0]);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new RuntimeException("Error occurred invoking " + localMethod.getName() + " on " + x().getClass().getName());
    }
    return localNumber;
  }

  public static SpringAnimator a(Object paramObject, String paramString, float paramFloat)
  {
    SpringAnimator localSpringAnimator = new SpringAnimator(a(paramObject, paramString));
    localSpringAnimator.a(Float.valueOf(paramFloat));
    return localSpringAnimator;
  }

  public static SpringAnimator a(Object paramObject, String paramString, int paramInt)
  {
    SpringAnimator localSpringAnimator = new SpringAnimator(a(paramObject, paramString));
    localSpringAnimator.a(Integer.valueOf(paramInt));
    return localSpringAnimator;
  }

  private static ObjectAnimator a(Object paramObject, String paramString)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.a(paramObject);
    localObjectAnimator.a(paramString);
    return localObjectAnimator;
  }

  private Method b(Object paramObject, String paramString)
  {
    String str2;
    boolean bool;
    Object localObject;
    if (this.p == null)
    {
      char c = Character.toUpperCase(paramString.charAt(0));
      String str1 = paramString.substring(1);
      str2 = "get" + c + str1;
      bool = z();
      if (!bool)
        break label94;
      localObject = ViewHelper.class;
    }
    while (true)
    {
      if (bool);
      try
      {
        for (this.p = ((Class)localObject).getMethod(str2, new Class[] { View.class }); ; this.p = ((Class)localObject).getMethod(str2, new Class[0]))
        {
          return this.p;
          label94: localObject = paramObject.getClass();
          break;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    throw new RuntimeException("No getter found for " + ((Class)localObject).getName() + ":" + paramString);
  }

  private void m()
  {
    this.j.a(new SpringAnimator.2(this));
  }

  private void w()
  {
    this.j.a(this.i);
  }

  private Object x()
  {
    return this.j.h();
  }

  private String y()
  {
    return this.j.a();
  }

  private boolean z()
  {
    if (((x() instanceof View)) && (h.contains(y())));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public float a()
  {
    return this.t.floatValue();
  }

  public SpringAnimator a(Float paramFloat)
  {
    this.q = Float.class;
    this.t = paramFloat;
    if (g())
    {
      this.s = A();
      ObjectAnimator localObjectAnimator = this.j;
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = ((Float)this.s).floatValue();
      arrayOfFloat[1] = ((Float)this.t).floatValue();
      localObjectAnimator.a(arrayOfFloat);
      this.j.d(2147483647L);
    }
    return this;
  }

  public SpringAnimator a(Integer paramInteger)
  {
    this.q = Integer.class;
    this.t = paramInteger;
    if (g())
    {
      this.s = A();
      ObjectAnimator localObjectAnimator = this.j;
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = ((Integer)this.s).intValue();
      arrayOfInt[1] = ((Integer)this.t).intValue();
      localObjectAnimator.a(arrayOfInt);
      this.j.d(2147483647L);
    }
    return this;
  }

  public void a(long paramLong)
  {
    this.j.a(paramLong);
  }

  public void a(Interpolator paramInterpolator)
  {
    throw new UnsupportedOperationException("setInterpolator is not supported for SpringAnimator");
  }

  public void a(TypeEvaluator paramTypeEvaluator)
  {
    this.j.a(paramTypeEvaluator);
  }

  public void a(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    Preconditions.checkNotNull(paramAnimatorUpdateListener);
    if (this.x.contains(paramAnimatorUpdateListener));
    while (true)
    {
      return;
      if (this.x.isEmpty())
        w();
      ImmutableList.Builder localBuilder = ImmutableList.e();
      localBuilder.b(this.x);
      localBuilder.b(paramAnimatorUpdateListener);
      this.x = localBuilder.b();
    }
  }

  public void a(Object paramObject)
  {
    this.j.a(paramObject);
  }

  public int b()
  {
    return this.t.intValue();
  }

  public ValueAnimator b(long paramLong)
  {
    throw new UnsupportedOperationException("setDuration is not supported for SpringAnimator");
  }

  public void c()
  {
    this.v = 0L;
    this.w = 0;
    if (!this.r)
      this.s = A();
    this.u = this.s.floatValue();
    if (this.q == Integer.class)
    {
      ObjectAnimator localObjectAnimator2 = this.j;
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = ((Integer)this.s).intValue();
      arrayOfInt[1] = ((Integer)this.t).intValue();
      localObjectAnimator2.a(arrayOfInt);
    }
    while (true)
    {
      this.j.c();
      return;
      ObjectAnimator localObjectAnimator1 = this.j;
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = ((Float)this.s).floatValue();
      arrayOfFloat[1] = ((Float)this.t).floatValue();
      localObjectAnimator1.a(arrayOfFloat);
    }
  }

  public void d()
  {
    this.j.d();
    this.v = 0L;
    this.w = 0;
  }

  public void e()
  {
    this.j.e();
    this.v = 0L;
    this.w = 0;
  }

  public boolean f()
  {
    return this.j.f();
  }

  public boolean g()
  {
    return this.j.g();
  }

  public SpringAnimator h()
  {
    int i1 = 0;
    if (this.q == Float.class);
    for (SpringAnimator localSpringAnimator = a(x(), y(), a()); localSpringAnimator.k() != null; localSpringAnimator = a(x(), y(), b()))
    {
      ArrayList localArrayList = k();
      int i3 = localArrayList.size();
      for (int i4 = 0; i4 < i3; i4++)
        localSpringAnimator.a((Animator.AnimatorListener)localArrayList.get(i4));
    }
    int i2 = this.x.size();
    while (i1 < i2)
    {
      localSpringAnimator.a((ValueAnimator.AnimatorUpdateListener)this.x.get(i1));
      i1++;
    }
    return localSpringAnimator;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.SpringAnimator
 * JD-Core Version:    0.6.2
 */