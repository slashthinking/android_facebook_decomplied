package com.facebook.katana.friendrequests;

 enum FriendRequestsAdapter$RowType
{
  static
  {
    PERSON_YOU_MAY_KNOW = new RowType("PERSON_YOU_MAY_KNOW", 2);
    NO_REQUESTS = new RowType("NO_REQUESTS", 3);
    LOAD_MORE = new RowType("LOAD_MORE", 4);
    RowType[] arrayOfRowType = new RowType[5];
    arrayOfRowType[0] = FRIEND_REQUEST;
    arrayOfRowType[1] = PYMK_HEADER;
    arrayOfRowType[2] = PERSON_YOU_MAY_KNOW;
    arrayOfRowType[3] = NO_REQUESTS;
    arrayOfRowType[4] = LOAD_MORE;
    $VALUES = arrayOfRowType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsAdapter.RowType
 * JD-Core Version:    0.6.0
 */