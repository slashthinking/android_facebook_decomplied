package com.facebook.feed.util.event;

import com.facebook.graphql.model.GraphQLEntityRange;
import java.util.List;

public class UfiEvents$CommentPostEvent extends FeedEvent
{
  public final String a;
  public final String b;
  public final String c;
  public final List<GraphQLEntityRange> d;

  public UfiEvents$CommentPostEvent(String paramString1, String paramString2, String paramString3, List<GraphQLEntityRange> paramList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.UfiEvents.CommentPostEvent
 * JD-Core Version:    0.6.0
 */