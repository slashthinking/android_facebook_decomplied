package com.facebook.katana.friendrequests;

import com.facebook.friends.FriendingClient;
import com.facebook.friends.model.PersonYouMayKnow;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;

class FriendRequestsFragment$10
  implements FutureCallback<List<PersonYouMayKnow>>
{
  public void a(Throwable paramThrowable)
  {
  }

  public void a(List<PersonYouMayKnow> paramList)
  {
    if ((paramList.size() > 0) && (FriendRequestsFragment.a(this.a).b() == 0))
      FriendRequestsFragment.d(this.a).a(paramList.subList(0, Math.min(3, paramList.size())));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsFragment.10
 * JD-Core Version:    0.6.0
 */