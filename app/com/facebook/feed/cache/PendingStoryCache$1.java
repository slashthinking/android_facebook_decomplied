package com.facebook.feed.cache;

import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import java.util.Comparator;

class PendingStoryCache$1
  implements Comparator<FeedEdge>
{
  public int a(FeedEdge paramFeedEdge1, FeedEdge paramFeedEdge2)
  {
    FeedUnit localFeedUnit1 = paramFeedEdge1.b();
    FeedUnit localFeedUnit2 = paramFeedEdge2.b();
    if (((localFeedUnit1 instanceof FeedStory)) && ((localFeedUnit2 instanceof FeedStory)));
    for (int i = Long.valueOf(((FeedStory)localFeedUnit2).creationTime).compareTo(Long.valueOf(((FeedStory)localFeedUnit1).creationTime)); ; i = 1)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.PendingStoryCache.1
 * JD-Core Version:    0.6.0
 */