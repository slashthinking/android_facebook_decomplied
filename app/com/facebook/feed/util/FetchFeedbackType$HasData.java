package com.facebook.feed.util;

 enum FetchFeedbackType$HasData
{
  static
  {
    COMMENTS_AND_LIKERS = new HasData("COMMENTS_AND_LIKERS", 1);
    COMMENTS_ONLY = new HasData("COMMENTS_ONLY", 2);
    LIKERS_ONLY = new HasData("LIKERS_ONLY", 3);
    HasData[] arrayOfHasData = new HasData[4];
    arrayOfHasData[0] = NONE;
    arrayOfHasData[1] = COMMENTS_AND_LIKERS;
    arrayOfHasData[2] = COMMENTS_ONLY;
    arrayOfHasData[3] = LIKERS_ONLY;
    $VALUES = arrayOfHasData;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FetchFeedbackType.HasData
 * JD-Core Version:    0.6.0
 */