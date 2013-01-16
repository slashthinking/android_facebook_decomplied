package com.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

class AnimatorSet$AnimatorSetListener
  implements Animator.AnimatorListener
{
  private AnimatorSet b;

  AnimatorSet$AnimatorSetListener(AnimatorSet paramAnimatorSet1, AnimatorSet paramAnimatorSet2)
  {
    this.b = paramAnimatorSet2;
  }

  public void a(Animator paramAnimator)
  {
    paramAnimator.b(this);
    AnimatorSet.a(this.a).remove(paramAnimator);
    ((AnimatorSet.Node)AnimatorSet.b(this.b).get(paramAnimator)).f = true;
    int j;
    if (!this.a.b)
    {
      ArrayList localArrayList1 = AnimatorSet.c(this.b);
      int i = localArrayList1.size();
      j = 0;
      if (j >= i)
        break label175;
      if (((AnimatorSet.Node)localArrayList1.get(j)).f);
    }
    label175: for (int k = 0; ; k = 1)
    {
      if (k != 0)
      {
        if (this.a.a != null)
        {
          ArrayList localArrayList2 = (ArrayList)this.a.a.clone();
          int m = localArrayList2.size();
          int n = 0;
          while (true)
            if (n < m)
            {
              ((Animator.AnimatorListener)localArrayList2.get(n)).a(this.b);
              n++;
              continue;
              j++;
              break;
            }
        }
        AnimatorSet.a(this.b, false);
      }
      return;
    }
  }

  public void b(Animator paramAnimator)
  {
  }

  public void c(Animator paramAnimator)
  {
    if ((!this.a.b) && (AnimatorSet.a(this.a).size() == 0) && (this.a.a != null))
    {
      int i = this.a.a.size();
      for (int j = 0; j < i; j++)
        ((Animator.AnimatorListener)this.a.a.get(j)).c(this.b);
    }
  }

  public void d(Animator paramAnimator)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.AnimatorSetListener
 * JD-Core Version:    0.6.2
 */