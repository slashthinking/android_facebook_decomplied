package com.facebook.timeline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.friends.FriendRequestResponse;
import com.facebook.friends.FriendRequestResponseRef;
import com.facebook.friends.FriendingClient;
import com.google.common.util.concurrent.Futures;

class UserTimelineHeaderView$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0);
    for (FriendRequestResponse localFriendRequestResponse = FriendRequestResponse.CONFIRM; ; localFriendRequestResponse = FriendRequestResponse.REJECT)
    {
      Futures.a(this.a.getFriendingClient().a().a(this.a.getHeaderData().d(), localFriendRequestResponse, FriendRequestResponseRef.PROFILE), new UserTimelineHeaderView.3.1(this, localFriendRequestResponse));
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.UserTimelineHeaderView.3
 * JD-Core Version:    0.6.0
 */