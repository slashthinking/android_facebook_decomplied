package com.facebook.katana.friendrequests;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class FriendRequestsFragment$8
  implements AbsListView.OnScrollListener
{
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = FriendRequestsFragment.a(this.b).a(paramInt1);
    View localView = this.a;
    if (bool);
    for (int i = 0; ; i = 8)
    {
      localView.setVisibility(i);
      this.a.bringToFront();
      if (paramInt1 + paramInt2 >= FriendRequestsFragment.a(this.b).getCount())
        FriendRequestsFragment.a(this.b, true);
      FriendRequestsFragment.b(this.b);
      return;
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsFragment.8
 * JD-Core Version:    0.6.0
 */