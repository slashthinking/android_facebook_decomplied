package com.facebook.feed.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.feed.data.AppendOnlyGraphQLObjectCollection;

class ProfileListFragment$1
  implements AbsListView.OnScrollListener
{
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ProfileListFragment.a(this.a)) || (!ProfileListFragment.b(this.a).b()));
    while (true)
    {
      return;
      if ((paramInt1 + paramInt2 > paramInt3 - 1) && (paramInt2 != 0))
      {
        ProfileListFragment.c(this.a);
        continue;
      }
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.ProfileListFragment.1
 * JD-Core Version:    0.6.0
 */