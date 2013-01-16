package com.facebook.feed.ui.footer;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.LikeAnimationEndedEvent;

class TwoLineFeedbackView$2$1
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    TwoLineFeedbackView.i(this.a.b).a(new UfiEvents.LikeAnimationEndedEvent());
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.TwoLineFeedbackView.2.1
 * JD-Core Version:    0.6.0
 */