package com.nineoldandroids.view;

import android.os.Build.VERSION;
import android.view.View;
import com.nineoldandroids.animation.Animator.AnimatorListener;

public abstract class ViewPropertyAnimator
{
  public static ViewPropertyAnimator a(View paramView)
  {
    int i = Integer.valueOf(Build.VERSION.SDK).intValue();
    Object localObject;
    if (i >= 14)
      localObject = new ViewPropertyAnimatorICS(paramView);
    while (true)
    {
      return localObject;
      if (i >= 11)
        localObject = new ViewPropertyAnimatorHC(paramView);
      else
        localObject = new ViewPropertyAnimatorPreHC(paramView);
    }
  }

  public abstract ViewPropertyAnimator a(float paramFloat);

  public abstract ViewPropertyAnimator a(long paramLong);

  public abstract ViewPropertyAnimator a(Animator.AnimatorListener paramAnimatorListener);

  public abstract void a();

  public abstract ViewPropertyAnimator b(float paramFloat);

  public abstract ViewPropertyAnimator c(float paramFloat);

  public abstract ViewPropertyAnimator d(float paramFloat);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimator
 * JD-Core Version:    0.6.2
 */