package com.facebook.feed.util;

import com.facebook.graphql.model.FeedComment;
import com.google.common.primitives.Longs;
import java.util.Comparator;

public class FeedCommentComparator
  implements Comparator<FeedComment>
{
  public static final Comparator<FeedComment> a = new FeedCommentComparator();

  public int a(FeedComment paramFeedComment1, FeedComment paramFeedComment2)
  {
    return Longs.a(paramFeedComment1.createdTime, paramFeedComment2.createdTime);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FeedCommentComparator
 * JD-Core Version:    0.6.0
 */