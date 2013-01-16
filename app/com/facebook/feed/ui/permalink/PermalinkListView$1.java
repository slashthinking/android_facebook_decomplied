package com.facebook.feed.ui.permalink;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.CommentFocusEvent;

class PermalinkListView$1
  implements AbsListView.OnScrollListener
{
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((PermalinkListView.a(this.a)) && (PermalinkListView.a(this.a, paramInt1, paramInt2, paramInt3)))
    {
      PermalinkListView.a(this.a, false);
      PermalinkListView.b(this.a).a(new UfiEvents.CommentFocusEvent());
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkListView.1
 * JD-Core Version:    0.6.0
 */