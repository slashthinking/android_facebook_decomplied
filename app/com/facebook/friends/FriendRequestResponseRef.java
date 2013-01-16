package com.facebook.friends;

public enum FriendRequestResponseRef
{
  public final String value;

  static
  {
    MOBILE_JEWEL = new FriendRequestResponseRef("MOBILE_JEWEL", 1, "m_jewel");
    FriendRequestResponseRef[] arrayOfFriendRequestResponseRef = new FriendRequestResponseRef[2];
    arrayOfFriendRequestResponseRef[0] = PROFILE;
    arrayOfFriendRequestResponseRef[1] = MOBILE_JEWEL;
    $VALUES = arrayOfFriendRequestResponseRef;
  }

  private FriendRequestResponseRef(String paramString)
  {
    this.value = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendRequestResponseRef
 * JD-Core Version:    0.6.0
 */