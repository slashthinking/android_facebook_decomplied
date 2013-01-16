package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorICS extends ViewPropertyAnimator
{
  private final WeakReference<android.view.ViewPropertyAnimator> a;

  ViewPropertyAnimatorICS(View paramView)
  {
    this.a = new WeakReference(paramView.animate());
  }

  public ViewPropertyAnimator a(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.translationY(paramFloat);
    return this;
  }

  public ViewPropertyAnimator a(long paramLong)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.setDuration(paramLong);
    return this;
  }

  public ViewPropertyAnimator a(Animator.AnimatorListener paramAnimatorListener)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
    {
      if (paramAnimatorListener != null)
        break label27;
      localViewPropertyAnimator.setListener(null);
    }
    while (true)
    {
      return this;
      label27: localViewPropertyAnimator.setListener(new ViewPropertyAnimatorICS.1(this, paramAnimatorListener));
    }
  }

  public void a()
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.cancel();
  }

  public ViewPropertyAnimator b(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.scaleX(paramFloat);
    return this;
  }

  public ViewPropertyAnimator c(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.scaleY(paramFloat);
    return this;
  }

  public ViewPropertyAnimator d(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.alpha(paramFloat);
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorICS
 * JD-Core Version:    0.6.2
 */