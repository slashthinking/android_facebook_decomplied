package com.facebook.friends;

public enum FriendRequestResponse
{
  public final String value;

  static
  {
    CONFIRM = new FriendRequestResponse("CONFIRM", 1, "1");
    REJECT = new FriendRequestResponse("REJECT", 2, "2");
    FriendRequestResponse[] arrayOfFriendRequestResponse = new FriendRequestResponse[3];
    arrayOfFriendRequestResponse[0] = IGNORE;
    arrayOfFriendRequestResponse[1] = CONFIRM;
    arrayOfFriendRequestResponse[2] = REJECT;
    $VALUES = arrayOfFriendRequestResponse;
  }

  private FriendRequestResponse(String paramString)
  {
    this.value = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendRequestResponse
 * JD-Core Version:    0.6.0
 */