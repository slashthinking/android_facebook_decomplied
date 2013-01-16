package com.facebook.timeline;

public enum TimelineHeaderFriendListData$FriendListType
{
  static
  {
    ACQUAINTANCES = new FriendListType("ACQUAINTANCES", 1);
    RESTRICTED = new FriendListType("RESTRICTED", 2);
    FriendListType[] arrayOfFriendListType = new FriendListType[3];
    arrayOfFriendListType[0] = CLOSE_FRIENDS;
    arrayOfFriendListType[1] = ACQUAINTANCES;
    arrayOfFriendListType[2] = RESTRICTED;
    $VALUES = arrayOfFriendListType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderFriendListData.FriendListType
 * JD-Core Version:    0.6.0
 */