package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class ViewPropertyAnimatorPreHC extends ViewPropertyAnimator
{
  ArrayList<ViewPropertyAnimatorPreHC.NameValuesHolder> a = new ArrayList();
  private final AnimatorProxy b;
  private final WeakReference<View> c;
  private long d;
  private boolean e = false;
  private long f = 0L;
  private boolean g = false;
  private Interpolator h;
  private boolean i = false;
  private Animator.AnimatorListener j = null;
  private ViewPropertyAnimatorPreHC.AnimatorEventListener k = new ViewPropertyAnimatorPreHC.AnimatorEventListener(this, null);
  private Runnable l = new ViewPropertyAnimatorPreHC.1(this);
  private HashMap<Animator, ViewPropertyAnimatorPreHC.PropertyBundle> m = new HashMap();

  ViewPropertyAnimatorPreHC(View paramView)
  {
    this.c = new WeakReference(paramView);
    this.b = AnimatorProxy.a(paramView);
  }

  private float a(int paramInt)
  {
    float f1;
    switch (paramInt)
    {
    default:
      f1 = 0.0F;
    case 1:
    case 2:
    case 16:
    case 32:
    case 64:
    case 4:
    case 8:
    case 128:
    case 256:
    case 512:
    }
    while (true)
    {
      return f1;
      f1 = this.b.getTranslationX();
      continue;
      f1 = this.b.getTranslationY();
      continue;
      f1 = this.b.getRotation();
      continue;
      f1 = this.b.getRotationX();
      continue;
      f1 = this.b.getRotationY();
      continue;
      f1 = this.b.getScaleX();
      continue;
      f1 = this.b.getScaleY();
      continue;
      f1 = this.b.getX();
      continue;
      f1 = this.b.getY();
      continue;
      f1 = this.b.getAlpha();
    }
  }

  private void a(int paramInt, float paramFloat)
  {
    float f1 = a(paramInt);
    a(paramInt, f1, paramFloat - f1);
  }

  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Animator localAnimator;
    if (this.m.size() > 0)
    {
      Iterator localIterator = this.m.keySet().iterator();
      ViewPropertyAnimatorPreHC.PropertyBundle localPropertyBundle;
      do
      {
        if (!localIterator.hasNext())
          break;
        localAnimator = (Animator)localIterator.next();
        localPropertyBundle = (ViewPropertyAnimatorPreHC.PropertyBundle)this.m.get(localAnimator);
      }
      while ((!localPropertyBundle.a(paramInt)) || (localPropertyBundle.a != 0));
    }
    while (true)
    {
      if (localAnimator != null)
        localAnimator.d();
      ViewPropertyAnimatorPreHC.NameValuesHolder localNameValuesHolder = new ViewPropertyAnimatorPreHC.NameValuesHolder(paramInt, paramFloat1, paramFloat2);
      this.a.add(localNameValuesHolder);
      View localView = (View)this.c.get();
      if (localView != null)
      {
        localView.removeCallbacks(this.l);
        localView.post(this.l);
      }
      return;
      localAnimator = null;
    }
  }

  private void b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.b(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.a.clone();
    this.a.clear();
    int n = localArrayList.size();
    int i1 = 0;
    int i2 = 0;
    while (i1 < n)
    {
      i2 |= ((ViewPropertyAnimatorPreHC.NameValuesHolder)localArrayList.get(i1)).a;
      i1++;
    }
    this.m.put(localValueAnimator, new ViewPropertyAnimatorPreHC.PropertyBundle(i2, localArrayList));
    localValueAnimator.a(this.k);
    localValueAnimator.a(this.k);
    if (this.g)
      localValueAnimator.a(this.f);
    if (this.e)
      localValueAnimator.b(this.d);
    if (this.i)
      localValueAnimator.a(this.h);
    localValueAnimator.c();
  }

  private void b(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    case 16:
    case 32:
    case 64:
    case 4:
    case 8:
    case 128:
    case 256:
    case 512:
    }
    while (true)
    {
      return;
      this.b.setTranslationX(paramFloat);
      continue;
      this.b.setTranslationY(paramFloat);
      continue;
      this.b.setRotation(paramFloat);
      continue;
      this.b.setRotationX(paramFloat);
      continue;
      this.b.setRotationY(paramFloat);
      continue;
      this.b.setScaleX(paramFloat);
      continue;
      this.b.setScaleY(paramFloat);
      continue;
      this.b.setX(paramFloat);
      continue;
      this.b.setY(paramFloat);
      continue;
      this.b.setAlpha(paramFloat);
    }
  }

  public ViewPropertyAnimator a(float paramFloat)
  {
    a(2, paramFloat);
    return this;
  }

  public ViewPropertyAnimator a(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.e = true;
    this.d = paramLong;
    return this;
  }

  public ViewPropertyAnimator a(Animator.AnimatorListener paramAnimatorListener)
  {
    this.j = paramAnimatorListener;
    return this;
  }

  public void a()
  {
    if (this.m.size() > 0)
    {
      Iterator localIterator = ((HashMap)this.m.clone()).keySet().iterator();
      while (localIterator.hasNext())
        ((Animator)localIterator.next()).d();
    }
    this.a.clear();
    View localView = (View)this.c.get();
    if (localView != null)
      localView.removeCallbacks(this.l);
  }

  public ViewPropertyAnimator b(float paramFloat)
  {
    a(4, paramFloat);
    return this;
  }

  public ViewPropertyAnimator c(float paramFloat)
  {
    a(8, paramFloat);
    return this;
  }

  public ViewPropertyAnimator d(float paramFloat)
  {
    a(512, paramFloat);
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorPreHC
 * JD-Core Version:    0.6.2
 */