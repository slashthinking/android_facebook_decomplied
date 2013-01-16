package com.facebook.katana.friendrequests;

import com.google.common.util.concurrent.FutureCallback;

class FriendRequestsFragment$15
  implements FutureCallback<Void>
{
  public void a(Throwable paramThrowable)
  {
    FriendRequestsFragment.a(this.b, "Failed to send friend request to " + this.a, paramThrowable);
  }

  public void a(Void paramVoid)
  {
    FriendRequestsFragment.a(this.b).a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsFragment.15
 * JD-Core Version:    0.6.0
 */