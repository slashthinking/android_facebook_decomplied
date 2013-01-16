package com.facebook.feed.util.event;

import com.facebook.graphql.model.Feedback;

public class FlyoutEvents$LikeClickedEvent extends FeedEvent
{
  public final Feedback a;

  public FlyoutEvents$LikeClickedEvent(Feedback paramFeedback)
  {
    this.a = paramFeedback;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.FlyoutEvents.LikeClickedEvent
 * JD-Core Version:    0.6.0
 */