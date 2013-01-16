package com.facebook.timeline;

public enum TimelineHeaderData$UserFriendshipStatus
{
  static
  {
    ARE_FRIENDS = new UserFriendshipStatus("ARE_FRIENDS", 1);
    INCOMING_REQUEST = new UserFriendshipStatus("INCOMING_REQUEST", 2);
    OUTGOING_REQUEST = new UserFriendshipStatus("OUTGOING_REQUEST", 3);
    CAN_REQUEST = new UserFriendshipStatus("CAN_REQUEST", 4);
    UserFriendshipStatus[] arrayOfUserFriendshipStatus = new UserFriendshipStatus[5];
    arrayOfUserFriendshipStatus[0] = CANNOT_REQUEST;
    arrayOfUserFriendshipStatus[1] = ARE_FRIENDS;
    arrayOfUserFriendshipStatus[2] = INCOMING_REQUEST;
    arrayOfUserFriendshipStatus[3] = OUTGOING_REQUEST;
    arrayOfUserFriendshipStatus[4] = CAN_REQUEST;
    $VALUES = arrayOfUserFriendshipStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderData.UserFriendshipStatus
 * JD-Core Version:    0.6.0
 */