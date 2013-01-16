package com.facebook.feed.util.event;

import com.facebook.graphql.model.GraphQLProfile;
import java.util.List;

public class FlyoutEvents$SwitchInlineCommentLikersEvent extends FeedEvent
{
  public final List<GraphQLProfile> a;

  public FlyoutEvents$SwitchInlineCommentLikersEvent(List<GraphQLProfile> paramList)
  {
    this.a = paramList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.FlyoutEvents.SwitchInlineCommentLikersEvent
 * JD-Core Version:    0.6.0
 */