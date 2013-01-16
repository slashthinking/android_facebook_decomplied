package com.facebook.friends.protocol;

public enum SendFriendRequestMethod$PeopleYouMayKnowLocation
{
  private final String value;

  static
  {
    PYMK_MOBILE_IN_FEED = new PeopleYouMayKnowLocation("PYMK_MOBILE_IN_FEED", 1, "mobile_in_feed");
    PeopleYouMayKnowLocation[] arrayOfPeopleYouMayKnowLocation = new PeopleYouMayKnowLocation[2];
    arrayOfPeopleYouMayKnowLocation[0] = PYMK_MOBILE_JEWEL;
    arrayOfPeopleYouMayKnowLocation[1] = PYMK_MOBILE_IN_FEED;
    $VALUES = arrayOfPeopleYouMayKnowLocation;
  }

  private SendFriendRequestMethod$PeopleYouMayKnowLocation(String paramString)
  {
    this.value = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.SendFriendRequestMethod.PeopleYouMayKnowLocation
 * JD-Core Version:    0.6.0
 */