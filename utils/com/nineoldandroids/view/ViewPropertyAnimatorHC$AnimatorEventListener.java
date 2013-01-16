package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class ViewPropertyAnimatorHC$AnimatorEventListener
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private ViewPropertyAnimatorHC$AnimatorEventListener(ViewPropertyAnimatorHC paramViewPropertyAnimatorHC)
  {
  }

  public void a(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorHC.b(this.a) != null)
      ViewPropertyAnimatorHC.b(this.a).a(paramAnimator);
    ViewPropertyAnimatorHC.c(this.a).remove(paramAnimator);
    if (ViewPropertyAnimatorHC.c(this.a).isEmpty())
      ViewPropertyAnimatorHC.a(this.a, null);
  }

  public void a(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.p();
    ViewPropertyAnimatorHC.PropertyBundle localPropertyBundle = (ViewPropertyAnimatorHC.PropertyBundle)ViewPropertyAnimatorHC.c(this.a).get(paramValueAnimator);
    if ((0x1FF & localPropertyBundle.a) != 0)
    {
      View localView2 = (View)ViewPropertyAnimatorHC.d(this.a).get();
      if (localView2 != null)
        localView2.invalidate();
    }
    ArrayList localArrayList = localPropertyBundle.b;
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      for (int j = 0; j < i; j++)
      {
        ViewPropertyAnimatorHC.NameValuesHolder localNameValuesHolder = (ViewPropertyAnimatorHC.NameValuesHolder)localArrayList.get(j);
        float f2 = localNameValuesHolder.b + f1 * localNameValuesHolder.c;
        ViewPropertyAnimatorHC.a(this.a, localNameValuesHolder.a, f2);
      }
    }
    View localView1 = (View)ViewPropertyAnimatorHC.d(this.a).get();
    if (localView1 != null)
      localView1.invalidate();
  }

  public void b(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorHC.b(this.a) != null)
      ViewPropertyAnimatorHC.b(this.a).b(paramAnimator);
  }

  public void c(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorHC.b(this.a) != null)
      ViewPropertyAnimatorHC.b(this.a).c(paramAnimator);
  }

  public void d(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorHC.b(this.a) != null)
      ViewPropertyAnimatorHC.b(this.a).d(paramAnimator);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorHC.AnimatorEventListener
 * JD-Core Version:    0.6.2
 */