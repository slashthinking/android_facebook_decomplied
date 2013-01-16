package com.facebook.feed.ui.permalink;

import android.os.Handler;
import android.widget.LinearLayout;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class PermalinkFragment$9 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    if (this.a)
      PermalinkFragment.x(this.b).postDelayed(new PermalinkFragment.9.1(this), 2000L);
  }

  public void b(Animator paramAnimator)
  {
    PermalinkFragment.w(this.b).setVisibility(0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.9
 * JD-Core Version:    0.6.0
 */