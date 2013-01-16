package com.facebook.katana.friendrequests;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.friends.FriendRequestResponse;
import com.facebook.friends.FriendRequestState;

class FriendRequestView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    FriendRequestView.b(this.b).a(FriendRequestView.a(this.b), this.a);
    if (this.a == FriendRequestResponse.CONFIRM);
    for (FriendRequestState localFriendRequestState = FriendRequestState.ACCEPTED; ; localFriendRequestState = FriendRequestState.IGNORED)
    {
      FriendRequestView.a(this.b, localFriendRequestState);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestView.1
 * JD-Core Version:    0.6.0
 */