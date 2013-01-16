package com.facebook.feed.ui.footer;

import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.LikeAnimationEndedEvent;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class TwoLineFeedbackView$3 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    TwoLineFeedbackView.i(this.a).a(new UfiEvents.LikeAnimationEndedEvent());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.TwoLineFeedbackView.3
 * JD-Core Version:    0.6.0
 */