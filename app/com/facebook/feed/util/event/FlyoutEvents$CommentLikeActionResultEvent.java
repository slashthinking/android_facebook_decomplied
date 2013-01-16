package com.facebook.feed.util.event;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.FeedComment;

public class FlyoutEvents$CommentLikeActionResultEvent extends FeedEvent
{
  public final FeedComment a;
  public final TriState b;

  public FlyoutEvents$CommentLikeActionResultEvent(FeedComment paramFeedComment, TriState paramTriState)
  {
    this.a = paramFeedComment;
    this.b = paramTriState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.FlyoutEvents.CommentLikeActionResultEvent
 * JD-Core Version:    0.6.0
 */