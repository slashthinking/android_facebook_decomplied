package com.facebook.katana.friendrequests;

import com.facebook.common.util.Log;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;

class FriendRequestsFragment$11
  implements FutureCallback<List<PersonYouMayKnow>>
{
  public void a(Throwable paramThrowable)
  {
    FriendRequestsFragment.c(this.a).d();
    Log.a(FriendRequestsFragment.b(), paramThrowable.toString());
  }

  public void a(List<PersonYouMayKnow> paramList)
  {
    FriendRequestsAdapter localFriendRequestsAdapter = FriendRequestsFragment.a(this.a);
    if (!FriendRequestsFragment.d(this.a).b());
    for (boolean bool = true; ; bool = false)
    {
      localFriendRequestsAdapter.a(bool);
      FriendRequestsFragment.a(this.a).b(paramList);
      FriendRequestsFragment.c(this.a).d();
      FriendRequestsFragment.b(this.a);
      FriendRequestsFragment.a(this.a, false);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsFragment.11
 * JD-Core Version:    0.6.0
 */