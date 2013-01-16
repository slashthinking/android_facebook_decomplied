package com.facebook.feed.ui;

import android.os.Handler;

class NewsFeedListView$1
  implements Runnable
{
  public void run()
  {
    if (!this.a.d())
    {
      NewsFeedListView.a(this.a).a();
      this.a.smoothScrollToPosition(0);
      NewsFeedListView.c(this.a).postDelayed(NewsFeedListView.b(this.a), 200L);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedListView.1
 * JD-Core Version:    0.6.0
 */