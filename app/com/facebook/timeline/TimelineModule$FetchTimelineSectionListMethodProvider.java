package com.facebook.timeline;

import android.content.res.Resources;
import com.facebook.feed.protocol.FetchTimelineSectionListMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class TimelineModule$FetchTimelineSectionListMethodProvider extends AbstractProvider<FetchTimelineSectionListMethod>
{
  private TimelineModule$FetchTimelineSectionListMethodProvider(TimelineModule paramTimelineModule)
  {
  }

  public FetchTimelineSectionListMethod a()
  {
    return new FetchTimelineSectionListMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineModule.FetchTimelineSectionListMethodProvider
 * JD-Core Version:    0.6.0
 */