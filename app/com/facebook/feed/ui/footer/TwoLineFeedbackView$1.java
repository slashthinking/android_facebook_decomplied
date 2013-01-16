package com.facebook.feed.ui.footer;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class TwoLineFeedbackView$1
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    TwoLineFeedbackView.a(this.b, true);
    TwoLineFeedbackView.a(this.b).setVisibility(8);
    TextView localTextView = TwoLineFeedbackView.c(this.b);
    Resources localResources = TwoLineFeedbackView.b(this.b).getResources();
    int i = this.a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.a);
    localTextView.setText(localResources.getQuantityString(2131427343, i, arrayOfObject));
    TwoLineFeedbackView.d(this.b);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.TwoLineFeedbackView.1
 * JD-Core Version:    0.6.0
 */