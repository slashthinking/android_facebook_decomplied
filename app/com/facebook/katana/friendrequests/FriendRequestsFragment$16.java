package com.facebook.katana.friendrequests;

import com.google.common.util.concurrent.FutureCallback;

class FriendRequestsFragment$16
  implements FutureCallback<Void>
{
  public void a(Throwable paramThrowable)
  {
    FriendRequestsFragment.a(this.b, "Failed to cancel friend request to " + this.a, paramThrowable);
  }

  public void a(Void paramVoid)
  {
    FriendRequestsFragment.a(this.b).b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsFragment.16
 * JD-Core Version:    0.6.0
 */