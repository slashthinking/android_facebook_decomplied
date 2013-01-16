package com.facebook.katana.friendrequests;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.friends.FriendRequestState;

class FriendRequestView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    FriendRequestView.c(this.a).a(FriendRequestView.a(this.a));
    FriendRequestView.a(this.a, FriendRequestState.ACCEPTED);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestView.2
 * JD-Core Version:    0.6.0
 */