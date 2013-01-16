package com.facebook.feed.flyout;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.facebook.orca.common.util.Clock;

class FeedFlyoutFragment$11
  implements AbsListView.OnScrollListener
{
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FeedFlyoutFragment.e(this.a).a() - FeedFlyoutFragment.u(this.a) < 3000L);
    while (true)
    {
      return;
      if ((paramInt1 + paramInt2 > paramInt3 - 5) && (paramInt2 != 0) && ((FeedFlyoutFragment.v(this.a).getAdapter() instanceof FeedFlyoutLikesAdapter)))
      {
        FeedFlyoutFragment.w(this.a);
        continue;
      }
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.11
 * JD-Core Version:    0.6.0
 */