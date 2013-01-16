package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class ViewPropertyAnimatorHC extends ViewPropertyAnimator
{
  ArrayList<ViewPropertyAnimatorHC.NameValuesHolder> a = new ArrayList();
  private final WeakReference<View> b;
  private long c;
  private boolean d = false;
  private long e = 0L;
  private boolean f = false;
  private Interpolator g;
  private boolean h = false;
  private Animator.AnimatorListener i = null;
  private ViewPropertyAnimatorHC.AnimatorEventListener j = new ViewPropertyAnimatorHC.AnimatorEventListener(this, null);
  private Runnable k = new ViewPropertyAnimatorHC.1(this);
  private HashMap<Animator, ViewPropertyAnimatorHC.PropertyBundle> l = new HashMap();

  ViewPropertyAnimatorHC(View paramView)
  {
    this.b = new WeakReference(paramView);
  }

  private float a(int paramInt)
  {
    View localView = (View)this.b.get();
    if (localView != null);
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
      f1 = localView.getTranslationX();
      continue;
      f1 = localView.getTranslationY();
      continue;
      f1 = localView.getRotation();
      continue;
      f1 = localView.getRotationX();
      continue;
      f1 = localView.getRotationY();
      continue;
      f1 = localView.getScaleX();
      continue;
      f1 = localView.getScaleY();
      continue;
      f1 = localView.getX();
      continue;
      f1 = localView.getY();
      continue;
      f1 = localView.getAlpha();
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
    if (this.l.size() > 0)
    {
      Iterator localIterator = this.l.keySet().iterator();
      ViewPropertyAnimatorHC.PropertyBundle localPropertyBundle;
      do
      {
        if (!localIterator.hasNext())
          break;
        localAnimator = (Animator)localIterator.next();
        localPropertyBundle = (ViewPropertyAnimatorHC.PropertyBundle)this.l.get(localAnimator);
      }
      while ((!localPropertyBundle.a(paramInt)) || (localPropertyBundle.a != 0));
    }
    while (true)
    {
      if (localAnimator != null)
        localAnimator.d();
      ViewPropertyAnimatorHC.NameValuesHolder localNameValuesHolder = new ViewPropertyAnimatorHC.NameValuesHolder(paramInt, paramFloat1, paramFloat2);
      this.a.add(localNameValuesHolder);
      View localView = (View)this.b.get();
      if (localView != null)
      {
        localView.removeCallbacks(this.k);
        localView.post(this.k);
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
    int m = localArrayList.size();
    int n = 0;
    int i1 = 0;
    while (n < m)
    {
      i1 |= ((ViewPropertyAnimatorHC.NameValuesHolder)localArrayList.get(n)).a;
      n++;
    }
    this.l.put(localValueAnimator, new ViewPropertyAnimatorHC.PropertyBundle(i1, localArrayList));
    localValueAnimator.a(this.j);
    localValueAnimator.a(this.j);
    if (this.f)
      localValueAnimator.a(this.e);
    if (this.d)
      localValueAnimator.b(this.c);
    if (this.h)
      localValueAnimator.a(this.g);
    localValueAnimator.c();
  }

  private void b(int paramInt, float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null)
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
      localView.setTranslationX(paramFloat);
      continue;
      localView.setTranslationY(paramFloat);
      continue;
      localView.setRotation(paramFloat);
      continue;
      localView.setRotationX(paramFloat);
      continue;
      localView.setRotationY(paramFloat);
      continue;
      localView.setScaleX(paramFloat);
      continue;
      localView.setScaleY(paramFloat);
      continue;
      localView.setX(paramFloat);
      continue;
      localView.setY(paramFloat);
      continue;
      localView.setAlpha(paramFloat);
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
    this.d = true;
    this.c = paramLong;
    return this;
  }

  public ViewPropertyAnimator a(Animator.AnimatorListener paramAnimatorListener)
  {
    this.i = paramAnimatorListener;
    return this;
  }

  public void a()
  {
    if (this.l.size() > 0)
    {
      Iterator localIterator = ((HashMap)this.l.clone()).keySet().iterator();
      while (localIterator.hasNext())
        ((Animator)localIterator.next()).d();
    }
    this.a.clear();
    View localView = (View)this.b.get();
    if (localView != null)
      localView.removeCallbacks(this.k);
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
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorHC
 * JD-Core Version:    0.6.2
 */