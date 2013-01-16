package com.facebook.ipc.data.uberbar;

public enum UberbarResult$FriendStatus
{
  static
  {
    ARE_FRIENDS = new FriendStatus("ARE_FRIENDS", 1);
    INCOMING_REQUEST = new FriendStatus("INCOMING_REQUEST", 2);
    OUTGOING_REQUEST = new FriendStatus("OUTGOING_REQUEST", 3);
    CAN_REQUEST = new FriendStatus("CAN_REQUEST", 4);
    FriendStatus[] arrayOfFriendStatus = new FriendStatus[5];
    arrayOfFriendStatus[0] = CANNOT_REQUEST;
    arrayOfFriendStatus[1] = ARE_FRIENDS;
    arrayOfFriendStatus[2] = INCOMING_REQUEST;
    arrayOfFriendStatus[3] = OUTGOING_REQUEST;
    arrayOfFriendStatus[4] = CAN_REQUEST;
    $VALUES = arrayOfFriendStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.data.uberbar.UberbarResult.FriendStatus
 * JD-Core Version:    0.6.0
 */