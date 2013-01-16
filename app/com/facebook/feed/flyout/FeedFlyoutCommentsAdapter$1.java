package com.facebook.feed.flyout;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FlyoutEvents.FetchPreviousCommentsEvent;

class FeedFlyoutCommentsAdapter$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (!FeedFlyoutCommentsAdapter.a(this.a))
    {
      FeedFlyoutCommentsAdapter.b(this.a).a(new FlyoutEvents.FetchPreviousCommentsEvent());
      FeedFlyoutCommentsAdapter.c(this.a).a();
      FeedFlyoutCommentsAdapter.a(this.a, true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutCommentsAdapter.1
 * JD-Core Version:    0.6.0
 */