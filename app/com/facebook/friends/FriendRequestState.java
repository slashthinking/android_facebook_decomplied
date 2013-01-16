package com.facebook.friends;

public enum FriendRequestState
{
  static
  {
    ACCEPTED = new FriendRequestState("ACCEPTED", 1);
    IGNORED = new FriendRequestState("IGNORED", 2);
    FriendRequestState[] arrayOfFriendRequestState = new FriendRequestState[3];
    arrayOfFriendRequestState[0] = NEEDS_RESPONSE;
    arrayOfFriendRequestState[1] = ACCEPTED;
    arrayOfFriendRequestState[2] = IGNORED;
    $VALUES = arrayOfFriendRequestState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendRequestState
 * JD-Core Version:    0.6.0
 */