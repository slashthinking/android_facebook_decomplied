package com.facebook.katana.friendrequests;

import com.facebook.friends.FriendRequestResponse;
import com.facebook.friends.model.FriendRequest;

abstract interface FriendRequestView$OnResponseListener
{
  public abstract void a(FriendRequest paramFriendRequest, FriendRequestResponse paramFriendRequestResponse);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestView.OnResponseListener
 * JD-Core Version:    0.6.0
 */