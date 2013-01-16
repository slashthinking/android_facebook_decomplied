package com.facebook.timeline;

import com.facebook.feed.protocol.FetchTimelineFirstUnitsMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class TimelineModule$FetchTimelineFirstUnitsMethodProvider extends AbstractProvider<FetchTimelineFirstUnitsMethod>
{
  private TimelineModule$FetchTimelineFirstUnitsMethodProvider(TimelineModule paramTimelineModule)
  {
  }

  public FetchTimelineFirstUnitsMethod a()
  {
    return new FetchTimelineFirstUnitsMethod((GraphQLStoryHelper)b(GraphQLStoryHelper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.FetchTimelineFirstUnitsMethodProvider
 * JD-Core Version:    0.6.0
 */