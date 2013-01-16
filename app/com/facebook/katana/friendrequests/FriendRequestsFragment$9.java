package com.facebook.katana.friendrequests;

import com.facebook.common.util.Log;
import com.facebook.friends.model.FriendRequest;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;

class FriendRequestsFragment$9
  implements FutureCallback<List<FriendRequest>>
{
  public void a(Throwable paramThrowable)
  {
    FriendRequestsFragment.c(this.b).d();
    Log.a(FriendRequestsFragment.b(), paramThrowable.toString());
  }

  public void a(List<FriendRequest> paramList)
  {
    if (this.a)
      FriendRequestsFragment.a(this.b).a();
    FriendRequestsFragment.a(this.b).a(paramList);
    FriendRequestsFragment.c(this.b).setLastLoadedTime(System.currentTimeMillis());
    FriendRequestsFragment.c(this.b).d();
    FriendRequestsFragment.a(this.b, FriendRequestsFragment.a(this.b).isEmpty(), false);
    FriendRequestsFragment.b(this.b);
    FriendRequestsFragment.a(this.b, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsFragment.9
 * JD-Core Version:    0.6.0
 */