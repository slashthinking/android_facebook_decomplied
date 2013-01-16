package com.facebook.feed.ui;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class NewsFeedListView$3 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    if (NewsFeedListView.d(this.a) == NewsFeedListView.e(this.a))
    {
      NewsFeedListView.j(this.a).setVisibility(8);
      NewsFeedListView.k(this.a).clearAnimation();
    }
    while (true)
    {
      return;
      NewsFeedListView.j(this.a).setVisibility(0);
      if (NewsFeedListView.d(this.a) != 0)
        continue;
      NewsFeedListView.k(this.a).clearAnimation();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedListView.3
 * JD-Core Version:    0.6.0
 */