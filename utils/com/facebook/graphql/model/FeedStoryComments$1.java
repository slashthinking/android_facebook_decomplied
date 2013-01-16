package com.facebook.graphql.model;

import java.util.Comparator;

final class FeedStoryComments$1
  implements Comparator<FeedComment>
{
  public int a(FeedComment paramFeedComment1, FeedComment paramFeedComment2)
  {
    int i;
    if (paramFeedComment1.createdTime - paramFeedComment2.createdTime != 0L)
      i = (int)(paramFeedComment1.createdTime - paramFeedComment2.createdTime);
    while (true)
    {
      return i;
      if (paramFeedComment1.S().legacyApiPostId != null)
        i = paramFeedComment1.S().legacyApiPostId.compareTo(paramFeedComment2.S().legacyApiPostId);
      else if (paramFeedComment2.S().legacyApiPostId != null)
        i = paramFeedComment2.S().legacyApiPostId.compareTo(paramFeedComment1.S().legacyApiPostId);
      else
        i = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStoryComments.1
 * JD-Core Version:    0.6.2
 */