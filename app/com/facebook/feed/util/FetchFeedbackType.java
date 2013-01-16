package com.facebook.feed.util;

import com.facebook.feed.protocol.FetchFeedbackParams;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.protocol.FetchSingleStoryParams;

public enum FetchFeedbackType
{
  private FetchFeedbackType.HasData fetchType;
  private FetchFeedbackType.QueryCursor oldOrNewData;

  static
  {
    FetchFeedbackType[] arrayOfFetchFeedbackType = new FetchFeedbackType[6];
    arrayOfFetchFeedbackType[0] = BASE_ONLY;
    arrayOfFetchFeedbackType[1] = LATEST_COMMENTS_AND_LIKERS;
    arrayOfFetchFeedbackType[2] = LATEST_COMMENTS_ONLY;
    arrayOfFetchFeedbackType[3] = LATEST_LIKERS_ONLY;
    arrayOfFetchFeedbackType[4] = OLDER_COMMENTS_ONLY;
    arrayOfFetchFeedbackType[5] = OLDER_LIKERS_ONLY;
    $VALUES = arrayOfFetchFeedbackType;
  }

  private FetchFeedbackType(FetchFeedbackType.HasData paramHasData, FetchFeedbackType.QueryCursor paramQueryCursor)
  {
    this.fetchType = paramHasData;
    this.oldOrNewData = paramQueryCursor;
  }

  public static FetchFeedbackType getQueryType(FetchFeedbackParams paramFetchFeedbackParams)
  {
    return LATEST_COMMENTS_AND_LIKERS;
  }

  public static FetchFeedbackType getQueryType(FetchSingleStoryParams paramFetchSingleStoryParams)
  {
    if (paramFetchSingleStoryParams.c);
    for (FetchFeedbackType localFetchFeedbackType = LATEST_COMMENTS_AND_LIKERS; ; localFetchFeedbackType = BASE_ONLY)
      return localFetchFeedbackType;
  }

  public static FetchFeedbackType getQueryType(String paramString, FetchNodeListParams paramFetchNodeListParams)
  {
    FetchFeedbackType localFetchFeedbackType;
    if ("fetchCommentsParams".equals(paramString))
      if (paramFetchNodeListParams.d() != null)
        localFetchFeedbackType = OLDER_COMMENTS_ONLY;
    while (true)
    {
      return localFetchFeedbackType;
      localFetchFeedbackType = LATEST_COMMENTS_ONLY;
      continue;
      if ("fetchLikersFeedParams".equals(paramString))
      {
        if (paramFetchNodeListParams.d() != null)
        {
          localFetchFeedbackType = OLDER_LIKERS_ONLY;
          continue;
        }
        localFetchFeedbackType = LATEST_LIKERS_ONLY;
        continue;
      }
      localFetchFeedbackType = BASE_ONLY;
    }
  }

  public boolean hasComments()
  {
    if ((this.fetchType == FetchFeedbackType.HasData.COMMENTS_ONLY) || (this.fetchType == FetchFeedbackType.HasData.COMMENTS_AND_LIKERS));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean hasLikers()
  {
    if ((this.fetchType == FetchFeedbackType.HasData.LIKERS_ONLY) || (this.fetchType == FetchFeedbackType.HasData.COMMENTS_AND_LIKERS));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean hasNewerData()
  {
    if (this.oldOrNewData == FetchFeedbackType.QueryCursor.BEFORE_CURSOR);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FetchFeedbackType
 * JD-Core Version:    0.6.0
 */