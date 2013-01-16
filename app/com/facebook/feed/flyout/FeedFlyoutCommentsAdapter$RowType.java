package com.facebook.feed.flyout;

 enum FeedFlyoutCommentsAdapter$RowType
{
  static
  {
    COMMENT = new RowType("COMMENT", 2);
    RowType[] arrayOfRowType = new RowType[3];
    arrayOfRowType[0] = HEADER;
    arrayOfRowType[1] = LOADPREV;
    arrayOfRowType[2] = COMMENT;
    $VALUES = arrayOfRowType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutCommentsAdapter.RowType
 * JD-Core Version:    0.6.0
 */