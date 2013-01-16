package com.facebook.friends;

public enum FriendshipStatus
{
  private final String mStatus;

  static
  {
    ARE_FRIENDS = new FriendshipStatus("ARE_FRIENDS", 1, "ARE_FRIENDS");
    INCOMING_REQUEST = new FriendshipStatus("INCOMING_REQUEST", 2, "INCOMING_REQUEST");
    OUTGOING_REQUEST = new FriendshipStatus("OUTGOING_REQUEST", 3, "OUTGOING_REQUEST");
    CAN_REQUEST = new FriendshipStatus("CAN_REQUEST", 4, "CAN_REQUEST");
    FriendshipStatus[] arrayOfFriendshipStatus = new FriendshipStatus[5];
    arrayOfFriendshipStatus[0] = CANNOT_REQUEST;
    arrayOfFriendshipStatus[1] = ARE_FRIENDS;
    arrayOfFriendshipStatus[2] = INCOMING_REQUEST;
    arrayOfFriendshipStatus[3] = OUTGOING_REQUEST;
    arrayOfFriendshipStatus[4] = CAN_REQUEST;
    $VALUES = arrayOfFriendshipStatus;
  }

  private FriendshipStatus(String paramString)
  {
    this.mStatus = paramString;
  }

  public String toGqlString()
  {
    return this.mStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendshipStatus
 * JD-Core Version:    0.6.0
 */