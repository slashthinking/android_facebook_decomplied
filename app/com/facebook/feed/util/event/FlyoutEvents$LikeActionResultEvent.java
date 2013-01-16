package com.facebook.feed.util.event;

import com.facebook.graphql.model.Feedback;

public class FlyoutEvents$LikeActionResultEvent extends FeedEvent
{
  public final Feedback a;
  public final boolean b;

  public FlyoutEvents$LikeActionResultEvent(Feedback paramFeedback, boolean paramBoolean)
  {
    this.a = paramFeedback;
    this.b = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.FlyoutEvents.LikeActionResultEvent
 * JD-Core Version:    0.6.0
 */