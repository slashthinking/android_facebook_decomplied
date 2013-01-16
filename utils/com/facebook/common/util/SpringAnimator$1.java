package com.facebook.common.util;

import com.google.common.collect.ImmutableList;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.Iterator;

class SpringAnimator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  SpringAnimator$1(SpringAnimator paramSpringAnimator)
  {
  }

  public void a(ValueAnimator paramValueAnimator)
  {
    Iterator localIterator = SpringAnimator.a(this.a).iterator();
    while (localIterator.hasNext())
      ((ValueAnimator.AnimatorUpdateListener)localIterator.next()).a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.SpringAnimator.1
 * JD-Core Version:    0.6.2
 */