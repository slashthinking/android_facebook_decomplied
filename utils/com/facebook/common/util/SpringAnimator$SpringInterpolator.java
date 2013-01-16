package com.facebook.common.util;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.ObjectAnimator;

class SpringAnimator$SpringInterpolator
  implements Interpolator
{
  private SpringAnimator$SpringInterpolator(SpringAnimator paramSpringAnimator)
  {
  }

  public float getInterpolation(float paramFloat)
  {
    float f1 = 1.0F;
    long l = System.currentTimeMillis();
    if (SpringAnimator.b(this.a) == 0L)
      SpringAnimator.a(this.a, l - 16L);
    int i = Math.round((float)(l - SpringAnimator.b(this.a)) / 16.0F);
    int j = i - SpringAnimator.c(this.a);
    float f2 = SpringAnimator.d(this.a).floatValue();
    float f3 = SpringAnimator.e(this.a).floatValue();
    for (int k = 0; k < j; k++)
    {
      float f8 = (f2 - SpringAnimator.f(this.a)) * SpringAnimator.g(this.a);
      SpringAnimator.a(this.a, f8 * 60.0F);
      SpringAnimator.b(this.a, SpringAnimator.h(this.a));
      SpringAnimator.c(this.a, SpringAnimator.i(this.a) / 60.0F);
    }
    SpringAnimator.a(this.a, i);
    float f4 = f2 - f3;
    float f5 = SpringAnimator.f(this.a) - f3;
    float f6;
    if ((f5 == 0.0F) || (f4 == 0.0F))
    {
      f6 = f1;
      float f7 = Math.abs(f1 - f6);
      if ((Math.abs(SpringAnimator.i(this.a)) >= SpringAnimator.k(this.a)) || (f7 >= SpringAnimator.l(this.a)))
        break label307;
      SpringAnimator.d(this.a, 0.0F);
      SpringAnimator.m(this.a).d(0L);
    }
    while (true)
    {
      return f1;
      f6 = f5 / f4;
      if (!SpringAnimator.j(this.a))
        break;
      f6 = Math.min(f6, f1);
      break;
      label307: SpringAnimator.m(this.a).d(2147483647L);
      f1 = f6;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.SpringAnimator.SpringInterpolator
 * JD-Core Version:    0.6.2
 */