package com.facebook.orca.common.ui.widgets;

import com.facebook.widget.animatablelistview.AnimatingItemInfo;
import com.facebook.widget.animatablelistview.AnimatingItemView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class SlidingOutSuggestionViewBase$1 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    SlidingOutSuggestionViewBase.a(this.b, false);
    SlidingOutSuggestionViewBase.a(this.b).setVisibility(8);
    this.a.setAnimationOffset(1.0F);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.SlidingOutSuggestionViewBase.1
 * JD-Core Version:    0.6.0
 */