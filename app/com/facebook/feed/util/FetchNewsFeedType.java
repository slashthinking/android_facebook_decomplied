package com.facebook.feed.util;

import com.facebook.feed.protocol.FetchNewsFeedParams;

public enum FetchNewsFeedType
{
  static
  {
    LATEST_N_STORIES_AFTER_A_CURSOR = new FetchNewsFeedType("LATEST_N_STORIES_AFTER_A_CURSOR", 2);
    N_STORIES_BETWEEN_CURSORS = new FetchNewsFeedType("N_STORIES_BETWEEN_CURSORS", 3);
    FetchNewsFeedType[] arrayOfFetchNewsFeedType = new FetchNewsFeedType[4];
    arrayOfFetchNewsFeedType[0] = LATEST_N_STORIES;
    arrayOfFetchNewsFeedType[1] = LATEST_N_STORIES_BEFORE_A_CURSOR;
    arrayOfFetchNewsFeedType[2] = LATEST_N_STORIES_AFTER_A_CURSOR;
    arrayOfFetchNewsFeedType[3] = N_STORIES_BETWEEN_CURSORS;
    $VALUES = arrayOfFetchNewsFeedType;
  }

  public static FetchNewsFeedType getQueryType(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    FetchNewsFeedType localFetchNewsFeedType;
    if ((paramFetchNewsFeedParams.d() != null) && (paramFetchNewsFeedParams.c() != null))
      localFetchNewsFeedType = N_STORIES_BETWEEN_CURSORS;
    while (true)
    {
      return localFetchNewsFeedType;
      if (paramFetchNewsFeedParams.d() != null)
      {
        localFetchNewsFeedType = LATEST_N_STORIES_AFTER_A_CURSOR;
        continue;
      }
      if (paramFetchNewsFeedParams.c() != null)
      {
        localFetchNewsFeedType = LATEST_N_STORIES_BEFORE_A_CURSOR;
        continue;
      }
      localFetchNewsFeedType = LATEST_N_STORIES;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FetchNewsFeedType
 * JD-Core Version:    0.6.0
 */