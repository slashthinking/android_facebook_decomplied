package com.facebook.timeline;

import com.facebook.feed.protocol.FetchTimelineSectionMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class TimelineModule$FetchTimelineSectionMethodProvider extends AbstractProvider<FetchTimelineSectionMethod>
{
  private TimelineModule$FetchTimelineSectionMethodProvider(TimelineModule paramTimelineModule)
  {
  }

  public FetchTimelineSectionMethod a()
  {
    return new FetchTimelineSectionMethod((GraphQLStoryHelper)b(GraphQLStoryHelper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.FetchTimelineSectionMethodProvider
 * JD-Core Version:    0.6.0
 */