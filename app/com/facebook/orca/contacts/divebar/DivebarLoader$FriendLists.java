package com.facebook.orca.contacts.divebar;

public enum DivebarLoader$FriendLists
{
  static
  {
    ONLINE_FRIENDS = new FriendLists("ONLINE_FRIENDS", 2);
    MOBILE_FRIENDS = new FriendLists("MOBILE_FRIENDS", 3);
    OTHER_CONTACTS = new FriendLists("OTHER_CONTACTS", 4);
    FriendLists[] arrayOfFriendLists = new FriendLists[5];
    arrayOfFriendLists[0] = FAVORITE_FRIENDS;
    arrayOfFriendLists[1] = TOP_FRIENDS;
    arrayOfFriendLists[2] = ONLINE_FRIENDS;
    arrayOfFriendLists[3] = MOBILE_FRIENDS;
    arrayOfFriendLists[4] = OTHER_CONTACTS;
    $VALUES = arrayOfFriendLists;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarLoader.FriendLists
 * JD-Core Version:    0.6.0
 */