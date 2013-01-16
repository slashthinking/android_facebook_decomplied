package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class ViewPropertyAnimatorPreHC$AnimatorEventListener
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private ViewPropertyAnimatorPreHC$AnimatorEventListener(ViewPropertyAnimatorPreHC paramViewPropertyAnimatorPreHC)
  {
  }

  public void a(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorPreHC.b(this.a) != null)
      ViewPropertyAnimatorPreHC.b(this.a).a(paramAnimator);
    ViewPropertyAnimatorPreHC.c(this.a).remove(paramAnimator);
    if (ViewPropertyAnimatorPreHC.c(this.a).isEmpty())
      ViewPropertyAnimatorPreHC.a(this.a, null);
  }

  public void a(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.p();
    ViewPropertyAnimatorPreHC.PropertyBundle localPropertyBundle = (ViewPropertyAnimatorPreHC.PropertyBundle)ViewPropertyAnimatorPreHC.c(this.a).get(paramValueAnimator);
    if ((0x1FF & localPropertyBundle.a) != 0)
    {
      View localView2 = (View)ViewPropertyAnimatorPreHC.d(this.a).get();
      if (localView2 != null)
        localView2.invalidate();
    }
    ArrayList localArrayList = localPropertyBundle.b;
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      for (int j = 0; j < i; j++)
      {
        ViewPropertyAnimatorPreHC.NameValuesHolder localNameValuesHolder = (ViewPropertyAnimatorPreHC.NameValuesHolder)localArrayList.get(j);
        float f2 = localNameValuesHolder.b + f1 * localNameValuesHolder.c;
        ViewPropertyAnimatorPreHC.a(this.a, localNameValuesHolder.a, f2);
      }
    }
    View localView1 = (View)ViewPropertyAnimatorPreHC.d(this.a).get();
    if (localView1 != null)
      localView1.invalidate();
  }

  public void b(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorPreHC.b(this.a) != null)
      ViewPropertyAnimatorPreHC.b(this.a).b(paramAnimator);
  }

  public void c(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorPreHC.b(this.a) != null)
      ViewPropertyAnimatorPreHC.b(this.a).c(paramAnimator);
  }

  public void d(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorPreHC.b(this.a) != null)
      ViewPropertyAnimatorPreHC.b(this.a).d(paramAnimator);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorPreHC.AnimatorEventListener
 * JD-Core Version:    0.6.2
 */