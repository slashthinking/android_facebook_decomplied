package com.facebook.timeline;

import android.content.res.Resources;
import com.facebook.feed.protocol.FetchTimelineHeaderMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class TimelineModule$FetchTimelineHeaderMethodProvider extends AbstractProvider<FetchTimelineHeaderMethod>
{
  private TimelineModule$FetchTimelineHeaderMethodProvider(TimelineModule paramTimelineModule)
  {
  }

  public FetchTimelineHeaderMethod a()
  {
    return new FetchTimelineHeaderMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.FetchTimelineHeaderMethodProvider
 * JD-Core Version:    0.6.0
 */