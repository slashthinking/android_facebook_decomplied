package com.facebook.feed.ui.permalink;

import android.widget.LinearLayout;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class PermalinkFragment$10 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    PermalinkFragment.w(this.c).setVisibility(4);
    PermalinkFragment.a(this.c, PermalinkFragment.ErrorBannerType.NONE);
    if (this.a != PermalinkFragment.ErrorBannerType.NONE)
      PermalinkFragment.a(this.c, this.a, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.10
 * JD-Core Version:    0.6.0
 */