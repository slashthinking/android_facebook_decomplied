package com.facebook.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;

class UserTimelineHeaderView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.b.getDataFetcher().d();
    this.b.getIntentBuilder().a(this.b.getContext(), this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.UserTimelineHeaderView.1
 * JD-Core Version:    0.6.0
 */