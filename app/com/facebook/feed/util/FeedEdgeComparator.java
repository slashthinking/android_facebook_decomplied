package com.facebook.feed.util;

import com.facebook.graphql.model.FeedEdge;
import java.util.Comparator;

public class FeedEdgeComparator
  implements Comparator<FeedEdge>
{
  public static final Comparator<FeedEdge> a = new FeedEdgeComparator();
  public static final String b = Character.toString('ѣ');

  public int a(FeedEdge paramFeedEdge1, FeedEdge paramFeedEdge2)
  {
    String str1 = paramFeedEdge1.c();
    String str2 = paramFeedEdge2.c();
    if ((str1 != null) && (str2 != null));
    for (int i = str2.compareTo(str1); ; i = 1)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FeedEdgeComparator
 * JD-Core Version:    0.6.0
 */