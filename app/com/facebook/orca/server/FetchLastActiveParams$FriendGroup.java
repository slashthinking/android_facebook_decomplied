package com.facebook.orca.server;

public enum FetchLastActiveParams$FriendGroup
{
  static
  {
    FAVORITE_FRIENDS = new FriendGroup("FAVORITE_FRIENDS", 1);
    ALL = new FriendGroup("ALL", 2);
    FriendGroup[] arrayOfFriendGroup = new FriendGroup[3];
    arrayOfFriendGroup[0] = TOP_FRIENDS;
    arrayOfFriendGroup[1] = FAVORITE_FRIENDS;
    arrayOfFriendGroup[2] = ALL;
    $VALUES = arrayOfFriendGroup;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchLastActiveParams.FriendGroup
 * JD-Core Version:    0.6.0
 */