package com.facebook.feed.util.event;

import com.facebook.graphql.model.FeedComment;

public class UfiEvents$CommentLikeClickedEvent extends FeedEvent
{
  public final String a;
  public final FeedComment b;

  public UfiEvents$CommentLikeClickedEvent(String paramString, FeedComment paramFeedComment)
  {
    this.a = paramString;
    this.b = paramFeedComment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.UfiEvents.CommentLikeClickedEvent
 * JD-Core Version:    0.6.0
 */