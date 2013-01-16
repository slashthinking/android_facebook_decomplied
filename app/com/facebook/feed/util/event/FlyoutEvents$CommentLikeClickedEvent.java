package com.facebook.feed.util.event;

import com.facebook.graphql.model.FeedComment;

public class FlyoutEvents$CommentLikeClickedEvent extends FeedEvent
{
  public final FeedComment a;

  public FlyoutEvents$CommentLikeClickedEvent(FeedComment paramFeedComment)
  {
    this.a = paramFeedComment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.FlyoutEvents.CommentLikeClickedEvent
 * JD-Core Version:    0.6.0
 */