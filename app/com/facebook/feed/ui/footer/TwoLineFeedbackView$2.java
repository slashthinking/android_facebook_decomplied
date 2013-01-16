package com.facebook.feed.ui.footer;

import com.facebook.feed.animation.CollapseAnimation;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.view.ViewPropertyAnimator;

class TwoLineFeedbackView$2 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    TwoLineFeedbackView.a(this.b, false);
    TwoLineFeedbackView.e(this.b);
    if (TwoLineFeedbackView.f(this.b) != null)
    {
      TwoLineFeedbackView.f(this.b).a(0L);
      TwoLineFeedbackView.f(this.b).b(1.0F);
      TwoLineFeedbackView.f(this.b).c(1.0F);
      TwoLineFeedbackView.f(this.b).a(null);
    }
    if (this.a)
    {
      TwoLineFeedbackView.a(this.b, new CollapseAnimation(TwoLineFeedbackView.a(this.b), TwoLineFeedbackView.g(this.b)));
      TwoLineFeedbackView.h(this.b).setDuration(200L);
      TwoLineFeedbackView.h(this.b).setAnimationListener(new TwoLineFeedbackView.2.1(this));
      this.b.startAnimation(TwoLineFeedbackView.h(this.b));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.TwoLineFeedbackView.2
 * JD-Core Version:    0.6.0
 */