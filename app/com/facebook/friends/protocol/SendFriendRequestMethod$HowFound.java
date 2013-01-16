package com.facebook.friends.protocol;

public enum SendFriendRequestMethod$HowFound
{
  public final String value;

  static
  {
    NETEGO_PYMK = new HowFound("NETEGO_PYMK", 2, "netego_pymk");
    SEARCH = new HowFound("SEARCH", 3, "search");
    NEWSFEED = new HowFound("NEWSFEED", 4, "newsfeed");
    SUGGESTION = new HowFound("SUGGESTION", 5, "friend_suggestion");
    HowFound[] arrayOfHowFound = new HowFound[6];
    arrayOfHowFound[0] = PROFILE_BUTTON;
    arrayOfHowFound[1] = PYMK;
    arrayOfHowFound[2] = NETEGO_PYMK;
    arrayOfHowFound[3] = SEARCH;
    arrayOfHowFound[4] = NEWSFEED;
    arrayOfHowFound[5] = SUGGESTION;
    $VALUES = arrayOfHowFound;
  }

  private SendFriendRequestMethod$HowFound(String paramString)
  {
    this.value = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.SendFriendRequestMethod.HowFound
 * JD-Core Version:    0.6.0
 */