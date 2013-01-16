package com.facebook.feed.util;

 enum FetchFeedbackType$QueryCursor
{
  static
  {
    BEFORE_CURSOR = new QueryCursor("BEFORE_CURSOR", 1);
    AFTER_CURSOR = new QueryCursor("AFTER_CURSOR", 2);
    QueryCursor[] arrayOfQueryCursor = new QueryCursor[3];
    arrayOfQueryCursor[0] = NONE;
    arrayOfQueryCursor[1] = BEFORE_CURSOR;
    arrayOfQueryCursor[2] = AFTER_CURSOR;
    $VALUES = arrayOfQueryCursor;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FetchFeedbackType.QueryCursor
 * JD-Core Version:    0.6.0
 */