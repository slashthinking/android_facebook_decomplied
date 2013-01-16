package com.facebook.feed.flyout;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FlyoutEvents.SwitchViewEvent;
import com.facebook.graphql.model.Feedback;

class FeedFlyoutHeaderView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    FeedFlyoutHeaderView.e(this.a).a(new FlyoutEvents.SwitchViewEvent(FeedFlyoutHeaderView.b(this.a).d()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutHeaderView.2
 * JD-Core Version:    0.6.0
 */